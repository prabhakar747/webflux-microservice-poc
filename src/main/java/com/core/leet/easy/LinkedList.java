package com.core.leet.easy;

import org.w3c.dom.Node;

public class LinkedList {
    Node head; // head of list

    /* Linked list Node.  This inner class is made static so that
       main() can access it */
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        } // Constructor
    }

    /* This function prints contents of linked list starting from head */
    public void printList()
    {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }





    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = (Node) head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    public  static  int reverseInteger(){
        int inputNumber = 1534236469,  reverseNumber= 0;
        System.out.println("inputNumber: " + inputNumber);
        while(inputNumber != 0) {
            int remainder = inputNumber % 10;
            inputNumber /= 10;
            if (reverseNumber > Integer.MAX_VALUE/10 || (reverseNumber == Integer.MAX_VALUE / 10 && remainder > 7)) return 0;
            if (reverseNumber < Integer.MIN_VALUE/10 || (reverseNumber == Integer.MIN_VALUE / 10 && remainder < -8)) return 0;
            reverseNumber = reverseNumber * 10 + remainder;
        }

        return reverseNumber;
    }

    public static void main(String[] args) {


        LinkedList list = new LinkedList();

        Node n1 = new Node(10);
        Node n2 = new Node(11);
        Node n3 = new Node(12);


        list.head = n1;
        list.head.next = n2;
        n2.next = n3;

        list.printList();

        System.out.println("Reverse :"+reverseList(list.head));

        System.out.println("reverseNumber: " + reverseInteger());

    }


    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();

        while(i >= 0 || j >= 0) {
            int current1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int current2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int currentSum = current1 + current2 + carry;

            carry = currentSum / 10;
            sb.insert(0, Integer.toString(currentSum % 10));
            i--;
            j--;
        }

        if (carry > 0) {
            sb.insert(0, Integer.toString(carry));
        }

        return sb.toString();
    }
}
