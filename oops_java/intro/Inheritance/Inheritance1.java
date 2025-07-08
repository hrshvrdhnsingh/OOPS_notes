package com.harsh.demo1.Inheritance;

public class Inheritance1 {
    int l,b,h;
    public Inheritance1(){
        this.l=-1; this.b=-1; this.h=-1;
    }
    public Inheritance1(int s){
        this.l=s; this.b=s; this.h=s;
    }
    void display(){
        System.out.println("Hello from Inheritance" + h);
    }
    public static void main(String[] args){
        Box ob = new BoxWeight();
    }
}
//Single Inheritance: One class inherits another class.

//Hierarchial Inheritance: The child class is pareant for another and the cycle continues.

//Multi-Level: Child class has two parent class and due to possibility of conflict of variables,
//it's not allowed in Java.

//Hybrid Inheritance: Mix of hierarchial and single inheritance. 