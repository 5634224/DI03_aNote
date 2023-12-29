package com.santiago.di03_aNote;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class aNoteController implements Initializable {

    /*===================== CAMPOS MIOS =====================*/
    private ArrayList<ArrayList<HashMap<String, String>>> blocs = new ArrayList<>();

    /*===================== CAMPOS SCENEBUILDER =====================*/
    private Escenario stage;
    @FXML
    private MenuItem menuItemAbrir;
    @FXML
    private MenuItem menuItemGuardar;
    @FXML
    private MenuItem menuItemGuardarComo;
    @FXML
    private MenuItem menuItemImprimir;
    @FXML
    private MenuItem menuItemCerrar;
    @FXML
    private MenuItem menuItemSeleccionarTodo;
    @FXML
    private MenuItem menuItemCopiar;
    @FXML
    private MenuItem menuItemCortar;
    @FXML
    private MenuItem menuItemPegar;
    @FXML
    private MenuItem menuItemAcercaDe;
    @FXML
    private Button btnPegar;
    @FXML
    private Button btnCopiar;
    @FXML
    private Button btnCortar;
    @FXML
    private Button btnNegrita;
    @FXML
    private Button btnCursiva;
    @FXML
    private Button btnSubrayado;
    @FXML
    private ComboBox comboBoxFuente;
    @FXML
    private ComboBox comboBoxTamanoFuente;
    @FXML
    private Button btnDisminuirSangria;
    @FXML
    private Button btnAumentarSangria;
    @FXML
    private Button btnUnorderedList;
    @FXML
    private Button btnOrderedList;
    @FXML
    private Button btnAlinearIzquierda;
    @FXML
    private Button btnAlinearCentrado;
    @FXML
    private Button btnAlinearDerecha;
    @FXML
    private Button btnAlinearJustificado;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnInsertarSaltoPagina;
    @FXML
    private Button btnInsertarTabla;
    @FXML
    private Button btnInsertarImagen;
    @FXML
    private Button btnInsertarFotografia;
    @FXML
    private Button btnInsertarGrafico;
    @FXML
    private Button btnInsertarHipervinculo;
    @FXML
    private Button btnInsertarSimbolo;
    @FXML
    private Button btnZoomAcercar;
    @FXML
    private Button btnZoomAlejar;
    @FXML
    private Button btnZoom100x100;
    @FXML
    private CheckBox checkBoxRegla;
    @FXML
    private CheckBox checkBoxBarraEstado;
    @FXML
    private Button btnZoomAcercar1;
    @FXML
    private Button btnZoomAlejar1;
    @FXML
    private Button btnZoom100x1001;
    @FXML
    private CheckBox checkBoxRegla1;
    @FXML
    private CheckBox checkBoxBarraEstado1;
    @FXML
    private TabPane tbBlocs;
    @FXML
    private TabPane tbBloc1_paginas;
    @FXML
    private TextField txtBloc1_pag1_titulo;
    @FXML
    private TextField txtBloc1_pag2_titulo;
    @FXML
    private TabPane tbBloc2_paginas;
    @FXML
    private TextField txtBloc2_pag1_titulo;
    @FXML
    private TextField txtBloc2_pag2_titulo;
    @FXML
    private TreeView treeBloc1Pagina1;
    @FXML
    private TreeView treeBloc1Pagina2;
    @FXML
    private TreeView treeBloc2Pagina1;
    @FXML
    private TreeView treeBloc2Pagina2;

    /*==================== MÉTODOS ====================*/
    public void setStage(Escenario stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Rellenamos el ComboBox de la fuente
        comboBoxFuente.getItems().addAll("Arial", "Calibri", "Comic Sans MS", "Courier New", "Georgia", "Impact", "Lucida Console", "Lucida Sans Unicode", "Palatino Linotype", "Tahoma", "Times New Roman", "Trebuchet MS", "Verdana");
        comboBoxFuente.getSelectionModel().selectFirst();

        // Rellenamos el ComboBox del tamaño de la fuente
        comboBoxTamanoFuente.getItems().addAll("8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "28", "32", "36", "40", "44", "48", "54", "60", "66", "72", "80", "88", "96");
        comboBoxTamanoFuente.getSelectionModel().select(4);

        // Rellenamos los TreeView de las paginas de los blocs de notas
        initializeTreeBloc1Pagina1();
        initializeTreeBloc1Pagina2();
        initializeTreeBloc2Pagina1();
        initializeTreeBloc2Pagina2();
    }

    public void initializeTreeBloc1Pagina1() {
        // Nodo raiz
        TreeItem<String> rootItem = new TreeItem<>();

        // Nodos tallo
        TreeItem<String> branchItem1 = new TreeItem<>("Avion 1");
        TreeItem<String> branchItem2 = new TreeItem<>("Avion 2");

        // Nodos hoja
        TreeItem<String> leafItem1 = new TreeItem<>("Detalles 1");
        TreeItem<String> leafItem2 = new TreeItem<>("Detalles 2");

        // Agrega todos los nodos al treeView
        branchItem1.getChildren().addAll(leafItem1);
        branchItem2.getChildren().addAll(leafItem2);

        rootItem.getChildren().addAll(branchItem1, branchItem2);

        treeBloc1Pagina1.setRoot(rootItem);

        // Ajustes adicionales
        rootItem.setExpanded(true);
        treeBloc1Pagina1.setShowRoot(false); // Tengo que cambiar el nombre para que no se confunda con el treeView de la otra pestaña
        treeBloc1Pagina1.getSelectionModel().select(branchItem1);
//        treeBloc1Pagina1.getSelectionModel().selectedItemProperty().addListener(treeBloc1Pagina1_selectedItem);
        treeBloc1Pagina1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> treeBloc1Pagina1_selectedItem((TreeItem<String>) newValue));
    }

    public void initializeTreeBloc1Pagina2() {
        // Nodo raiz
        TreeItem<String> rootItem = new TreeItem<>();

        // Nodos tallo
        TreeItem<String> branchItem1 = new TreeItem<>("Hoy");
        TreeItem<String> branchItem2 = new TreeItem<>("Mañana");

        // Nodos hoja
        TreeItem<String> leafItem1 = new TreeItem<>("Detalles 1");
        TreeItem<String> leafItem2 = new TreeItem<>("Detalles 2");

        // Agrega todos los nodos al treeView
        branchItem1.getChildren().addAll(leafItem1);
        branchItem2.getChildren().addAll(leafItem2);

        rootItem.getChildren().addAll(branchItem1, branchItem2);

        treeBloc1Pagina2.setRoot(rootItem);

        // Ajustes adicionales
        rootItem.setExpanded(true);
        treeBloc1Pagina2.setShowRoot(false);
        treeBloc1Pagina2.getSelectionModel().select(branchItem1);
    }

    public void initializeTreeBloc2Pagina1() {
        // Nodo raiz
        TreeItem<String> rootItem = new TreeItem<>();

        // Nodos tallo
        TreeItem<String> branchItem1 = new TreeItem<>("Idea 1");
        TreeItem<String> branchItem2 = new TreeItem<>("Idea 2");

        // Nodos hoja
        TreeItem<String> leafItem1 = new TreeItem<>("Detalles 1");
        TreeItem<String> leafItem2 = new TreeItem<>("Detalles 2");

        // Agrega todos los nodos al treeView
        branchItem1.getChildren().addAll(leafItem1);
        branchItem2.getChildren().addAll(leafItem2);

        rootItem.getChildren().addAll(branchItem1, branchItem2);

        treeBloc2Pagina1.setRoot(rootItem);

        // Ajustes adicionales
        rootItem.setExpanded(true);
        treeBloc2Pagina1.setShowRoot(false);
        treeBloc2Pagina1.getSelectionModel().select(branchItem1);
    }

    public void initializeTreeBloc2Pagina2() {
        // Nodo raiz
        TreeItem<String> rootItem = new TreeItem<>();

        // Nodos tallo
        TreeItem<String> branchItem1 = new TreeItem<>("Empresa 1");
        TreeItem<String> branchItem2 = new TreeItem<>("Empresa 2");

        // Nodos hoja
        TreeItem<String> leafItem1 = new TreeItem<>("Detalles 1");
        TreeItem<String> leafItem2 = new TreeItem<>("Detalles 2");

        // Agrega todos los nodos al treeView
        branchItem1.getChildren().addAll(leafItem1);
        branchItem2.getChildren().addAll(leafItem2);

        rootItem.getChildren().addAll(branchItem1, branchItem2);

        treeBloc2Pagina2.setRoot(rootItem);

        // Ajustes adicionales
        rootItem.setExpanded(true);
        treeBloc2Pagina2.setShowRoot(false);
        treeBloc2Pagina2.getSelectionModel().select(branchItem1);
    }

    public void updateBlocs() {
        // Limpiar el ArrayList existente
        blocs.clear();

        // Iterar sobre cada TabPane (bloc)
        for (TabPane tabPane : new TabPane[]{tbBloc1_paginas, tbBloc2_paginas}) {
            ArrayList<HashMap<String, String>> bloc = new ArrayList<>();

            // Iterar sobre cada Tab (página) en el TabPane actual
            for (Tab tab : tabPane.getTabs()) {
                HashMap<String, String> page = new HashMap<>();

                // Obtener los elementos TextField para el título y el contenido de la página
                TextField titleField = (TextField) ((AnchorPane) tab.getContent()).getChildren().get(0);
                TextArea contentArea = (TextArea) ((AnchorPane) tab.getContent()).getChildren().get(1);

                // Agregar el título y el contenido de la página al HashMap
                page.put("title", titleField.getText());
                page.put("content", contentArea.getText());

                // Agregar la página al bloc
                bloc.add(page);
            }

            // Agregar el bloc al ArrayList de blocs
            blocs.add(bloc);
        }
    }

    @FXML
    public void txtBloc1_pag1_onInputTyped(Event event) {
//        tbBloc1_paginas.getTabs().get(0).setText(txtBloc1_pag1.getText().toString());
        TreeItem item = (TreeItem) treeBloc1Pagina1.getSelectionModel().getSelectedItem();
        if (item != null) item.setValue(txtBloc1_pag1_titulo.getText().toString());
        updateBlocs();
    }

    @FXML
    public void txtBloc1_pag2_onInputTyped(Event event) {
//        tbBloc1_paginas.getTabs().get(1).setText(txtBloc1_pag2.getText().toString());
        TreeItem item = (TreeItem) treeBloc1Pagina2.getSelectionModel().getSelectedItem();
        if (item != null) item.setValue(txtBloc1_pag2_titulo.getText().toString());
        updateBlocs();
    }

    @FXML
    public void txtBloc2_pag1_onInputTyped(Event event) {
//        tbBloc2_paginas.getTabs().get(0).setText(txtBloc2_pag1.getText().toString());
        MenuItem item = (MenuItem) treeBloc2Pagina1.getSelectionModel().getSelectedItem();
        if (item != null) item.setText(txtBloc2_pag1_titulo.getText().toString());
        updateBlocs();
    }

    @FXML
    public void txtBloc2_pag2_onInputTyped(Event event) {
//        tbBloc2_paginas.getTabs().get(1).setText(txtBloc2_pag2.getText().toString());
        MenuItem item = (MenuItem) treeBloc2Pagina2.getSelectionModel().getSelectedItem();
        if (item != null) item.setText(txtBloc2_pag2_titulo.getText().toString());
        updateBlocs();
    }

    public void treeBloc1Pagina1_selectedItem(TreeItem<String> selectedItem) {
        // Obtiene el índice del nodo seleccionado
        int selectedIndex = treeBloc1Pagina1.getSelectionModel().getSelectedIndex();

        // Verifica si el índice es válido
        if (selectedIndex >= 0 && selectedIndex < blocs.get(0).size()) {
            // Obtiene los datos de la página seleccionada
            HashMap<String, String> pageData = blocs.get(0).get(selectedIndex);

            // Carga los datos en los elementos gráficos
            txtBloc1_pag1_titulo.setText(pageData.get("title"));

            // Aquí debes agregar el código para cargar el contenido de la página en el área de texto correspondiente
            

        }
    }
}