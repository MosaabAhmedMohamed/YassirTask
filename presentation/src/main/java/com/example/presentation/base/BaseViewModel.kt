package com.example.presentation.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.util.*
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
        onError: ((Throwable, AppException) -> Unit)? = null,
        withLoading: Boolean = true
    ) {
        viewModelScope.launch(dispatchers.io) {
            try {
                if (withLoading) globalState.loading(true)
                block.invoke()
                if (withLoading) globalState.loading(false)
            } catch (throwable: Throwable) {
                if (BuildConfig.DEBUG) throwable.printStackTrace()
                val error = when (throwable) {
                    is AppException -> {
                        throwable
                    }
                    is UnknownHostException -> {
                        NoConnectionException()
                    }
                    is SocketTimeoutException,
                    is java.net.SocketTimeoutException,
                        // is HttpRequestTimeoutException,
                    is ConnectTimeoutException -> {
                        TimeOutException()
                    }
                    else -> {
                        NetworkErrorMapper().mapThrowable(throwable)
                    }
                }
                globalState.error(error, withLoading)
                onError?.invoke(throwable, error)
            } catch (e: Exception) {
                val error = NetworkErrorMapper().mapThrowable(e)
                globalState.error(error, withLoading)
                onError?.invoke(e, error)
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
    val errorState: State<AppException?>
    val successState: State<String?>
    val appLoaded: State<Boolean>

    fun idle()
    fun loading(show: Boolean)
    fun error(error: AppException, hideLoading: Boolean = true)
    fun error(msgs: List<AppException>, hideLoading: Boolean = true)
    fun success(msg: String, hideLoading: Boolean = true)
    fun appLoaded()
}

class GlobalState : IGlobalState {
    override val loadingState = mutableStateOf(false)
    override val errorState = mutableStateOf<AppException?>(null)
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

    override fun error(error: AppException, hideLoading: Boolean) {
        if (hideLoading) loadingState.value = false
        successState.value = null
        errorState.value = error
    }

    override fun error(msgs: List<AppException>, hideLoading: Boolean) {
        if (hideLoading) loadingState.value = false
        successState.value = null
        errorState.value = msgs.last()
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