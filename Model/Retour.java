package Model;


public class Retour {

    private double km;
    Location location;
    
    public Retour(double km,Location location) {
        this.km = km;
        this.location = location;
    }
    
    public double getKm() { return km; }
    public void setKm(double km) { this.km = km; }
}
