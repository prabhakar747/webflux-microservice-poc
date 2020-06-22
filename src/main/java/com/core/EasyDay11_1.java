package com.core;

public class EasyDay11_1 {

    public static void main(String[] args){
        int n1= 9;
        System.out.println(fibonacciWithRecursion(n1));
        System.out.println(""+fibonacciWithDynamicPrograming(n1));
        int stairs = 5;
        System.out.println(climbStairs(stairs));
        System.out.println(""+climbStairs(stairs));
    }

    public static int fibonacciWithRecursion(int n){
        //fib n = fib n-1 +fib n-2
        if (n <= 1)
            return n;
        return fibonacciWithRecursion(n-1) + fibonacciWithRecursion(n-2);
    }

    public static int fibonacciWithDynamicPrograming(int n){

        int a=0, b=1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n ; i++) {
            c = a + b;
            a=b;
            b=c;
        }

        return b;
    }

    public static int climbStairs(int n) {
    return 0;
    }


}
