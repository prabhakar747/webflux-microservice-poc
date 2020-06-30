package com.core.leet.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EasyDay13_3 {

	public static void main(String[] args) {
		 int input = 5;
		  System.out.println("finalCount:"+print_first_N_primes(input));
		
		
	}
	
	 
	
	public static int print_first_N_primes(int n)  
	{  
	    // Declare the variables  
	    int i, j, flag, finalCount = 0;
	    
	    if(n ==0 || n==1 || n==2) return finalCount;
        
	    
	    // Print display message  
	    System.out.println("Prime numbers between 1 and " 
	                                      + n + " are:");  
	  
	    // Traverse each number from 1 to N  
	    // with the help of for loop  
	    for (i = 2; i <= n; i++)  
	    {  
	  
	        // Skip 0 and 1 as they are  
	        // niether prime nor composite  
	        if (i == 1 || i == 0)  
	            continue;  
	  
	        // flag variable to tell  
	        // if i is prime or not 
	        flag = 1;  
	  
	        for (j = 2; j <= i / 2; ++j)  
	        {  
	            if (i % j == 0) 
	            {  
	                flag = 0;  
	                break;  
	            }  
	        }  
	  
	        // flag = 1 means i is prime  
	        // and flag = 0 means i is not prime  
	        if (flag == 1)  {
	        	 System.out.print(i + " ");  
	        	finalCount++;
	        }
	           
	    }  
	    return finalCount;
	}  
	  
	
}
