package com.harsh.demo1.Exception;
//Chained Exceptions allows to relate one exception with another exception, i.e one exception 
//describes cause of another exception.
public class ChainedExceptions {
    public static void main(String[] args) {
        try{
            NumberFormatException ex = new NumberFormatException("First Exception");
            ex.initCause(new NullPointerException("Actual Cause of Exception."));
            throw ex;
        }
        catch(NumberFormatException e){
            System.out.println(e);
            System.out.println(e.getCause());
        }
    }
}
