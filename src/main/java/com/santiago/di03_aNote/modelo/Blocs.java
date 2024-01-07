package com.santiago.di03_aNote.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public record Blocs(ArrayList<ArrayList<HashMap<String, String>>> blocs) {
    public Blocs {
        if (blocs == null) {
            throw new IllegalArgumentException("blocs no puede ser null");
        }
    }
}