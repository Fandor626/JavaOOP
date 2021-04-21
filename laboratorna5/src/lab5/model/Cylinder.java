package lab5.model;

public class Cylinder extends AbstractForm{
    private float length;
    private float diameter;

    public Cylinder(Wood wood, float length, float diameter) throws Exception {
        super(wood);
        if (length<0||length>100)
            throw new Exception(length+" Некоректно введені дані!\n"+
                    " Повинно бути в рамках від 0 до 100");
        this.length = length;
        if (diameter<0||diameter>100)
            throw new Exception(diameter+" Некоректно введені дані!\n"+
                    " Повинно бути в рамках від 0 до 100");
        this.diameter = diameter;
    }

    public float getLength() {
        return length;
    }

    public float getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "wood =" + wood.getName() +
                ", length=" + length +
                ", diameter=" + diameter +
                '}';
    }

    @Override
    public float volume(){
        float vol = (float) (Math.PI * (diameter/2 * diameter/2) * length);
        return 0;
    }
}
