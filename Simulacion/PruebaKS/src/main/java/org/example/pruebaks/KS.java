package org.example.pruebaks;

public class KS {
    private int i;
    private double Xi;
    private double in;
    private double inx;
    private double abs_inx;
    private double xin;
    private double abs_xin;

    public KS(int i, double xi, double in, double inx, double abs_inx, double xin, double abs_xin) {
        this.i = i;
        Xi = xi;
        this.in = in;
        this.inx = inx;
        this.abs_inx = abs_inx;
        this.xin = xin;
        this.abs_xin = abs_xin;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double getXi() {
        return Xi;
    }

    public void setXi(double xi) {
        Xi = xi;
    }

    public double getIn() {
        return in;
    }

    public void setIn(double in) {
        this.in = in;
    }

    public double getInx() {
        return inx;
    }

    public void setInx(double inx) {
        this.inx = inx;
    }

    public double getAbs_inx() {
        return abs_inx;
    }

    public void setAbs_inx(double abs_inx) {
        this.abs_inx = abs_inx;
    }

    public double getXin() {
        return xin;
    }

    public void setXin(double xin) {
        this.xin = xin;
    }

    public double getAbs_xin() {
        return abs_xin;
    }

    public void setAbs_xin(double abs_xin) {
        this.abs_xin = abs_xin;
    }
}
