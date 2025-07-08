//import java.util.*;
class getset
{
    private String name; private int n;
    void setname(String name){
        this.name=name;
    }
    String getname(){
        return name;
    }
    void setn(int n){
        this.n=n;
    }
    int getn(){
        return n;
    }
}
class caller
{
    public static void main(String[] args)
    {
        getset ob = new getset();
        ob.setname("Sumit");
        ob.setn(23);
        System.out.println(ob.getname());
        System.out.println(ob.getn());
    }
}