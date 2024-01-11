package com.santiago.di03_aNote.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public record Bloc (StringProperty title, ArrayList<Section> sections) {
    public Bloc {
        if (title == null) {
            throw new IllegalArgumentException("nombre no puede ser null");
        }
        if (sections == null) {
            throw new IllegalArgumentException("sections no puede ser null");
        }
    }

    public Bloc(String title) {
        this(new SimpleStringProperty(title), new ArrayList<>());
    }

}