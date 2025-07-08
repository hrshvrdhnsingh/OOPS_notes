package com.harsh.demo1.Exception;
/* When an exception is thrown but not caught in a particular scope, the method-call stack is "unwound," 
 * and an attempt is made to catch the exception in the next outer try block.
 * Unwinding the method-call stack means that the method in which the exception was not caught terminates, 
 * all local variables in that method go out of scope and control returns to the statement that originally 
 * invoked that method.
 * If a try block encloses that statement, an attempt is made to catch the exception.
 * If a try block does not enclose that statement, stack unwinding occurs again.
 * If no catch block ever catches this exception and the exception is checked.
 */
public class StackUnwinding {    
    public static void main(String[] args){
        try{
            throwException();//When the control return here, try block is terminated.
        }
        catch(Exception e){
            //Since the Exception typr can be handled here, hence the the exeption is caught here.
            System.out.println("Method handles in main."); // Printed third
        }
        finally{
            System.out.println("The Exception is caught."); // Printed fourth
        }
    }

    public static void throwException() throws Exception{
        try{
            System.out.println("Method throwException."); // Printed first
            throw new Exception();
            //throws a new Exception that is not caught because the catch block is defined for Runtime
            //Exception only.So the finally block executes, and control is handed over to the try block of
            //main method, but the exception has still not be handled. Once the control reaches back to the
            // main method, the error is finally caught in the catch part and the finally part is executed.
        }
        catch(RuntimeException rt){
            System.out.println("Method handled in throwException.");
        }
        finally{
            System.out.println("Program Executes."); // Printed second
        }
    }
}