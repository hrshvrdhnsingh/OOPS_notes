package com.harsh.demo1.Generics;

import java.util.Arrays;

//Suppose your ArrayList is of size 10, and after adding 10 elements we add another element,
//internally java creates another ArrayList of double size and copies all lements and then add 
//the last element
public class customArrayList {
    private int[] data;
    private static int DEFAULT_SIZE =10;
    private int size = 0;
    
    public customArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()) 
            resize();
        data[size++] = num;
    }

    private boolean isFull(){
        return size==data.length;
    }

    private void resize(){
        int[] temp = new int[data.length*2];

        //Copy current items in new array
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp; //this is possible only beacuse data is out of scope
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int value){
        data[index] = value;
    }

    
    @Override
    public String toString() {
        return "CustomArrayList{"+"data"+Arrays.toString(data)+", size="+size+"}";
    }

    public static void main(String[] args) {
        customArrayList list = new customArrayList();
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
    }
}
//The problem with this is that we can't implement other primitive data types in ArrayList
//Generics means parameterized types. The idea is to allow type (Integer, String, … etc., and user-defined types) 
//to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work 
//with different data types. An entity such as class, interface, or method that operates on a parameterized type is a generic entity.

//basically to custom data to your custom Classes. Like this customArrayList could work for all data types.
//Typical declaration of ArrayList: ArrayList<Integer> list = new ArrayList<>();