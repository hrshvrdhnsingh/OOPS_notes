package com.harsh.demo1.ObjectDemo;

public class tostringoverride {
    int rollno;  
    String name;  
    String city;

    public tostringoverride(int rollno, String name, String city) {
        this.rollno = rollno;
        this.name = name;
        this.city = city;
    } 
    @Override
    public String toString(){
        return rollno+" "+name+" "+city;
    }

    public static void main(String[] args) {
        tostringoverride s1=new tostringoverride(101,"Raj","lucknow");  
        tostringoverride s2=new tostringoverride(102,"Vijay","ghaziabad");
        
        System.out.println(s1);//compiler writes here s1.toString()
        System.out.println(s2);//compiler writes here s2.toString()  
    }
    //Had the toString not been overriden, the toString method would have printed teh hash value of the objects s1 and s2.  
}
