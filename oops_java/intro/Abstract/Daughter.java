package oops_java.intro.Abstract;

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
        career("Neha");
        partner("Harsh",19);
        System.out.println(age);
        System.out.println(name);
    }

    public static void main(String[] args) {
        Son ob1 = new Son("Vishal",34);
        ob1.display();
        /* Harsh aspires to be coder.
        My partner will be Sneha and age 19
        34
        Vishal
        HEY from Son class */

        Daughter ob = new Daughter(20,"Neha");
        ob.display();
        /* Neha aspires to be coder.
        My partner will be Harsh and age 19
        20
        Neha */
    }
}
