package com.core.leet.medium;

public class MediumDay1_AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		addTwoNumbers(l1,l2);
		
	}
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 
		 ListNode p1 = l1;
		 ListNode p2 = l2;
		 
		 ListNode resultHead = new ListNode(0);
		 ListNode resultIterator = resultHead;
		 Boolean carry = false;
		 
		 while(p1 != null || p2 != null) {
			 int sum = 0;
			 if(p1 == null) {
				 sum +=p2.val;
				 p2 = p2.next;
			 }else if(p2 == null) {
				 sum += p1.val;
				 p1 = p1.next;
			 }else {
				 sum = p1.val + p2.val;
				 p1 = p1.next;
				 p2 = p2.next;
			 }
			 
			 if(carry) {
				 sum++;
			 }
			 
			 if(sum >= 10) {
				sum %= 10;
				carry = true;
			 }else {
				 carry = false;
			 }
			 
			 ListNode newNode = new ListNode(sum);
			 resultIterator.next =   newNode;
			 resultIterator = resultIterator.next;
		 }
			
		 if(carry)
			 resultIterator.next = new ListNode(1);
		 
		 	 
		 
	     return resultHead.next;   
	    }
	
	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
}


