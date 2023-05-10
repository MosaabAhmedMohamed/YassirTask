package com.example.presentation.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.util.AppException
import com.example.core.util.DispatcherProvider
import com.example.core.util.NetworkErrorMapper
import com.example.presentation.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.apache.http.conn.ConnectTimeoutException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewSideEffect>(
    protected val globalState: IGlobalState,
    private val dispatchers: DispatcherProvider,
) : ViewModel() {

    abstract fun setInitialState(): UiState
    abstract fun handleEvents(event: Event)

    private val initialState: UiState by lazy { setInitialState() }

    private val _viewState: MutableState<UiState> = mutableStateOf(initialState)
    val viewState: State<UiState> = _viewState

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        viewModelScope.launch(dispatchers.io) {
            _event.collect {
                handleEvents(it)
            }
        }
    }

    fun setEvent(event: Event) {
        viewModelScope.launch(dispatchers.io) { _event.emit(event) }
    }

    protected fun setState(reducer: UiState.() -> UiState) {
        val newState = viewState.value.reducer()
        _viewState.value = newState
    }

    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch(dispatchers.io) { _effect.send(effectValue) }
    }

    fun <T> executeCatching(
        block: suspend () -> T,
        onError: ((Throwable, String) -> Unit)? = null,
        withLoading: Boolean = true
    ) {
        viewModelScope.launch(dispatchers.io) {
            try {
                if (withLoading) globalState.loading(true)
                block.invoke()
                if (withLoading) globalState.loading(false)
            } catch (e: kotlin.coroutines.cancellation.CancellationException) {
                onError?.invoke(e, "")
            } catch (e: java.util.concurrent.CancellationException) {
                onError?.invoke(e, "")
            } catch (e: kotlinx.coroutines.CancellationException) {
                onError?.invoke(e, "")
            } catch (throwable: Throwable) {
                if (BuildConfig.DEBUG) throwable.printStackTrace()
                val errorMessage = when (throwable) {
                    is AppException -> {
                        throwable.errorMessage
                    }
                    is UnknownHostException -> {
                        "No internet connection, please check your connection and try again."
                    }
                    is SocketTimeoutException,
                    is java.net.SocketTimeoutException,
                        // is HttpRequestTimeoutException,
                    is ConnectTimeoutException -> {
                        "Looks like the server is taking too long to respond, please try again later."
                    }
                    else -> {
                        NetworkErrorMapper().mapThrowable(throwable).errorMessage
                    }
                }
                globalState.error(errorMessage, withLoading)
                onError?.invoke(throwable, errorMessage)
            } catch (e: Exception) {
                val errorMessage = NetworkErrorMapper().mapThrowable(e).errorMessage
                globalState.error(errorMessage, withLoading)
                onError?.invoke(e, errorMessage)
            }
        }
    }

    fun <T> executeSilent(
        block: suspend () -> T,
        onError: (() -> Unit)? = null,
        onComplete: (() -> Unit)? = null,
        scope: CoroutineScope = viewModelScope
    ) {
        scope.launch(dispatchers.io) {
            try {
                block.invoke()
            } catch (throwable: Throwable) {
                if (BuildConfig.DEBUG) throwable.printStackTrace()
                onError?.invoke()
            }
            onComplete?.invoke()
        }
    }
}


interface IGlobalState {
    val loadingState: State<Boolean>
    val errorState: State<String?>
    val successState: State<String?>
    val appLoaded: State<Boolean>

    fun idle()
    fun loading(show: Boolean)
    fun error(msg: String, hideLoading: Boolean = true)
    fun error(msgs: List<String>, hideLoading: Boolean = true)
    fun success(msg: String, hideLoading: Boolean = true)
    fun appLoaded()
}

class GlobalState : IGlobalState {
    override val loadingState = mutableStateOf(false)
    override val errorState = mutableStateOf<String?>(null)
    override val successState = mutableStateOf<String?>(null)
    override val appLoaded = mutableStateOf(false)

    override fun idle() {
        loadingState.value = false
        errorState.value = null
        successState.value = null

    }

    override fun loading(show: Boolean) {
        errorState.value = null
        successState.value = null
        loadingState.value = show
    }

    override fun error(msg: String, hideLoading: Boolean) {
        if (hideLoading) loadingState.value = false
        successState.value = null
        errorState.value = msg
    }

    override fun error(msgs: List<String>, hideLoading: Boolean) {
        if (hideLoading) loadingState.value = false
        successState.value = null
        errorState.value = msgs.joinToString("\n")
    }

    override fun success(msg: String, hideLoading: Boolean) {
        if (hideLoading) loadingState.value = false
        errorState.value = null
        successState.value = msg
    }

    override fun appLoaded() {
        appLoaded.value = true
    }
}