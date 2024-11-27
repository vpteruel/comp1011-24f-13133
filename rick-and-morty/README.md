# Rick and Morty JavaFX Application

This is a JavaFX application that uses the Rick and Morty API to display character information. The application has two main views: a dashboard and a character details view.

## Features

- **Dashboard View**: Displays three pie charts showing the distribution of characters by status, species, and gender.
- **Character Details View**: Allows users to search for characters by name and view detailed information about the selected character.

## Project Structure

```bash
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    └── main
        ├── java
        │   ├── com
        │   │   └── vinicius
        │   │       └── rickandmorty
        │   │           ├── ApiClient.java
        │   │           ├── CharacterController.java
        │   │           ├── Character.java
        │   │           ├── DashboardController.java
        │   │           ├── Episode.java
        │   │           ├── Location.java
        │   │           ├── MainApplication.java
        │   │           └── MainController.java
        │   └── module-info.java
        └── resources
            └── com
                └── vinicius
                    └── rickandmorty
                        ├── character.fxml
                        ├── dashboard.fxml
                        ├── images
                        │   ├── app-icon.png
                        │   ├── app-logo.png
                        │   └── app-logo-text.png
                        ├── json
                        │   ├── character.json
                        │   ├── episode.json
                        │   └── location.json
                        └── main.fxml
```
