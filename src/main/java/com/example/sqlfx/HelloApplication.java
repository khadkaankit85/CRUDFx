package com.example.sqlfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());


        // Load and apply the CSS file
        String stylesheetPath = getClass().getResource("/Styles/main.css").toExternalForm();
        scene.getStylesheets().add(stylesheetPath);

        // Set fullscreen and show the stage
        stage.setFullScreen(true);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}