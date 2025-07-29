package oops_java.intro.Interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.accelerate(); // I accelerate in Car
        car.brake(); // I brake the car.
        car.start(); // I start the Car.
        car.stop(); // I stop the Car.

        //Since stop() for media isn't defined, it calls the stop() method of Engine and that of media as both have the stop() function.
        // the media iobject can only call methods that it has defined ie; start and stop
        // At runtime, java uses dynamic dispatch to call Car's overrides
        media med = new Car();
        med.stop(); // I stop the Car.
        med.start(); // I start the Car.
        
        System.out.println("HEllo");

        niceCar ob = new niceCar();
        ob.startMusic(); // Music startsssss 
        ob.stopMusic(); // Music stopsssss
    }
}
/*To use functions with the same name but in different interfaces, we may use private object of class Engine in another  
* class ex. niceCar and create an object of the interface that needs to be executed.
*/
