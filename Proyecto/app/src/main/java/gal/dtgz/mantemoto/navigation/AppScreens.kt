package gal.dtgz.mantemoto.navigation

sealed class AppScreens(val route: String){
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
    object TutorialScreen1: AppScreens("Tutorial_Screen1")
    object TutorialScreen2: AppScreens("Tutorial_Screen2")
    object TutorialScreen3: AppScreens("Tutorial_Screen3")
}