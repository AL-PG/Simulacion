package org.example.multiplicacionc;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class MulltiplicacionCo{
    private String iteracion;
    private long X0;
    private long AX0;
    private long Ext;
    private double Psu;


    public MulltiplicacionCo(String iteracion, long x0, long AX0, long ext, double psu) {
        this.iteracion = iteracion;
        this.X0 = x0;
        this.AX0 = AX0;
        this.Ext = ext;
        this.Psu = psu;
    }

    public String getIteracion() {
        return iteracion;
    }

    public void setIteracion(String iteracion) {
        this.iteracion = iteracion;
    }

    public long getX0() {
        return X0;
    }

    public void setX0(int x0) {
        this.X0 = x0;
    }

    public long getAX0() {
        return AX0;
    }

    public void setAX0(int AX0) {
        this.AX0 = AX0;
    }

    public long getExt() {
        return Ext;
    }

    public void setExt(int ext) {
        this.Ext = ext;
    }

    public double getPsu() {
        return Psu;
    }

    public void setPsu(double psu) {
        this.Psu = psu;
    }

}
