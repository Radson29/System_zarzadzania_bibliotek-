package com.example.biblioteka;

import connect.ConnectionDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/logowanie.fxml"));
        String css=this.getClass().getResource("/styles/style.css").toExternalForm();;
        stage.setResizable(false);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();

        stage.getIcons().add(new Image("C:/Users/Dell/Desktop/Projekt_Biblioteka/src/main/resources/images/books.png"));
        stage.setTitle("Biblioteka");

    }

    public static void main(String[] args) {
        System.out.println("Uruchomiono aplikacje");
        launch();
    }
}