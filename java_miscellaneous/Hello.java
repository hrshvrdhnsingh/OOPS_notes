//import java.util.*;
class Hllo
{
    void print(){
        System.out.println("Public ");
    }
    private void print(int a){
        System.out.println("Private");
    }
    protected void print(double b){
        System.out.println("Protected");
    }
    void display(){
        Hllo ob = new Hllo();
        ob.print();
        ob.print(1);
        ob.print(1.9);
    }
}
public class Hello
{
    public static void main(String[] args)
    {
        Hllo ob = new Hllo();
        ob.print();
        ob.print(1);
        ob.print(1.9);
        ob.display();
    }
}