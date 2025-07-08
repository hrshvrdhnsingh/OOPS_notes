package com.harsh.GUI;
import java.awt.*;
public class test2 {
    test2(){
        Frame f = new Frame("Text Example");
        f.setSize(400,400);
        TextField t1,t2;
        t1 = new TextField("Welcome");
        t2 =  new TextField("Hey there");
        t1.setBounds(50,100,200,40);
        t2.setBounds(50,140,200,40);
        f.add(t1);
        f.add(t2);
        f.setLayout(null);
        f.setVisible(true);
        
        Checkbox c1 = new Checkbox("C++",true);
        Checkbox c2 = new Checkbox("Java",true);
        c1.setBounds(250,200,50,20);
        c2.setBounds(250,250,50,20);
        f.add(c1); f.add(c2);

        Choice c = new Choice();
        c.add("Harsh");
        c.add("Sumit");
        c.add("Alter Ego");
        f.add(c);
        c.setBounds(250,300,80,40);
        
    }
    public static void main(String[] args) {
        test2 ob2 = new test2();
    }
}
