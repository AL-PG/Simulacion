module org.example.multiplicacionc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.multiplicacionc to javafx.fxml;
    exports org.example.multiplicacionc;
}