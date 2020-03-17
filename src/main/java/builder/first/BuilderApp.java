package builder.first;


import builder.Transmission;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class BuilderApp {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("Mercedes")
                .buildMaxSpeed(200)
                .buildTransmission(Transmission.AUTO)
                .build();

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

class CarBuilder{
    String m = "Default";
    Transmission t = Transmission.MANUAL;
    int s =  100;

    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }

    CarBuilder buildTransmission(Transmission t){
        this.t = t;
        return this;
    }

    CarBuilder buildMaxSpeed(int s){
        this.s = s;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMaxSpeed(s);

        return car;
    }
}
