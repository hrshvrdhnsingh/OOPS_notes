package com.harsh.demo1.Generics;

import java.util.Arrays;

//Suppose your ArrayList is of size 10, and after adding 10 elements we add another element,
//internally java creates another ArrayList of double size and copies all lements and then add 
//the last element
public class GenericArraylist<T> {
    private Object[] data;
    private static int DEFAULT_SIZE =10;
    private int size = 0;
    
    //YOu can;t create an instance of generic type.
    public GenericArraylist() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if(isFull()) 
            resize();
        data[size++] = num;
    }

    private boolean isFull(){
        return size==data.length;
    }

    private void resize(){
        Object[] temp = new Object[data.length*2];

        //Copy current items in new array
        for(int i=0;i<data.length;i++){
            temp[i]=(T)data[i];
        }
        data=temp; //this is possible only beacuse data is out of scope
    }

    public T remove(){
        T removed = (T)(data[--size]);
        return removed;
    }

    public T get(int index){
        return (T)(data[index]);
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    
    @Override
    public String toString() {
        return "GenericArrayList{"+"data"+Arrays.toString(data)+", size="+size+"}";
    }

    public static void main(String[] args) {
        //GenericArraylist list = new GenericArraylist();
        
        
        GenericArraylist<Integer> list2 = new GenericArraylist<Integer>();
        list2.add(12);
        System.out.println(list2);
    }
}
//The problem with this is that we can't implement other primitive data types in ArrayList
//Generics means parameterized types. The idea is to allow type (Integer, String, … etc., and user-defined types) 
//to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work 
//with different data types. An entity such as class, interface, or method that operates on a parameterized type is a generic entity.

//basically to custom data to your custom Classes. Like this GenericArrayList could work for all data types.
//Typical declaration of ArrayList: ArrayList<Integer> list = new ArrayList<>();
