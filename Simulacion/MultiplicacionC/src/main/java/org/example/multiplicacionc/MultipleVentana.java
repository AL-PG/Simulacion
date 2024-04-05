package org.example.multiplicacionc;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class MultipleVentana implements Initializable {

    @FXML private Label LabelA;
    @FXML private TableView<MulltiplicacionCo> Tabla;
    @FXML private TableColumn<MulltiplicacionCo, String> ColX;
    @FXML private TableColumn<MulltiplicacionCo, Long> ColNA;
    @FXML private TableColumn<MulltiplicacionCo, Long> ColAX0;
    @FXML private TableColumn<MulltiplicacionCo, Long> ColExt;
    @FXML private TableColumn<MulltiplicacionCo, Double> ColPsu;
    private Stage stage;
    private ObservableList<MulltiplicacionCo> mult;
    public void multplicacion(long A, long X0, int It){
        LabelA.setText(String.valueOf(A));
        long Xi = X0;

        for (int i = 0; i < It+1; i++) {
            long AX0 = A*Xi;
            long Extraido = Extraccion(A,AX0);
            double Pseudo = (double) Extraido / Math.pow(10, String.valueOf(A).length());

            MulltiplicacionCo numero = new MulltiplicacionCo("X"+i, Xi, AX0, Extraido,Pseudo);
            mult.add(numero);
            this.Tabla.setItems(mult);

            Xi = Extraido;

        }
    }
    public static long Extraccion(long A, long AX0){
        String A1 = String.valueOf(A);
        String AX = String.valueOf(AX0);

        if (AX.length() < A1.length() + 2){
            return Long.parseLong(AX.substring(AX.length()-(A1.length()+1), AX.length()-2));
        } else {
            return Long.parseLong(AX.substring(AX.length()-(A1.length()+2), AX.length()-2));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mult = FXCollections.observableArrayList();
        ColX.setCellValueFactory(new PropertyValueFactory<MulltiplicacionCo, String>("iteracion"));
        ColNA.setCellValueFactory(new PropertyValueFactory<MulltiplicacionCo, Long>("X0"));
        ColAX0.setCellValueFactory(new PropertyValueFactory<MulltiplicacionCo, Long>("AX0"));
        ColExt.setCellValueFactory(new PropertyValueFactory<MulltiplicacionCo, Long>("Ext"));
        ColPsu.setCellValueFactory(new PropertyValueFactory<MulltiplicacionCo, Double>("Psu"));
        Tabla.setItems(mult);
    }
}
