package com.example.audioplayer.controller;

import com.example.audioplayer.model.Track;
import com.example.audioplayer.model.TrackDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class MainController {
    @FXML
    private TextField trackNameField;
    private MediaPlayer mediaPlayer;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/audioplayer/history.fxml"));

    @FXML
    private void onLoadTrack() {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            Media media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            trackNameField.setText(file.getName());
            TrackDAO.saveTrack(new Track(file.getName(), LocalDateTime.now()));
        }
    }

    @FXML
    private void onPlay() {
        if (mediaPlayer != null) mediaPlayer.play();
    }

    @FXML
    private void onPause() {
        if (mediaPlayer != null) mediaPlayer.pause();
    }

    @FXML
    private void onStop() {
        if (mediaPlayer != null) mediaPlayer.stop();
    }

    @FXML
    private void onShowHistory() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/audioplayer/history.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("История");
        stage.show();
    }
}
