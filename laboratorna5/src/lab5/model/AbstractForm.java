package lab5.model;

public abstract class AbstractForm implements IWeight, java.io.Serializable {
    protected Wood wood;
    public abstract  float volume();

    public AbstractForm(Wood wood) {
        this.wood = wood;
    }

    public Wood getWood() {
        return wood;
    }

    @Override
    public  float weight(){
        return  wood.getDensity() * volume();
    }
}
