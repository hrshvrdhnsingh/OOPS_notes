package com.harsh.introduction.Hello;

/*Those properties that are not related to the object being created are cslled static variables.
 * A static variable can be accessed before any of the objects is created i.e; can be called
   without referencing to the object.
 * main() method is staic because it needs to be called without any object of the class being created.
 * main() is the entry point of the program and thus, if there was a compulsion to make an object before
   calling the method, where do we create the object to call the main() method.
 * Inside a static method you can't use non-static methods without the use of objects.One can't do that because
   the specific object needs to be instantiated.
 * A non-static method can call a static method without the creation of any object.
 * One cannot access non-static stuff without referencing their instances in a ststic context.
 * 
 */
public class Static1 {
    int age; 
     
    public static void main(String[] args){
        System.out.println("Hey from main."); 
        print();
        Static1 ob = new Static1();
        ob.greeting();
    }
    void greeting(){
        System.out.println("Hey from Greeting");
        age=19;
        System.out.println("Age:"+this.age);
        print();
    }
    static void print(){
        System.out.println("Hey from print.");
    }
    //"this" keyword inside static
    static void message(){
        System.out.println("Hello");
        //System.out.println(this.age); This won't work as static itself doesn't rely on objects
        //So how can it use something that relies on objects.
    }
}
