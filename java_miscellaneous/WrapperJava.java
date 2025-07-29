//import java.util.*;
//Wrapper Classes are used to store primitive types, which are typiclly operated upon differenly
public class WrapperJava
{
    public static void main(String[] args) {
        int a=10;//normal way; as primitive
        Integer b = a;//instantiated as an object; thus allows various operations
        Float c = Float.valueOf(a);//For different data types
        System.out.println(b); 
        System.out.println(c);
        String s = Integer.toHexString(11976457);
        //toHexString, toOctalString, ToBinaryString to convert into respective bases
        System.out.println(s);

        //When in primitive type, it is passed by value whereas it's passed as refernce for objects
        //These Wrapper Classes are "final"; i.e; it prevents modifiations(only for primitive types as for objects it can be updated like
        //ob.name="" but it can't be reassigned )
        //final variables need to be initialised when declared
        //Suppose, we have created an object but we reassign it to a different value, the old is removed by the Garbage Collector of Java 
        //as one object can't point to multiple addresses
    }
}