module org.example.pruebaks {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.pruebaks to javafx.fxml;
    exports org.example.pruebaks;
}