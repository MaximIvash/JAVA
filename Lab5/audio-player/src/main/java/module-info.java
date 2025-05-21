module com.example.audioplayer {
    requires java.sql;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires org.xerial.sqlitejdbc;



    exports com.example.audioplayer;
    exports com.example.audioplayer.controller;
    exports com.example.audioplayer.model;

    opens com.example.audioplayer to javafx.fxml;
    opens com.example.audioplayer.controller to javafx.fxml;
    opens com.example.audioplayer.model to javafx.base;
}
