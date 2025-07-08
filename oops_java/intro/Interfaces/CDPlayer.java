package com.harsh.demo1.Interfaces;

public class CDPlayer implements media{
    @Override
    public void start() {
        System.out.println("Music startsssss");
    }

    @Override
    public void stop() {
        System.out.println("Music stopssssss");
    }
    
}
