# Android Architecture Patterns with Jetpack Compose

This repository demonstrates several mobile architecture patterns implemented in **Kotlin** using **Jetpack Compose**. The goal is to showcase architecture patterns, helping developers understand how to structure Android applications more effectively.

## Architectures Overview

- **MVVM (Model-View-ViewModel)**: Separates concerns into Model, View, and ViewModel layers.
- **MVI (Model-View-Intent)**: Utilizes a unidirectional data flow with distinct intents and states.
- **MVC (Model-View-Controller)**: Classic pattern that divides logic into controller, view, and model components. *(Coming soon)*
- **MVP (Model-View-Presenter)**: A more structured variant of MVC where the presenter handles the business logic. *(Coming soon)*

## MVVM (Model-View-ViewModel)

![MVVM](https://github.com/user-attachments/assets/2f3bec49-2749-488f-9b4d-ab16d453b0b3 )

### MVVM
- **Model** handles the data and business logic.
- **View** displays the states and reacts to changes in the ViewModel.
- **ViewModel** serves as a bridge between the Model and View, managing UI-related data and handling user inputs.

### Features:
- Using ViewModel fuctions directly in view: ```viewModel.fetchData()```
- Multiple states in ViewModel describes the UI.

## MVI (Model-View-Intent)

![MVI](https://github.com/user-attachments/assets/27155167-d5f0-471b-849d-2529bc5e8007)

### MVI
- **Model** represents the state of the app.
- **View** displays the state and sends user intents to the ViewModel.
- **Intent** describes actions that the user can take, which result in state changes.

### Features:
- Using intent to specify user action making it easy to track user interactions in ViewModel with when statement:
```kotlin
when(event){
  MainScreenIntent.FetchData -> { /* handle fetching */ }
  MainScreenIntent.ObserveData -> { /* handle observing */ }
}
```
- Only one public function in ViewModel: ```viewModel.onEvent()```
- One state stored in ViewModel that fully describes the UI:
```kotlin
data class MainViewState(
    val loading: Boolean = false,
    val data: List<Data> = emptyList(),
    val error: String? = null
)
```

## MVC (Model-View-Controller)
*In progress*

## MVP (Model-View-Presenter)
*In progress*

## Installation

1. Clone the repository:
```bash
git clone https://github.com/AdamDawi/Architecture-patterns-in-android
```
2. Open the project in Android Studio.

## Author

Adam Dawidziuk🧑‍💻
