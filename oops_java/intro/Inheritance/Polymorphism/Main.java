package com.harsh.demo1.Inheritance.Polymorphism;
//Existence of an identity in multiple forms.In other words, polymorphism allows you to define one interface and have multiple implementations. 
//Method Overloading(Compile-Time or Static) and Method Overriding(Runtime or Dynamic).
//Static-> As java decides which method to call at compile-time. We saw method overloading in Box and Boxweight.
//Dynamic-> When there is a conflic between same name of method in parent and child class.
//Overloading and overriding aren't applied to instance variables as they both are related to methods. Overloading of
//instance variable can't be done as variables with the same name in the same class will not be permitted. Overriding can't 
//be done as a subclass having variable of same name, so it won't override it, it will just hide it. 
public class Main {
    static final int n=10;
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Rectangle rect = new Rectangle();
        Shapes Rect = new Rectangle();//Here Rect is an object of class Shapes but it can call area method in class Rectangle.
        //This is beccause Rect has all methods available for use, but the reference type is of class Rectangle. Hence on using
        //Rctangle overrides the area method and prints the contents within itself and not the one under area of Shapes.
        //Shapes tells us what reference it's trying to access but which method we are trying to access is knoen by the after part
        //i.e; Of class Rectangle.
        shape.area(); // I am in Shapes.
        circle.area(); // I am in Circle.
        rect.area(); // I am in Rectangle.
        Rect.area(); // I am in Rectangle.
        //n=11; Can't be done.
       
        //ob.check(); One can inherit but can't override
        Shapes ob = new Circle();
        ob.area(); // I am in Circle.
        //Calling the static methods in class Shapes and Circle
        System.out.println(ob.weight); // 100
        //Overloading and overriding both aren't applied to instance variables. In this case value of weight in parent class is printed as it can't acces the child's value.
    }
}
//Parent obj = new Child();
/*If the refernce type is of parent class and the object is of type sub-class, then the method being called willbe of Child class and this is called Upcasting.
 * And this is how Overriding works.(Java does this via Dynamic Method Dispatch)
 * Parent tells us what the object can access(i.e; area method) but which method it can access is informed to us via the Child class.
 * Dynamic Method Dispatch(Late Binding) - Process by which call to a overridden method is resolved at runtime. When such a declaration is met by Java,
 * it decides which version to call based on the reference. Slower due to lookup overhead.
 * One can't override a final method. Makes the job of JRE easier as it directly has to copy the code as overriding is not possible at runtime.
 * Since the final method can't be overriden, it can be resolved during compile time hence called Early Binding.
 * 
 * Early Binding -> Occurs at compile-time and is used for static, final and private methods as they can't be overriden.
 *                  Faster due to less overhead.
 */