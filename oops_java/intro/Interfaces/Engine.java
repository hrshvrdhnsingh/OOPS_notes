package com.harsh.demo1.Interfaces;
/*Similar to abstract classes just that Multiple Inheritance is allowed.

* Interfaces cannot have instance variables as they are not meant to store data, so they are static to make it 
  part of the interface as a whole
* All variables inside an interface are implicitly public, static, and final. 
* The value of the variable must be assigned in a static context in which no instance exists. 
* The final modifier ensures the value assigned to the interface variable is a true constant that cannot be re-assigned by program code.
* The classes implementing this interface needs to override all the abstract classes mandatorily.
*/
public interface Engine {
    static final int price = 7800;
    // These are public abstract methods
    void start();
    void stop();
    void accelerate();
}
