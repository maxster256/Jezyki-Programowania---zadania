public class Car {
    private String marka;
    private String model;
    private int rok;
    public Car(String marka, String model, int rok){
        this.marka=marka;
        this.model=model;
        this.rok=rok;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getRok() {
        return rok;
    }
}
