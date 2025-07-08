//import java.util.*;
class Shapes
{
    int len,bre;
    Shapes(int len, int bre){
        this.len=len; this.bre=bre;
    }
    final int AR(int l, int b){
        return l*b;
    }
    float AT(int b, int h){
        return (float)0.5*b*h;
    }
    int AS(int side){
        return side*side;
    }

    public static void main(String[] args)
    {
        Shapes ob = new Shapes(10,20);
        System.out.println(ob.AR(12,3));
        System.out.println(ob.AS(25));
        System.out.println(ob.AT(12,36));
        System.out.println(ob.len);
        System.out.println(ob.bre);

    }
}