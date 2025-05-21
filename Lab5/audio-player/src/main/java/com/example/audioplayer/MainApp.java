package com.example.audioplayer;

import com.example.audioplayer.model.TrackDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/audioplayer/main.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Аудиопроигрыватель");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
