package com.example.audioplayer.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;

public class TrackDAO {
    private static final String URL = "jdbc:sqlite:tracks.db";

    static {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS tracks (id INTEGER PRIMARY KEY, name TEXT, date TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveTrack(Track track) {
        String sql = "INSERT INTO tracks(name, date) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, track.getName());
            pstmt.setString(2, track.getAddedDate().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Track> getAllTracks() {
        ObservableList<Track> list = FXCollections.observableArrayList();
        String sql = "SELECT name, date FROM tracks";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Track(rs.getString("name"), LocalDateTime.parse(rs.getString("date"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
