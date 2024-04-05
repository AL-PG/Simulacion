package org.example.multiplicacionc;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML private Button boton1;
    @FXML private TextField TextFieldA;
    @FXML private TextField TextFieldX0;
    @FXML private  TextField TextFieldIT;

    public void boton1(ActionEvent evento) throws IOException {
        Alert alert = new Alert(Alert.AlertType.NONE);

        try {
            long A = Long.parseLong(TextFieldA.getText());
            long X0 = Long.parseLong(TextFieldX0.getText());
            int It = Integer.parseInt(TextFieldIT.getText());

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MultipleVentana.fxml"));
            Parent root = fxmlLoader.load();

            MultipleVentana multipleVentana = fxmlLoader.getController();
            multipleVentana.multplicacion(A,X0,It);

            Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (NumberFormatException e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("El valor tiene que ser un numero");
            alert.show();
        }
    }

}