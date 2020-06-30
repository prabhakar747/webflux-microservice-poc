package com.core.leet.easy;

public class EasyDay9_2 {

    public static void main(String[] args){
        MyStack myStack = new MyStack(5);
        myStack.push(10);
        myStack.push(2);
        myStack.push(10);
        myStack.push(5);
        System.out.println("Stack: "+myStack.array.toString());
        myStack.pop();

        System.out.println("Stack: Pop "+myStack.array.toString());
        System.out.println("Stack: peek "+myStack.peek());
        System.out.println("Stack: getMin "+myStack.getMin());
    }

}
class MyStack{
    int top;
    int capacity;
    int[] array;
    int minValue;

    public MyStack(int capacity){
        this.top = -1;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public void push(int value){
        if(isFull()) throw  new RuntimeException("Stack is full");
        array[++top] = value;
    }
    public int pop(){
        if(isEmpty()) throw  new RuntimeException("Stack is empty");
        return array[top--];
    }
    public int peek(){
        if(isEmpty()) throw  new RuntimeException("Stack is empty");
        return array[top];
    }

    public int getMin(){
        minValue =  peek();
        for (int i = top; i >= 0 ; i--) {
            if(minValue >= array[i]){
                minValue = array[i];
            }
        }
        return  minValue;
    }

    public boolean isFull(){
        return top==capacity;
    }
    public boolean isEmpty(){
        return top==-1;
    }

}
