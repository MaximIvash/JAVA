package com.example.audioplayer.controller;

import com.example.audioplayer.model.Track;
import com.example.audioplayer.model.TrackDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class HistoryController {
    @FXML
    private TableView<Track> trackTable;
    @FXML private TableColumn<Track, String> nameColumn;
    @FXML private TableColumn<Track, String> dateColumn;

    @FXML
    public void initialize() {
        trackTable.setPrefWidth(600); // Можно указать любое нужное значение
        nameColumn.setPrefWidth(300); // Пропорционально поделите между колонками
        dateColumn.setPrefWidth(300);

        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAddedDate().toString()));
        trackTable.setItems(TrackDAO.getAllTracks());
    }


    @FXML
    private void onBack() {
        Stage stage = (Stage) trackTable.getScene().getWindow();
        stage.close();
    }
}
