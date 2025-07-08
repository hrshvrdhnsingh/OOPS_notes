package com.harsh.demo1.Abstract;

public class Daughter extends Parent{

    public Daughter(int age,String name){
        super(age,name);
    }

    @Override
    void career(String name) {
        System.out.println(name+" aspires to be coder.");
    }

    @Override
    void partner(String name, int age) {
        System.out.println("My partner will be "+name+" and age "+age);
    }
    
    void display()
    {
        career("Kritika");
        partner("Harsh",19);
        System.out.println(age);
        System.out.println(name);
    }

    public static void main(String[] args) {
        Son ob1 = new Son("LILI",34);
        ob1.display();
        /* Harsh aspires to be coder.
        My partner will be Kritika and age 19
        34
        LILI
        HEY from Son class */

        Daughter ob = new Daughter(20,"Ashna");
        ob.display();
        /* Kritika aspires to be coder.
        My partner will be Harsh and age 19
        20
        Ashna */
    }
}
