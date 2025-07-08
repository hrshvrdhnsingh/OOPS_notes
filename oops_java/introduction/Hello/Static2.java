public class Static2 {
    static int age=10;
    static int year;
    //To initialise static variable we use the static block. This static blocl only gets executed once when the 
    //program first starts executing.(i.e; when the first object was created.)
    static{
        System.out.println("Hello from static block.");
        year=age*10;
        System.out.println(year);
    }
    public static void main(String[] args){
        Static2 ob = new Static2();
        System.out.println(Static2.age+" "+year);//Calling the by thia way makes more sense as static elements
        //belong to the class. Not using the Static2 would have also worked.
    }
}
//General rule of thumb is that a static object can't access an element that relies on others i.e; non-static elements.
