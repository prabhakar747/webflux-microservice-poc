package com.core;

import java.util.Stack;

public class EasyDay9_3 {

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("minStack getMin"+minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("minStack top"+minStack.top());    // return 0
        System.out.println("minStack getMin"+minStack.getMin()); // return -2


        MaxStack maxStack = new MaxStack();
        maxStack.push(2);
        maxStack.push(0);
        maxStack.push(3);
        System.out.println("maxStack getMax"+maxStack.peekMax()); // return 3
        maxStack.pop();
        System.out.println("maxStack top"+maxStack.top());    // return 0
        System.out.println("maxStack getMax"+maxStack.peekMax()); // return 2
    }
}

class MinStack {
    Stack<int[]> stack = new Stack<>();
    public MinStack() {

    }
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int[]{x,x});
            return;
        }
        int currentMin = stack.peek()[1];
        stack.push(new int[]{x,Math.min(x,currentMin)});
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek()[0];
    }
    public int getMin() {
        return  stack.peek()[1];
    }
}


class MaxStack {
    Stack<int[]> stack = new Stack<>();
    public MaxStack() {

    }
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int[]{x,x});
            return;
        }
        int currentMax = stack.peek()[1];
        stack.push(new int[]{x,Math.max(x,currentMax)});
    }
    public int pop() {
        return stack.pop()[0];
    }
    public int top() {
        return stack.peek()[0];
    }
    public int peekMax() {
        return  stack.peek()[1];
    }

    public int popMax() {
        return  stack.peek()[1];
    }
}

