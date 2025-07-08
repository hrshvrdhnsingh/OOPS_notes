package com.harsh.demo1.ObjectCloning;

public class Human implements Cloneable{
    int age; String name;
    // Copy Constructor -> Takes objext of the same class as parameter.
    public Human(Human other){
        this.age=other.age;
        this.name=other.name;
    }
    // Parameterised Constructor
    public Human(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
