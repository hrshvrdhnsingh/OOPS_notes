package com.harsh.Q2;

public class Q2 {
    public static void main(String[] args) {
        rectangle ob1 = new rectangle(10,20);
        System.out.println(ob1.area());
        System.out.println(ob1.perimeter());

        Circcle ob2 = new Circcle(10);
        System.out.println(ob2.area());
        System.out.println(ob2.perimeter());
    }
}
