package com.harsh.demo1.Abstract;
// The extending class needs to override all the methods of teh parent class, and can have methods of it' own.
public class Son extends Parent{
    public Son(String name,int age){//using the instance variable without declaring as it's already done so in the superclass.
        super(age,name);
    }

    @Override
    void career(String name) {
        System.out.println(name+" aspires to be coder.");
    }

    @Override
    void partner(String name, int age) {
        System.out.println("My partner will be "+name+" ...and age "+age);
    }
    
    void Hello(){
        System.out.println("HEy form Son class");
    }
    void display()
    {
        career("Harsh");
        partner("Kritika",19);
        System.out.println(age);
        System.out.println(name);
        Hello();
    }

    public static void main(String[] args) {
        Son ob = new Son("sumit",20);
        ob.display();
        
    }
}
