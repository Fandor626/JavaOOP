package lab2.model;

public class Waste implements IWeight {
    float weight;

    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }

    public Waste(float weight) {
        this.weight = weight;
    }

    public float weight(){
        return weight;
    }
}
