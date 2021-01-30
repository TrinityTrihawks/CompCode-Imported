package frc.robot;

public class PIDConstants {
    
    private double p, i, d, f;

    private PIDConstants(double p, double i, double d, double f) {
        this.p = p;
        this.i = i;
        this.d = d;
        this.f = f;
    }

    public static PIDConstants fromDoubles(double p, double i, double d, double f) {
        return new PIDConstants(p, i, d, f);
    }

    public double getP() {return p;}
    public double getI() {return i;}
    public double getD() {return d;}
    public double getF() {return f;}
}
