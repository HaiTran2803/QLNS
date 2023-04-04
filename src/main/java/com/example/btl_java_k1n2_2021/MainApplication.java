package com.example.btl_java_k1n2_2021;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    public MainApplication() {
    }
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Login-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 640.0D, 289.0D);
        stage.setTitle("Quản lí khách sạn");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(new String[0]);
    }
}