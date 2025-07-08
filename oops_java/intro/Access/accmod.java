package com.harsh.demo1.Access;

public class accmod {
    private int num;//can be accesssed anywhere in this file i.e only in this class
    public String name;//can be accessed anywhere
    int age;//default modifier; doesn't allow in diferrent package but anywhere in the same package.
    protected int[] arr;//allows in subclass in another package but doesn't allow in different package when it's not a subclass.
    // i.e; only allows in the same package and to subclasses(the one that extends) in different packages.
    accmod(int num,String name){
        this.num=num;
        this.name=name;
        this.arr=new int[num];
    } 
}
