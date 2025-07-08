package com.harsh.demo1.ObjectDemo;

public class equalsoverride {
    int num;float gpa;

    public equalsoverride(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }

    /*@Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }Default equals function*/

    public boolean equals(Object obj) {
        return (this.num==((equalsoverride)obj).num && this.gpa==((equalsoverride)obj).gpa);
    }
    
    public static void main(String[] args) {
        equalsoverride ob1 = new equalsoverride(10,78.2f);
        equalsoverride ob2 = new equalsoverride(10,78.2f);
        
        equalsoverride ob3 = new equalsoverride(10,78.2f);
        equalsoverride ob4 = new equalsoverride(10,78.1f);

        if(ob1==ob2) System.out.println("HALLA");//only comapres whether the object points to the same object or not.
        else System.out.println("halla");

        if(ob1.equals(ob2)) System.out.println("HALLA");//has been overriden to comapre the contents of the object.
        else System.out.println("halla");

        if(ob3.equals(ob4)) System.out.println("HALLA");
        else System.out.println("halla");
    }
}
