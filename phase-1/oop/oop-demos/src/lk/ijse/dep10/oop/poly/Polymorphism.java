package lk.ijse.dep10.oop.poly;

public class Polymorphism {
    public static void main(String[] args) {
        Prius prius = new Prius();


        Vehicle vehicle = prius;

        Car car = new Car();

        System.out.println(prius==vehicle);
    }

}

class Vehicle{
    public void horn(){}
    public void accelerate(){}
    public void pushBrake(){}

}
class Car extends Vehicle{
    public void advanceBreakingSystem(){}


}

class Prius extends Car{
    public void hybrid(){}

}

class Bugati extends Car {
    public void turboAcceleration(){}

}

