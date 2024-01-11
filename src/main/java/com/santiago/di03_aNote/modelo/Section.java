package com.santiago.di03_aNote.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public record Section (StringProperty title, ArrayList<Page> pages) {
    public Section {
        if (title == null) {
            throw new IllegalArgumentException("nombre no puede ser null");
        }
        if (pages == null) {
            throw new IllegalArgumentException("pages no puede ser null");
        }
    }

    public Section(String title) {
        this(new SimpleStringProperty(title), new ArrayList<>());
    }
}