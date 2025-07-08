package com.harsh.GUI;
//import java.awt.*;
import javax.swing.*;
public class BasicIO {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What's your name??");
        String age = JOptionPane.showInputDialog("Enter you age: ");
        String dob = JOptionPane.showInputDialog("Enter you date of birth: ");
        int marks = Integer.parseInt(name)+Integer.parseInt(dob);
        /*JOptionPane.showMessageDialog(null,"Message Recieved","Error",3);
        JOptionPane.showMessageDialog(null,name,"Lo Behold",1);
        JOptionPane.showMessageDialog(null,age,"Lo Behold",1);
        JOptionPane.showMessageDialog(null,dob,"Lo Behold",1);*/
        JOptionPane.showMessageDialog(null,marks,"Total marks",1);
    }
}
