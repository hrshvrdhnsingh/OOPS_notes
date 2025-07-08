package com.harsh.demo1.Interfaces;

public class Car implements Engine,Brakes,media {
    @Override
    public void accelerate() {
        System.out.println("I accelerate in Car");
    }

    @Override
    public void start() {
        System.out.println("I start the Car.");
    }

    //Class media also has start() and stop(). This is conflict but Java allows it since the signature is same.
    @Override
    public void stop() {
        System.out.println("I stop the Car");
    }

    @Override
    public void brake() {
        System.out.println("I brake the car.");
    }
    
}
