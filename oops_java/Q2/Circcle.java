package com.harsh.Q2;

public class Circcle extends Shape{
    int r;
    public Circcle(int r){
        this.r=r;
    }
    public double area(){
        return r*r;
    }
    public double perimeter(){
        return 2*3.14*r;
    }
    public void radius(int r){
        this.r=r;
    }
}
