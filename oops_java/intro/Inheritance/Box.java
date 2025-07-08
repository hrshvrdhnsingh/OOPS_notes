package com.harsh.demo1.Inheritance;

public class Box extends Inheritance1{
    int age=12;static int year;
    public Box(){
        super(23);
        year=2023;
    }
    public static void main(String[] args){
        Inheritance1 ob= new Inheritance1();
        Inheritance1 ob1= new Box(); // We are creating an instance of Box but storing the reference in type Inheritance1.
        // dynamic method dispatch -> all the method of the actual object (Box) instead of the reference type (Inheritance1).
        // So calls the overridden methods in the child class unless no override exists.

        // Derived d; Base b = d; 
        // The thing wherein we on doing this ob1 loses the contents of the derived class ie; Box is called
        // Object Slicing and isn't allowed in Java like it does in C++. The knowledge of the dderived class is
        // sliced off as base class has knowledge of it's own members. So the same thing has different behaviour
        // in either languages.
        
        System.out.println(ob.l+" "+ob.h); // -1 -1
        System.out.println(ob1.l+" "+ob1.h); // 23 23 -> since box constructor is called and super sets 23.
        ob.display(); // Hello from Inheritance-1
        ob1.display(); // Hello from Inheritance23
        Box ob2=new Box();
        ob2.diss(); // Hello from Inheritance23
    }
    void diss(){
        display();
    }
} 
