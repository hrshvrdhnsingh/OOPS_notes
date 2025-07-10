package com.harsh.demo1.Inheritance.Polymorphism;
//final keyword prevents Inheritance; the child class can't access the parent class.
//Jobs of final keyword: create constants, prevent inheritance and prevent methods from being overridden.
//Once a class is declared final, it implicitly declares the methods as final too.

public /*final*/ class Shapes {
    int weight=100;
    void area(){
        System.out.println("I am in Shapes.");
    }
    static void check(){
        System.out.println("Hey from Shapes static check.");
    }
}
/*Static methods can't be overriden as no matter if we override it or not or where we call the static method,
  the method in the parent class will be the one always that gets called. Overriding only works with instance
  objects but since static means it belongs to the class. But if the child defines a static methods with same
  name as that of the static in parent, like Parent ob = new Child() and both have static display() methods, 
  then ob.display() prints the parent's one and hides the child's method.
*/