
package com.harsh.demo1.Abstract;
// To enforce a common behavior across multiple classes.
//Abstrsct just provides the presence of an an entity and it's chils's class 
//responsibility to fill the gaps as per their need.
//A class containing an abstract method needs to be declared as abstract.
//Child class has to override all methods of parent class.
public abstract class Parent {
    public int age;String name;
    
    public Parent(int age, String name) {
        this.age = age;
        this.name = name;
    }

    void Hello(){
        //age = 20000;
        System.out.println("Hello from Parent Class.");
    }
    abstract void career(String name);
    abstract void partner(String name, int age);
}
//One can't create object of an abstract class and that follows for abstract constructors as well.
//Since static methods can't be overriden, hence static abstract methods isn't possible.
//But one can create static method in abstract class.
//Abstract Class needs to be oinherited and hence final abstract class isn't possible.  