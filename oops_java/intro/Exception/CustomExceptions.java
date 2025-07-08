package com.harsh.demo1.Exception;

public class CustomExceptions {
    public static void main(String[] args) {
        try{
            vote(10);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Program Runs");
        }
    }
    public static void vote(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Not Eligible for voting.");
        }
        else if(age>100){
            throw new InvalidAgeException("Dead by now", -1);
        }
        else{
            System.out.println("Valid Age");
            assert age!=60;
        }
    }
}
class InvalidAgeException extends Exception{
    InvalidAgeException(String msg){
        System.out.println("Error: "+msg);
    }
    InvalidAgeException(String msg, int a){
        System.out.println("Error: "+a + "  "+msg);
    }
}
