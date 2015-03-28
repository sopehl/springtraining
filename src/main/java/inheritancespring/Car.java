package inheritancespring;

/**
 * Created by semih on 29.03.2015.
 */
public class Car {

    public static enum CarType{
      BUS,CAR,SPORT;
    };

    private CarType carType;
    private String brand,model;


    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
