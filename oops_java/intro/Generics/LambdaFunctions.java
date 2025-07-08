package com.harsh.demo1.Generics;

import java.util.ArrayList;

//One-Line functions.
public class LambdaFunctions {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<5;i++) arr.add(i*2);

        arr.forEach(/*pparameter of function*/(item)->/*Body of function*/System.out.println(item*2));
    }
    //this sum() function can be done in one line whih wou;d the be called Lambda Function.
    int sum(int a, int b){
        return a+b;
    }
}
