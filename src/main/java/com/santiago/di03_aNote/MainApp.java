package com.santiago.di03_aNote;

import com.santiago.di03_aNote.controlador.aNoteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Cargador del FXML de la escena
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("aNote.fxml"));

        // Carga la escena a partir del FXML, y la configura
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("aNote");

        // Carga el controlador de la escena
        aNoteController controller = fxmlLoader.getController();

        // Pasa el stage a la escena (esto es por si en el futuro se necesitase cambiar de escena)
        Escenario escenario = new Escenario(stage);
        controller.setStage(escenario);

        // Fija el tamaño minimo de la ventana
        stage.setMinWidth(980);
        stage.setMinHeight(600);

        // Pone la escena dentro del escenario y la muestra
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}