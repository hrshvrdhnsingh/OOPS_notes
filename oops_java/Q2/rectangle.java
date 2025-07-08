package com.harsh.Q2;

public class rectangle extends Shape{
    
    int l,b;
    public rectangle(int l,int b){
        this.l=l; this.b=b;
    }
    public double area() {
        return l*b;
    }

    public double perimeter() {
        return 2*(l+b);
    }
    

}
