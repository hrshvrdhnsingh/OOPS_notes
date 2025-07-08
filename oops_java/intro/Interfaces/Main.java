package com.harsh.demo1.Interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.accelerate(); // I accelerate in Car
        car.brake(); // I brake the car.
        car.start(); // I start the Car.
        car.stop(); // I stop the Car.

        //Since stop() for media isn't defined, it calls the stop() method of Engine and that of media as both have the stop() function.
        media med = new Car();
        med.stop(); // I stop the Car.

        System.out.println("HEllo");

        med.start(); // I start the Car.

        niceCar ob = new niceCar();
        ob.startMusic(); // Music startsssss 
        ob.stopMusic(); // Music stopsssss
    }
}
/*To use functions with the same name but in different interfaces, we may use private object of class Engine in another  
* class ex. niceCar and create an object of the interface that needs to be executed.
*/
