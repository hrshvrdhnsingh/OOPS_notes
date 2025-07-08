package com.harsh.demo1.ObjectDemo;

public class hashcodeoverride {
    int num;

    public hashcodeoverride(int num) {
        this.num = num;
    }
    @Override
    public int hashCode(){
        return num;
    }

    public static void main(String[] args) {
        hashcodeoverride ob = new hashcodeoverride(10);
        System.out.println(ob.hashCode());
    }
    //Even if we create a diffrerent object with value 10, it would give a different hashcode as 
    //it relates to the object and not the value.
}
