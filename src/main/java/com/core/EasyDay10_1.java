package com.core;

import java.util.ArrayList;
import java.util.List;

public class EasyDay10_1 {
    public static void main(String[] args){
         System.out.println("Result of FizzBuzz: "+fizzBuzz(15).toString());
    }
    public static List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<String>();

        for (int i = 1; i <=n; i++) {
            if(i%3 == 0 && i%5 == 0)     resultList.add("FizzBuzz");
            else if(i%3 == 0 && i%5 != 0)     resultList.add("Fizz");
            else if(i%3 != 0 && i%5 == 0)     resultList.add("Buzz");
            else resultList.add(""+i);
        }
        return  resultList;
    }
}
