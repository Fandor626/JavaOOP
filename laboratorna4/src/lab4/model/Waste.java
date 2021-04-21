package lab4.model;

public class Waste implements IWeight {
    float weight;

    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }

    public Waste(float weight) throws Exception {
        if (weight<0||weight>10000)
            throw new Exception(weight+" Некоректно введені дані!\n"+
                    " Повинно бути в рамках від 0.020 до 0.100");
        this.weight = weight;
    }

    public float weight(){
        return weight;
    }
}
