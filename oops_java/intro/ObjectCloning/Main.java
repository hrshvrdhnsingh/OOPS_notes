package com.harsh.demo1.ObjectCloning;

public class Main implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {
        Human Harsh = new Human(34,"Harsh"); // Using the parameterised constructor
        Human Sumit = new Human(Harsh); // Creating a copy of Harsh into Sumit using Copy constructor
        
        System.out.println(Sumit.name+ " "+Sumit.age); // Harsh 34
        //This takes up a lot of time as new keyword is involved.
        //Hence we need cloning i.e; Clonable interface of java.lang package.
        
        // Now we create a copy of Harsh using Object Cloning instead of Copy constructor.
        Human Sumit2 = (Human)Harsh.clone();
        System.out.println(Sumit2.name+" "+Sumit2.age); // Harsh 34
    }
}
/* 
 * Copy Constructor -> Calls constructor explicitly.
 *                     Slower(Allocates memory and copies data)
 *                     Can modify object attributes (Offers more control)
 *                     Manually written
 * Object Cloning -> Uses clone() method
 *                   Faster(Created a bitwise copy)
 *                   Performs a direct copy
 *                   Must implement Clonesable and override the clone() like seen in the Human class and in Main
 *                                              class as well.
 */
