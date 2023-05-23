# Veedeo2
### Goal : Learn Jetpack Compose
#### Step1 : Build a rich native app without jetpack compose.
#### Step2 : Rebuild the same app with jetpack compose.
#### Step3 : create a step by step guide to migrate / learn compose !

## Simple Video Player App.

#### Features :
-Feed of popular videos.	

-Search videos.

#### Tech Stack :
3 modules for easy reusability !

-MVVM architecture : Fragment / ViewModel / UseCases / Services / Model

-Built with kotlin.

-Koin for dependency injection.

-Coroutines for threading.

-LiveData for ui updates.

-Retrofit for api requests.

-Androidx Navigation (graph).

-ExoPlayer for video playing.

#### App Module : 
Display video thumbnails, navigate towards player. init other module with DI

#### VeedeoPlayer Module :
Simple implementation of exoPlayer : navigate towards VeedeoPlayerFragment with a video uri and you got a video playing.

#### Pexels Module : 
Free videos api module, IPexelsApiService can feed a list of popular videos or search for videos by keywords.
