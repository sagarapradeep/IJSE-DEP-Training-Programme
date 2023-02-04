package lk.ijse.dep10.oop;

public class Inheritance {
    static void main(String[] args) {
        Car car =new Car();
        Van van = new Van();

    }
}

class Vehicle{
    String registrationNumber;

     {
        System.out.println("Vehicle object has been initialized");
    }

    void printRegistrationNumber() {

         System.out.println(registrationNumber);
    }

    static {
        System.out.println("vehicle clas has been initialized");
    }

    private void printInternal() {
        System.out.println(registrationNumber);
    }

    public Vehicle() {
        System.out.println("vehicle constructor");
    }
}

class Car extends Vehicle{
    static {
        System.out.println("car class has been initialized");
    }
    {
        System.out.println("car object has been initialized");
}

    public Car() {
        System.out.println("Car constructor");
    }
}

class Van extends Vehicle{

    static {
        System.out.println("Van class has been initialized");
    }

    public Van() {

        System.out.println("Van constructor");
    }
    {
        System.out.println("Van object has been initialized");

    }

}
