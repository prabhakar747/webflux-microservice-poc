package com.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EasyDay3 {

    public  static Integer indexCounter =0 ;
    public static String[] logs= new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
    public static int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

    public static void main(String args[]){

        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
    }



}

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }