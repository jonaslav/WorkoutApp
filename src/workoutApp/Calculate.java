package workoutApp;

public class Calculate {
    private double kg;
    private double rep;

    public Calculate(double kg, double rep) {
        this.kg = kg;
        this.rep = rep;
    }

    public double oneRM(double kg, double rep){
        if (kg <= 0 && rep <= 0){
            throw new IllegalArgumentException("Cannot be zero or below");
        }else {
            double outRM = kg * rep * 0.0333 + kg;
            return outRM;
        }

    }

    public double getKg() { return kg; }

    public void setKg(double kg) { this.kg = kg; }

    public double getRep() { return rep; }

    public void setRep(double rep) { this.rep = rep; }
}
