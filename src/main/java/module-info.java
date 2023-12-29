module com.santiago.di03_anote {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.santiago.di03_aNote to javafx.fxml;
    exports com.santiago.di03_aNote;
}