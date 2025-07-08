package com.harsh.GUI;
import java.awt.*;
public class test1{
    test1(){
        Frame f = new Frame();
        Button b = new Button("Hello");
        b.setBounds(30,100,80,30);
        Label l1,l2;
        l1 = new Label("First Label");
        l2 = new Label("Second Label");
        f.add(l1);
        l1.setBounds(50,130,100,40);
        f.add(l2);
        l2.setBounds(50,170,100,40);
        f.add(b);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args){
        test1 ob1 = new test1();
    }
}
