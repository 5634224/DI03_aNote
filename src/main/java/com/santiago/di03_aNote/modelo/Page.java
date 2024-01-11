package com.santiago.di03_aNote.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public record Page (StringProperty title, StringProperty content, ArrayList<Page> subpages) {
    public Page {
        if (title == null) {
            throw new IllegalArgumentException("title no puede ser null");
        }
        if (content == null) {
            throw new IllegalArgumentException("content no puede ser null");
        }
    }

    public Page(String title, String content) {
        this(new SimpleStringProperty(title), new SimpleStringProperty(content), new ArrayList<>());
    }

    public Page(String title) {
        this(title, "");
    }
}