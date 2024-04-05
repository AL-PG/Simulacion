package org.example.pruebaks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private Label labelN;
    @FXML private Label labelDm;
    @FXML private Label labelDme;
    @FXML private Label labelD;
    @FXML private Label labelValorC;
    @FXML private Label labelResultado;
    @FXML private TableView<KS> tabla;
    @FXML private TableColumn<KS, Integer> Coli;
    @FXML private TableColumn<KS, Double> ColXi;
    @FXML private TableColumn<KS, Double> ColN;
    @FXML private TableColumn<KS, Double> ColNX;
    @FXML private TableColumn<KS, Double> ColAbsNX;
    @FXML private TableColumn<KS, Double> ColXN;
    @FXML private TableColumn<KS, Double> ColAbsXN;
    @FXML private Button boton1;
    @FXML private TextField txtDatos;
    @FXML private TextField txtNC;
    @FXML private ChoiceBox NC;

    private ObservableList<KS> mult;

    private void NC(){
        NC.getItems().addAll("80","90","95","98","99");
    }

    public void boton1(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.NONE);
        try {
            List<Double> lista = new ArrayList<>();
            lista = parseNumbers(txtDatos.getText());
            String seleccion = (String) NC.getValue();
            double nivelConfianza = Double.parseDouble(seleccion);
            tablaCalculos(lista, nivelConfianza);
        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Ingrese los datos apropiados");
            alert.show();
        }

    }

    public static List<Double> parseNumbers(String data) {
        List<Double> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        // Recorre cada caracter en la cadena de datos
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            // Agrega el caracter al número actual
            currentNumber.append(c);

            // Si el siguiente caracter es un punto, el actual es un dígito, y hay más caracteres por delante,
            // eso significa que hemos llegado al final de un número.
            if (i + 1 < data.length() && data.charAt(i + 1) == '.' && Character.isDigit(c)) {
                try {
                    double number = Double.parseDouble(currentNumber.toString());
                    numbers.add(number);
                    // Reinicia el StringBuilder para el siguiente número
                    currentNumber.setLength(0);
                } catch (NumberFormatException e) {
                    // Manejar la excepción según sea necesario
                    System.out.println("Error al parsear: " + currentNumber.toString());
                }
            }
        }

        // Parsea el último número si quedó alguno en el StringBuilder
        if (!currentNumber.isEmpty()) {
            try {
                double number = Double.parseDouble(currentNumber.toString());
                numbers.add(number);
            } catch (NumberFormatException e) {
                // Manejar la excepción según sea necesario
                System.out.println("Error al parsear: " + currentNumber.toString());
            }
        }

        return numbers;
    }
    public void tablaCalculos(List<Double> lista, double NC){
        List<Double> lista1 = new ArrayList<>();
        List<Double> lista2 = new ArrayList<>();

        for(int i = 1; i < lista.size(); i++) {
            int n = lista.size()-1;
            double Xi = lista.get(i);
            double in =(double) (i)/n;
            double inx = in - Xi;
            inx = Math.round(inx * Math.pow(10, 4)) / Math.pow(10, 4);
            double Abs_inx = Math.abs(inx);
            double xin = Xi - ((double)(i - 1) / n);
            xin = Math.round(xin * Math.pow(10, 4)) / Math.pow(10, 4);
            double Abs_xin = Math.abs(xin);

            lista1.add(Abs_inx);
            lista2.add(Abs_xin);

            KS numero = new KS(i,Xi,in,inx,Abs_inx,xin,Abs_xin);
            mult.add(numero);
            this.tabla.setItems(mult);

        }

        double Dm = Collections.max(lista1);
        double Dmen = Collections.max(lista2);
        double D = Math.max(Dm,Dmen);

        labelN.setText(String.valueOf(lista.size()-1));
        labelDm.setText(String.valueOf(Dm));
        labelDme.setText(String.valueOf(Dmen));
        labelD.setText(String.valueOf(D));

        switch ((int) NC){
            case 80:
                NC = 1.07/Math.sqrt(lista.size()-1);
                break;
            case 90:
                NC = 1.22/Math.sqrt(lista.size()-1);
                break;
            case 95:
                NC = 1.36/Math.sqrt(lista.size()-1);
                break;
            case 98:
                NC = 1.52/Math.sqrt(lista.size()-1);
                break;
            case 99:
                NC = 1.63/Math.sqrt(lista.size()-1);
                break;
        }
        NC = Math.round(NC * Math.pow(10, 4)) / Math.pow(10, 4);
        labelValorC.setText(String.valueOf(NC));

        if(D > NC){
            labelResultado.setText("H0 se RECHAZA");
        } else  {
            labelResultado.setText("H0 se ACEPTA");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mult = FXCollections.observableArrayList();
        Coli.setCellValueFactory(new PropertyValueFactory<KS, Integer>("i"));
        ColXi.setCellValueFactory(new PropertyValueFactory<KS, Double>("Xi"));
        ColN.setCellValueFactory(new PropertyValueFactory<KS, Double>("in"));
        ColNX.setCellValueFactory(new PropertyValueFactory<KS, Double>("inx"));
        ColAbsNX.setCellValueFactory(new PropertyValueFactory<KS, Double>("abs_inx"));
        ColXN.setCellValueFactory(new PropertyValueFactory<KS, Double>("xin"));
        ColAbsXN.setCellValueFactory(new PropertyValueFactory<KS, Double>("abs_xin"));
        NC();
    }


}