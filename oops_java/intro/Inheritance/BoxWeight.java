package com.harsh.demo1.Inheritance;

public class BoxWeight extends Box{
    //public int weight;
    int age=10;
    BoxWeight(){
        super();//used to call parent class construtor; If not present the default constructor is called.
        //weight=23;
        System.out.println(this.age); // 10
        System.out.println(super.age); // 23
        System.out.println(year);// 2023 -> static methods can be called easily without object.
        System.out.println(l); // 23
    }
    public static void main(String[] args){
        BoxWeight ob = new BoxWeight();
        ob.diss(); // Hello from Inheritance23
        //System.out.println(this.age); "this" and "super" can't be used from static context.
    }
}
