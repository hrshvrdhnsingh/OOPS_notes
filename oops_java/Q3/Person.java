package com.harsh.Q3;

public interface Person {
    public void work();
    public void introduce();
    public default void printDetails(){
        System.out.println("hello guys");
    }
}
