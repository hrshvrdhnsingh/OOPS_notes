package com.harsh.Q3;

public class Employee implements Person{

    @Override
    public void introduce() {
        System.out.println("Hi Iam Harshvardhan");
    }

    @Override
    public void work() {
        System.out.println("I work at Google.");
    }
    
    
}
