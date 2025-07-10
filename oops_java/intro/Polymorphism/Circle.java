package com.harsh.demo1.Inheritance.Polymorphism;

public final class Circle extends Shapes{
    int weight=120;
    @Override
    void area(){
        System.out.println("I am in Circle.");
    }
    //@Override -> will give error as the check() method is static and hence can't be overriden.
    static void check(){
        System.out.println("Hey from Circle static check.");
    }
}
