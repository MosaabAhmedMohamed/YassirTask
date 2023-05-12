## YassirTask

A simple app that displays list of trending movies.

## Challenge description
- Code sample for display list of trending movie and it's details. 
- App consists of 2 screens 1st is for movies list and 2nd is for movie details.
- App load and cache the movies and it's details in local data storge.


## What i have done
I started working on it by migrating gradle files to kotlin dsl then modeling the project to clean architecture ( core, app, data, domain, presentation) modules ,
applied clean architecture with MVI design pattern used Coroutines with Flow to handle heavy operations on the background thread,
Dagger 2 And Hilt for dependency injection, 
enabled proguard for obfuscating and securing the code base, 
used different branches to implement and refactor the features to avoid conflicts.

## Screenshot
<img src="https://user-images.githubusercontent.com/32736722/197438506-6effd556-9568-4021-9dba-46e434ab368c.jpg" width="300">|
<img src="https://user-images.githubusercontent.com/32736722/197438456-abcf0e71-6869-4537-9f92-8179e82d75f8.jpg" width="300">|


## Download
[APK](https://github.com/MosaabAhmedMohamed/Bluetooth_Task/blob/master/Bluetooth%20Task.apk)


## Specifications
- portrait and landscape.
- Clean architecture.
- MVI
- Coroutines
- Flow
- Usecases (part of clean architecture)
- View State
- Partly include comments.
- Reactive code
- Kotlin DSL
- Enabling ProGuard
- Paging 3
- Dagger Hilt
- Jetpack Compose
- Modularization

## Languages, libraries and tools used

 * [Kotlin](https://kotlinlang.org/)
 * [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=CjwKCAjwx_eiBhBGEiwA15gLNzq_E_R3QU3oiCLF2BXBQTH9heyjMdTZTedoSLFwALpclmoBzCEfOhoCzuQQAvD_BwE&gclsrc=aw.ds)
 * [Dagger Hilt](https://dagger.dev/hilt/)
 * [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
 
 
## Requirements
- min SDK 21

## Installation
YassirTask requires Android Studio version 3.6 or higher.

## Implementation

* In this project I'm using [Clean architecture with MVI Pattern](https://developer.android.com/jetpack/docs/guide)
as an application architecture adopted with usage of UseCases with these design patterns in mind:-
- Repository Pattern
- Singleton
- Adapters

* Using Dagger2 or Hilt for dependency injection that will make testing easier and make our code 
cleaner and more readable and handy when creating dependecies.
* Separation of concerns : The most important principle used in this project to avoid many lifecycle-related problems.
<img src="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png"></a>
* Each component depends only on the component one level below it. For example, activities and Views depend only on a view model. The repository is the only class that depends on multiple other classes; in this example, the repository depends on a persistent data model and a remote backend data source.
This design creates a consistent and pleasant user experience. Regardless of whether the user comes back to the app several minutes after they've last closed it or several days later, they instantly see a user's information that the app persists locally. If this data is stale, the app's repository module starts updating the data in the background.
* Using to best of managing ViewState with less complex tools , using Sealed Classes and LiveData we created a solid source that we can expose to view to show what the app can do to the user without worrying about the side effects
```
class MoviesContract {

    data class State(
        val movies: Flow<PagingData<MovieUiModel>> = flow { PagingData.empty<MovieUiModel>() },
        ) : ViewState

    sealed class Event : ViewEvent {
        data class OnItemClick(val movieUiModel: MovieUiModel) : Event()
    }

    object Navigation {
        object Routes {
            const val MY_HOME = "myHome"
        }
    }

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            data class ToMovieDetails(val movieId: Long) : Effect()
        }
    }

}
```
A View will a) emit its event to a ViewModel, and b) subscribes to this ViewModel in order to receive states needed to render its own UI.


Then ViewModel starts to delegate the event to it's suitable UseCase with thread handling in mind using RxJava (Logic Holders for each case)

```
 suspend fun loadMovies() {
        if (isInitialized) return

        val flow = getMoviesUseCase.loadMovies()
            .flowOn(dispatchers.io)
            .map { it.map { it.mapToUi() } }
            .cachedIn(viewModelScope)

        setState { copy(movies = flow) }

        // Update isInitialized flag
        isInitialized = true
    }
```
As the UseCase process and get the required models form the repository it returns the result back to the ViewModel to start Exposing it as Flow to our Lifecycle Owner (Activity)   

```
class GetMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {

    suspend fun loadMovies() = moviesRepository.loadMovies()
}

```
          

then back to our View it will listen for any change in our state() ( ViewState Holder) and React to it.

```
 // Render movies content
    MoviesContentContainer(
        state = viewModel.viewState.value,
        onEvent = viewModel::setEvent
    )
```

```
   val moviesState = state.movies.collectAsLazyPagingItems()

   when(moviesState.itemCount){
            0-> {
            
            // Handle Loading error state 
                Column {
                    PagingState(
                        loadState = moviesState.loadState.mediator,
                        itemCount = moviesState.itemCount,
                        onRefresh = { moviesState.refresh() }
                    )
                }
            }else->{
            
            // Movies list
            MoviesList(
                movies = moviesState,
                onItemClick = { _, item ->
                    onEvent(Event.OnItemClick(item))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                )
            }
        }
```

## Immutability
Data immutability is embraced to help keeping the logic simple. Immutability means that we do not need to manage data being mutated in other methods, in other threads, etc; because we are sure the data cannot change. Data immutability is implemented with LiveData class.

## ViewModel LifeCycle
The ViewModel should outlive the View on configuration changes. For instance, on rotation, the Activity gets destroyed and recreated but your ViewModel should not be affected by this. If the ViewModel was to be recreated as well, all the ongoing tasks and cached latest ViewState would be lost.
We use the Architecture Components library to instantiate our ViewModel in order to easily have its lifecycle correctly managed.
