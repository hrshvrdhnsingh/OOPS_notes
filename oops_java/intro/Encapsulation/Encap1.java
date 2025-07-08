package com.harsh.demo1.Encapsulation;
/*Encapsulation:  the process by which data (variables) and the code that acts upon them (methods) are integrated as a 
single unit. 
Hiding data (variables) and allowing controlled access through methods.
By encapsulating a class's variables, other classes cannot access them, and only the methods of the class can access them.
Protect data and enforce restrictions.
It solves an implementation level issue.
By declaring instance variables as private we make sure that it can't be accessed by any one else or the use of getter-setter methods. 
Focuses on Internal stuff. It's about containing information.
Allowing access and modificatin through a controlled interface or methods.
-> private String name;
-> public String getName() { return name; }
*/


/*Abstraction: Hiding the unnecessary details and showing only the valuable details.
Hiding implementation details and exposing only the essential functionality.
Reduce complexity and increase reusability.
Implementation of abstract classes is a good example of Abstraction.
System.out.println is a good example as well. We are only aware of the println method to print the content but the rest details are hidden from us.
Focuses on external stuff.It's about gaining information.
Can be achieved via :-
-> Abstract Classes : A class that cannot be instantiated on its own but can be extended by other classes. 
                        It can have both abstract (unimplemented) methods and concrete (implemented) methods.
                        * Allows only single inheritance
                        * Allows constant and non-constant fields
                        * Can have constructors.
                        * Used when you want to provide some common behavior (methods with implementation) 
                          for all subclasses, and when the classes are closely related.
-> Interfaces :- A completely abstract type that only contains method signatures (no implementations). 
                        Classes that implement an interface must provide the implementation for all its methods.
                        * Allows multiple inheritance
                        * Doesn't allow non-constant.
                        * No constructorrs allowed as they are not allowed to instantiate fields -> all variables are public, static, final
                        * Used when you want to define a contract that can be implemented by unrelated classes. 
                          Interfaces are ideal for scenarios where you want to ensure certain methods are implemented 
                          without dictating how they are implemented.
                        
=> In both the above the class that extends or implements needs to provide implementation to all of the abstract methods 
  otherwise an error will be shown. Otherwise we can that declare that class as abstract as well so that another class
  extends it can complete the incomplete the missing implementation. If a concrete class (a class not declared abstract) 
  does not implement all the abstract methods, and the compiler allows it to be instantiated, the object created would 
  be incomplete. Such an object would be missing essential behaviors defined in the abstract class or interface,
  which could lead to runtime errors.
=> Abstract methods in an abstract class or interface act as a contract that any subclass or implementing class must fulfill. 
  If a class declares that it will inherit from an abstract class or implement an interface, it's expected to provide all 
  the behaviors promised by the contract (i.e., the abstract methods). f the class doesn't provide an implementation
  for one or more abstract methods, it's an incomplete class. Declaring such a class as abstract signals that it is still
  waiting for other subclasses to fulfill the remaining part of the contract.
*/


/*Data Hiding-> Focuses on security of information and Encapsulation focuses on hiding complexiy of the system.
 * Getter Setter is based on Data Hiding. It hides the private members. Encapsulation is a sub-part of Data Hiding.
 * Restricting access to the internal state of an object, typically acheved through the use of access modifiers or getter-setter methods.
 */
public class Encap1 {
    
}
