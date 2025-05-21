package com.example.audioplayer.model;

import java.time.LocalDateTime;

public class Track {
    private String name;
    private LocalDateTime addedDate;

    public Track(String name, LocalDateTime addedDate) {
        this.name = name;
        this.addedDate = addedDate;
    }

    public String getName() { return name; }
    public LocalDateTime getAddedDate() { return addedDate; }
}
