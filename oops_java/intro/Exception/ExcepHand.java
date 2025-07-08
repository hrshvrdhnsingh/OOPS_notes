package com.harsh.demo1.Exception;
//An error is something the system can't handle.It's irrecoverable.
//Exception interrupts the normal flow of the program.
/*"Throwable" class handles the exceptions and errors part in Java.
 * Checked Exceptions - Happens at compile-time. -> IOException and FileNotFoundException and must be declared during class declaration
 * Unchecked Exception - Happens at run-time. Compiler can't detect it. -> ArithmeticException
 * 
 */
public class ExcepHand {
    public static void main(String[] args) {
        int a=2, b=0;
        try{
            divide(a,b);
            int c=a/b; // unreachable statements as the above function throws an exception
        }// One can have multiple catch blocks as but the type of Exception being caught has to be in ascending order.
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("This gets printed no matter the output of above try catch block.");
        }
    }
    static int divide(int a, int b) throws ArithmeticException{//Just to tell that the method may throw an Exception.
        if(b==0) {
            //throw new ArithmeticException()
            throw new ArithmeticException("Don't divide by zero.");// Printed first. Had the message not been there, it prints null.
        }
        return a/b;
    }
}
