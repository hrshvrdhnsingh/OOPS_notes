package com.harsh.demo1.Inheritance.Polymorphism;

public class Rectangle extends Shapes{
    //This will run when object of Rectangle is called, hence it overrides the parent method.
    //To cehck whether method is overrriden or not, we add/*@override*/ to it. If it shows error,
    //Overriding isn't being done and vice versa.
    @Override//For check purpose only.
    void area(){
        System.out.println("I am in Rectangle.");
    }
}
