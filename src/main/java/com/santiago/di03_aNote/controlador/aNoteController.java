package com.santiago.di03_aNote.controlador;

import com.santiago.di03_aNote.Escenario;
import com.santiago.di03_aNote.modelo.Bloc;
import com.santiago.di03_aNote.modelo.Page;
import com.santiago.di03_aNote.modelo.Section;
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
    /**
     * ArrayList que contiene los datos de los blocs de notas
     */
    ArrayList<Bloc> blocs = new ArrayList<Bloc>(new ArrayList<>());

    /**
     * HashMap que asocia cada nodo del TreeView con su correspondiente pagina
     */
    TreeViewPagesBinding pagesBinding = new TreeViewPagesBinding();

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
    private TabPane tbBlocs;
    @FXML
    private TabPane tbBloc1_secciones;
    @FXML
    private TextField txtBloc1_seccion1_tituloPagina;
    @FXML
    private TextField txtBloc1_seccion2_tituloPagina;
    @FXML
    private TabPane tbBloc2_secciones;
    @FXML
    private TextField txtBloc2_seccion1_tituloPagina;
    @FXML
    private TextField txtBloc2_seccion2_tituloPagina;
    @FXML
    private TreeView treeBloc1Seccion1;
    @FXML
    private TreeView treeBloc1Seccion2;
    @FXML
    private TreeView treeBloc2Seccion1;
    @FXML
    private TreeView treeBloc2Seccion2;
    @FXML
    private TextArea txtBloc1_seccion1_contenidoPagina;
    @FXML
    private TextArea txtBloc1_seccion2_contenidoPagina;
    @FXML
    private TextArea txtBloc2_seccion1_contenidoPagina;
    @FXML
    private TextArea txtBloc2_seccion2_contenidoPagina;
    @FXML
    private Button btnSeleccionarPuntero;
    @FXML
    private Button btnSeleccionLazo;
    @FXML
    private Button btnLapizMuyFIno;
    @FXML
    private Button btnLapizFino;
    @FXML
    private Button btnLapizMedio;
    @FXML
    private Button btnLapizGrueso;
    @FXML
    private Button btnLapizExtraGrueso;
    @FXML
    private Button btnDibujoBorrador;
    @FXML
    private ColorPicker colorPickerLapiz;

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

        // Agregamos al modelo de datos los datos de los blocs de notas
        blocs.add(new Bloc("Bloc 1"));
        blocs.add(new Bloc("Bloc 2"));

        // Inicializamos las secciones en el modelo de datos
        blocs.get(0).sections().add(new Section("Vuelos"));
        blocs.get(0).sections().add(new Section("Meteorologia"));
        blocs.get(1).sections().add(new Section("Proyecto"));
        blocs.get(1).sections().add(new Section("FCT"));

        // Rellenamos los TreeView de las paginas de los blocs de notas
        initializeTreeBloc1Seccion1(); // Bloc 1, seccion 1
        initializeTreeBloc1Seccion2(); // Bloc 1, seccion 2
        initializeTreeBloc2Seccion1(); // Bloc 2, seccion 1)
        initializeTreeBloc2Seccion2(); // Bloc 2, seccion 2)
    }

    /**
     * Inicializa el TreeView de la sección 1 (Vuelos) del bloc 1
     */
    public void initializeTreeBloc1Seccion1() {
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

        treeBloc1Seccion1.setRoot(rootItem);

        // Ajustes adicionales del treeView
        rootItem.setExpanded(true);
        treeBloc1Seccion1.setShowRoot(false); // Tengo que cambiar el nombre para que no se confunda con el treeView de la otra pestaña
        treeBloc1Seccion1.getSelectionModel().select(branchItem1);
        treeBloc1Seccion1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> treeBloc1Seccion1_selectedPage((TreeItem<String>) newValue));

        // Crea las paginas en el modelo de datos
        blocs.get(0).sections().get(0).pages().add(new Page("Avion 1")); // Pagina Avion 1 (bloc 1, seccion 1)
        blocs.get(0).sections().get(0).pages().get(0).subpages().add(new Page("Detalles 1")); // Subpagina Detalles 1 (bloc 1, seccion 1)
        blocs.get(0).sections().get(0).pages().add(new Page("Avion 2")); // Pagina Avion 2 (bloc 1, seccion 1)
        blocs.get(0).sections().get(0).pages().get(1).subpages().add(new Page("Detalles 2")); // Subpagina Detalles 2 (bloc 1, seccion 1)

        // Añade los binding de las paginas (modelo) con los treeItems
        pagesBinding.bindBidirectional(branchItem1, blocs.get(0).sections().get(0).pages().get(0));
        pagesBinding.bindBidirectional(leafItem1, blocs.get(0).sections().get(0).pages().get(0).subpages().get(0));
        pagesBinding.bindBidirectional(branchItem2, blocs.get(0).sections().get(0).pages().get(1));
        pagesBinding.bindBidirectional(leafItem2, blocs.get(0).sections().get(0).pages().get(1).subpages().get(0));

        // Binding de la pagina (textField titulo + textArea contenido) con el modelo de datos
        treeBloc1Seccion1_selectedPage(branchItem1);
    }

    /**
     * Inicializa el TreeView de la sección 2 (Meteorologia) del bloc 1
     */
    public void initializeTreeBloc1Seccion2() {
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

        treeBloc1Seccion2.setRoot(rootItem);

        // Ajustes adicionales
        rootItem.setExpanded(true);
        treeBloc1Seccion2.setShowRoot(false);
        treeBloc1Seccion2.getSelectionModel().select(branchItem1);
        treeBloc1Seccion2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> treeBloc1Seccion2_selectedPage((TreeItem<String>) newValue));

        // Crea las paginas en el modelo de datos
        blocs.get(0).sections().get(1).pages().add(new Page("Hoy")); // Pagina Hoy (bloc 1, seccion 2)
        blocs.get(0).sections().get(1).pages().get(0).subpages().add(new Page("Detalles 1")); // Subpagina Detalles 1 (bloc 1, seccion 2)
        blocs.get(0).sections().get(1).pages().add(new Page("Mañana")); // Pagina Mañana (bloc 1, seccion 2)
        blocs.get(0).sections().get(1).pages().get(1).subpages().add(new Page("Detalles 2")); // Subpagina Detalles 2 (bloc 1, seccion 2)

        // Añade los binding de las paginas (modelo) con los treeItems
        pagesBinding.bindBidirectional(branchItem1, blocs.get(0).sections().get(1).pages().get(0));
        pagesBinding.bindBidirectional(leafItem1, blocs.get(0).sections().get(1).pages().get(0).subpages().get(0));
        pagesBinding.bindBidirectional(branchItem2, blocs.get(0).sections().get(1).pages().get(1));
        pagesBinding.bindBidirectional(leafItem2, blocs.get(0).sections().get(1).pages().get(1).subpages().get(0));

        // Binding de la pagina (textField titulo + textArea contenido) con el modelo de datos
        treeBloc1Seccion2_selectedPage(branchItem1);
    }

    /**
     * Inicializa el TreeView de la sección 1 (Proyecto) del bloc 2
     */
    public void initializeTreeBloc2Seccion1() {
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

        treeBloc2Seccion1.setRoot(rootItem);

        // Ajustes adicionales
        rootItem.setExpanded(true);
        treeBloc2Seccion1.setShowRoot(false);
        treeBloc2Seccion1.getSelectionModel().select(branchItem1);
        treeBloc2Seccion1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> treeBloc2Seccion1_selectedPage((TreeItem<String>) newValue));

        // Crea las paginas en el modelo de datos
        blocs.get(1).sections().get(0).pages().add(new Page("Idea 1")); // Pagina Idea 1 (bloc 2, seccion 1)
        blocs.get(1).sections().get(0).pages().get(0).subpages().add(new Page("Detalles 1")); // Subpagina Detalles 1 (bloc 2, seccion 1)
        blocs.get(1).sections().get(0).pages().add(new Page("Idea 2")); // Pagina Idea 2 (bloc 2, seccion 1)
        blocs.get(1).sections().get(0).pages().get(1).subpages().add(new Page("Detalles 2")); // Subpagina Detalles 2 (bloc 2, seccion 1)

        // Añade los binding de las paginas (modelo) con los treeItems
        pagesBinding.bindBidirectional(branchItem1, blocs.get(1).sections().get(0).pages().get(0));
        pagesBinding.bindBidirectional(leafItem1, blocs.get(1).sections().get(0).pages().get(0).subpages().get(0));
        pagesBinding.bindBidirectional(branchItem2, blocs.get(1).sections().get(0).pages().get(1));
        pagesBinding.bindBidirectional(leafItem2, blocs.get(1).sections().get(0).pages().get(1).subpages().get(0));

        // Binding de la pagina (textField titulo + textArea contenido) con el modelo de datos
        treeBloc2Seccion1_selectedPage(branchItem1);
    }

    /**
     * Inicializa el TreeView de la sección 2 (FCT) del bloc 2
     */
    public void initializeTreeBloc2Seccion2() {
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

        treeBloc2Seccion2.setRoot(rootItem);

        // Ajustes adicionales
        rootItem.setExpanded(true);
        treeBloc2Seccion2.setShowRoot(false);
        treeBloc2Seccion2.getSelectionModel().select(branchItem1);
        treeBloc2Seccion2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> treeBloc2Seccion2_selectedPage((TreeItem<String>) newValue));

        // Crea las paginas en el modelo de datos
        blocs.get(1).sections().get(1).pages().add(new Page("Empresa 1")); // Pagina Empresa 1 (bloc 2, seccion 2)
        blocs.get(1).sections().get(1).pages().get(0).subpages().add(new Page("Detalles 1")); // Subpagina Detalles 1 (bloc 2, seccion 2)
        blocs.get(1).sections().get(1).pages().add(new Page("Empresa 2")); // Pagina Empresa 2 (bloc 2, seccion 2)
        blocs.get(1).sections().get(1).pages().get(1).subpages().add(new Page("Detalles 2")); // Subpagina Detalles 2 (bloc 2, seccion 2)

        // Añade los binding de las paginas (modelo) con los treeItems
        pagesBinding.bindBidirectional(branchItem1, blocs.get(1).sections().get(1).pages().get(0));
        pagesBinding.bindBidirectional(leafItem1, blocs.get(1).sections().get(1).pages().get(0).subpages().get(0));
        pagesBinding.bindBidirectional(branchItem2, blocs.get(1).sections().get(1).pages().get(1));
        pagesBinding.bindBidirectional(leafItem2, blocs.get(1).sections().get(1).pages().get(1).subpages().get(0));

        // Binding de la pagina (textField titulo + textArea contenido) con el modelo de datos
        treeBloc2Seccion2_selectedPage(branchItem1);
    }

//    public void updateBlocs() {
//        // Limpiar el ArrayList existente
//        blocs.blocs().clear();
//
//        // Iterar sobre cada TabPane (bloc)
//        for (TabPane tabPane : new TabPane[]{tbBloc1_secciones, tbBloc2_secciones}) {
//            ArrayList<HashMap<String, String>> seccion = new ArrayList<>();
//
//            // Iterar sobre cada Tab (página) en el TabPane actual
//            for (Tab tab : tabPane.getTabs()) {
//                HashMap<String, String> page = new HashMap<>();
//
//                // Obtener los elementos TextField para el título y el contenido de la página
//                TextField titleField = (TextField) ((AnchorPane) tab.getContent()).getChildren().get(0);
//                TextArea contentArea = (TextArea) ((AnchorPane) tab.getContent()).getChildren().get(1);
//
//                // Agregar el título y el contenido de la página al HashMap
//                page.put("title", titleField.getText());
//                page.put("content", contentArea.getText());
//
//                // Agregar la página al bloc
//                seccion.add(page);
//            }
//
//            // Agregar el bloc al ArrayList de blocs
//            blocs.blocs().add(seccion);
//        }
//    }

    @FXML
    public void txtBloc1_pag1_onInputTyped(Event event) {
//        tbBloc1_paginas.getTabs().get(0).setText(txtBloc1_pag1.getText().toString());
//        TreeItem item = (TreeItem) treeBloc1Seccion1.getSelectionModel().getSelectedItem();
//        if (item != null) item.setValue(txtBloc1_seccion1_tituloPagina.getText().toString());
//        updateBlocs();
//        System.out.println(blocs);
        System.out.println(blocs.get(0).sections().get(0).pages());
    }

    @FXML
    public void txtBloc1_pag2_onInputTyped(Event event) {
//        tbBloc1_paginas.getTabs().get(1).setText(txtBloc1_pag2.getText().toString());
//        TreeItem item = (TreeItem) treeBloc1Seccion2.getSelectionModel().getSelectedItem();
//        if (item != null) item.setValue(txtBloc1_seccion2_tituloPagina.getText().toString());
//        updateBlocs();
//        System.out.println(blocs);
        System.out.println(blocs.get(0).sections().get(1).pages());
    }

    @FXML
    public void txtBloc2_pag1_onInputTyped(Event event) {
//        tbBloc2_paginas.getTabs().get(0).setText(txtBloc2_pag1.getText().toString());
//        MenuItem item = (MenuItem) treeBloc2Seccion1.getSelectionModel().getSelectedItem();
//        if (item != null) item.setText(txtBloc2_seccion1_tituloPagina.getText().toString());
//        updateBlocs();
//        System.out.println(blocs);
        System.out.println(blocs.get(1).sections().get(0).pages());
    }

    @FXML
    public void txtBloc2_pag2_onInputTyped(Event event) {
//        tbBloc2_paginas.getTabs().get(1).setText(txtBloc2_pag2.getText().toString());
//        MenuItem item = (MenuItem) treeBloc2Seccion2.getSelectionModel().getSelectedItem();
//        if (item != null) item.setText(txtBloc2_seccion2_tituloPagina.getText().toString());
//        updateBlocs();
//        System.out.println(blocs);
        System.out.println(blocs.get(1).sections().get(1).pages());
    }

    public void treeBloc1Seccion1_selectedPage(TreeItem<String> selectedItem) {
        // Obtiene el índice del nodo seleccionado
//        int selectedIndex = treeBloc1Seccion1.getSelectionModel().getSelectedIndex();

        // Binding de la pagina

//        txtBloc1_seccion1_tituloPagina.textProperty().bind(selectedItem.valueProperty());
//        txtBloc1_seccion1_contenidoPagina.textProperty().bind(pagesBinding.getPage(selectedItem).content());
        txtBloc1_seccion1_tituloPagina.textProperty().unbind();
        txtBloc1_seccion1_contenidoPagina.textProperty().unbind();
        pagesBinding.getPage(selectedItem).title().bind(txtBloc1_seccion1_tituloPagina.textProperty());
        pagesBinding.getPage(selectedItem).content().bind(txtBloc1_seccion1_contenidoPagina.textProperty());

        // Carga los datos en los elementos gráficos
//        txtBloc1_seccion1_tituloPagina.setText(blocs.get(0).sections().get(0).pages().get(0).title().get());

        // Cargar el contenido de la página en el área de texto correspondiente
//        txtBloc1_seccion1_contenidoPagina.setText(blocs.get(0).sections().get(0).pages().get(0).content().get());
    }

    public void treeBloc1Seccion2_selectedPage(TreeItem<String> selectedItem) {
        // Obtiene el índice del nodo seleccionado
        int selectedIndex = treeBloc1Seccion2.getSelectionModel().getSelectedIndex();

        // Binding de la pagina
        txtBloc1_seccion2_tituloPagina.textProperty().bindBidirectional(blocs.get(0).sections().get(1).pages().get(0).title());
        txtBloc1_seccion2_contenidoPagina.textProperty().bindBidirectional(blocs.get(0).sections().get(1).pages().get(0).content());

        // Carga los datos en los elementos gráficos
//        txtBloc1_seccion2_tituloPagina.setText(blocs.get(0).sections().get(1).pages().get(0).title().get());

        // Cargar el contenido de la página en el área de texto correspondiente
//        txtBloc1_seccion2_contenidoPagina.setText(blocs.get(0).sections().get(1).pages().get(0).content().get());
    }
    public void treeBloc2Seccion1_selectedPage(TreeItem<String> selectedItem) {
        // Obtiene el índice del nodo seleccionado
        int selectedIndex = treeBloc2Seccion1.getSelectionModel().getSelectedIndex();

        // Binding de la pagina
        txtBloc2_seccion1_tituloPagina.textProperty().bindBidirectional(blocs.get(1).sections().get(0).pages().get(0).title());
        txtBloc2_seccion1_contenidoPagina.textProperty().bindBidirectional(blocs.get(1).sections().get(0).pages().get(0).content());

        // Carga los datos en los elementos gráficos
//        txtBloc2_seccion1_tituloPagina.setText(blocs.get(1).sections().get(0).pages().get(0).title().get());

        // Cargar el contenido de la página en el área de texto correspondiente
//        txtBloc2_seccion1_contenidoPagina.setText(blocs.get(1).sections().get(0).pages().get(0).content().get());
    }

    public void treeBloc2Seccion2_selectedPage(TreeItem<String> selectedItem) {
        // Obtiene el índice del nodo seleccionado
        int selectedIndex = treeBloc2Seccion2.getSelectionModel().getSelectedIndex();

        // Binding de la pagina
        txtBloc2_seccion2_tituloPagina.textProperty().bindBidirectional(blocs.get(1).sections().get(1).pages().get(0).title());
        txtBloc2_seccion2_contenidoPagina.textProperty().bindBidirectional(blocs.get(1).sections().get(1).pages().get(0).content());

        // Carga los datos en los elementos gráficos
//        txtBloc2_seccion2_tituloPagina.setText(blocs.get(1).sections().get(1).pages().get(0).title().get());

        // Cargar el contenido de la página en el área de texto correspondiente
//        txtBloc2_seccion2_contenidoPagina.setText(blocs.get(1).sections().get(1).pages().get(0).content().get());
    }
}