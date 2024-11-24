# Android Architecture Patterns with Jetpack Compose

This repository demonstrates several mobile architecture patterns implemented in **Kotlin** using **Jetpack Compose**. The goal is to showcase architecture patterns, helping developers understand how to structure Android applications more effectively.

## Architectures Overview

- **MVVM (Model-View-ViewModel)**: Separates concerns into Model, View, and ViewModel layers.
- **MVI (Model-View-Intent)**: Implements a unidirectional data flow, where user intents are transformed into view states.
- **MVC (Model-View-Controller)**: Classic pattern where UI and data-access mechanism(Model) are tightly coupled. *(Not supported in jetpack compose)*
- **MVP (Model-View-Presenter)**: A more structured variant of MVC where presenter class manages one View at a time. *(Not supported in jetpack compose)*

![image](https://github.com/user-attachments/assets/83f4455e-a34b-459a-92bf-a4f250ca5129)

## MVVM (Model-View-ViewModel)

![MVVM](https://github.com/user-attachments/assets/2f3bec49-2749-488f-9b4d-ab16d453b0b3 )

### MVVM
- **Model:** This layer is responsible for the abstraction of the data sources. Model and ViewModel work together to get and save the data.
- **View:** The purpose of this layer is to inform the ViewModel about the user’s action. This layer observes the ViewModel and does not contain any kind of application logic.
- **ViewModel:** It exposes those data streams which are relevant to the View. Moreover, it servers as a link between the Model and the View.

### Features:
- Using ViewModel fuctions directly in view: ```viewModel.fetchData()```
- Multiple states in ViewModel describes the UI.

## MVI (Model-View-Intent)

![MVI](https://github.com/user-attachments/assets/27155167-d5f0-471b-849d-2529bc5e8007)

### MVI
- **Model:** represents the state of the app.
- **View:** displays the state and sends user intents to the ViewModel.
- **Intent:** describes actions that the user can take, which result in state changes.

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

![image](https://github.com/user-attachments/assets/6d362156-da6a-491e-8801-dd9560da6f41)

### MVC
- **Model:** This component stores the application data. It has no knowledge about the interface. The model is responsible for handling the domain logic(real-world business rules) and communication with the database and network layers.
- **View:** It is the UI(User Interface) layer that holds components that are visible on the screen. Moreover, it provides the visualization of the data stored in the Model and offers interaction to the user.
- **Controller:** This component establishes the relationship between the View and the Model. It contains the core application logic and gets informed of the user’s response and updates the Model as per the need.
  
### Features:
- Jetpack Compose is not well-suited for this pattern due to its declarative nature, which blurs the boundaries between view and logic.
- Does not automate data synchronization between UI and Model (doesn't use states):
```kotlin
private fun updateUI(weather: Weather) {
        // Update UI elements with data
        textViewTemperature.text = weather.temperature.toString()
        textViewDescription.text = weather.description
    }
```


## MVP (Model-View-Presenter)

![image](https://github.com/user-attachments/assets/3aba4757-2324-4e9d-9099-6ea4e9cd93de)

### MVP
- **Model:** Layer for storing data. It is responsible for handling the domain logic(real-world business rules) and communication with the database and network layers.
- **View:** UI(User Interface) layer. It provides the visualization of the data and keep a track of the user’s action in order to notify the Presenter.
- **Presenter:** Fetch the data from the model and applies the UI logic to decide what to display. It manages the state of the View and takes actions according to the user’s input notification from the View.

### Features:
- Jetpack Compose is not well-suited for MVP because its declarative UI model inherently couples the UI state with the data layer, making the Presenter layer redundant.
- MVP views should be easy to replace with alternative implementations.
- MVP views should be reusable (can't be tightly coupled to the presenter) without its presenter
- To establish communication between View-Presenter and Presenter-Model, an interface is needed:
```kotlin
interface Contract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun setString(string: String?)
    }
    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }
        fun getNextCourse(onFinishedListener: OnFinishedListener?)
    }
    interface Presenter {
        fun onButtonClick()
        fun onDestroy()
    }
}
```

## Installation

1. Clone the repository:
```bash
git clone https://github.com/AdamDawi/Architecture-patterns-in-android
```
2. Open the project in Android Studio.

## Author

Adam Dawidziuk🧑‍💻
