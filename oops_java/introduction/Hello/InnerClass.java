
//Again here, the outside class can't be static because there is no upper body that can call that class.
public class InnerClass {
    static class Test{ // static means it's only instantiated once and stays for the lifetime of the class.
        String name;       
        public Test(String name){
            this.name=name;
        }
    }
    //Here it's obvious that Test class is dependant on InnerClass(non-static context). So on creating an object of Test class,
    //we can't use the methods. Hence we need the class Test to be static so that it's no longer dependent 
    //on the objects of this class. And just object of the Test class would suffice.
    public static void main(String[] args){
        Test ob1 = new Test("Harsh");
        Test ob2 = new Test("Sumit");

    }
    //THoughe the outer class is static, still objects ob1 and ob2 point to different things.The class being static means that
    //it doesn't depend on InnerClass but still the variables inside it behave independently.
    //Objects are created during runtime but since static methos have nothing to do with objects,
    //they are compile-time based.
}
