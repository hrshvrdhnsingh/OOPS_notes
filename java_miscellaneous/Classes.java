//import java.util.*;
//The new keyword is used to create an instance or an object by allocating it address in the memory
class Students{
    int roll;//Instance Variables; Every object being created has an instance of these variables
    String name;//
    float marks;
    /*Students(){//gets called as soon as the object is created(Default Constructor)
        this.roll=10;
        this.name="abc";
        this.marks=45.0f;
    }*/
    Students(int roll, String name, float marks){//Constructor Overloading
        this.roll=roll;
        this.name=name;
        this.marks=marks;
    }
    Students(Students other){//passing of object itself; other is an object
        this.marks=other.marks;
        this.name=other.name;
        this.roll=other.roll;
    }
    Students(){//a constructor calling another constructor using this keyword and the parameters
        this(10, "Sumit", 979.0f);//are specific tho the constructor being called.
    }
}
public class Classes {
    public static void main(String[] args) {
        Students ob = new Students();//creates an address that points to object ob
        Students ob1= new Students(100, "sumit", 97.0f);//passing as parameter
        Students ob2= new Students(ob1);//passing of object as parameter
        System.out.println(ob.marks);
        System.out.println(ob1.marks);
        System.out.println(ob2.name);
        //Students() is the constructor of class Students that is being called.
        //here ob is just the refernce variable and without new keyword it doesn't get addrres to the
        //being created
    }
}
//Students ob is th declaration part, memory is not yet allotted to the object
//(Declaration is done during compile time)
//ther allocating of address is done during runtime
//new keyword can't be used for primitive data types and hence,they are stored in stack memory
//whereas objects are stores in heap memory
