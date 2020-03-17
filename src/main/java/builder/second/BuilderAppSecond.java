package builder.second;

import builder.Transmission;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class BuilderAppSecond {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car car = director.buildCar();
        System.out.println(car);

    }
}


@Getter
@Setter
@ToString
class Car{
    String make;
    Transmission transmission;
    int maxSpeed;
}



abstract class CarBuilder{
    Car car;
    void createCar(){
        car = new Car();
    }

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Car getCar(){
        return car;
    }
}

class FordMondeoBuilder extends CarBuilder{

    void buildMake() { car.setMake("Ford Mondeo"); }

    void buildTransmission() { car.setTransmission(Transmission.AUTO); }

    void buildMaxSpeed() { car.setMaxSpeed(200); }
}

class SubaruBuilder extends CarBuilder{

    void buildMake() { car.setMake("Subaru"); }

    void buildTransmission() { car.setTransmission(Transmission.MANUAL); }

    void buildMaxSpeed() { car.setMaxSpeed(150); }
}

class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder b){ builder = b; }

    Car buildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildMaxSpeed();
        builder.buildTransmission();
        Car car = builder.getCar();
        return car;
    }
}