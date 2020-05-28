package com.java.modern.lamda;

import java.util.List;
import java.util.function.BiConsumer;

import com.java.modern.data.Student;
import com.java.modern.data.StudentDataBase;

public class BiConsumerExample {
	
	public static void nameAndActivites() {
		
		List<Student>	list = StudentDataBase.getAllStudents();
		
		BiConsumer<String, List<String>> biConsumer = (name,activites) -> {
			System.out.println("name:"+name+"  activites: "+activites);
		};
		
		list.forEach((s) -> biConsumer.accept(s.getName(),s.getActivities()));
		
	}
	
	
	

	public static void main(String[] args) {
		
		BiConsumer<String, String> biConsumer = (a,b) -> {
			System.out.println("a:"+a+"b:"+b);
		};
		
		biConsumer.accept("Prabhakar", "Naidu");
		
		BiConsumer<Integer, Integer> mul = (a,b) -> {
			System.out.println("mul:"+a*b);
		};
		
		BiConsumer<Integer, Integer> division = (a,b) -> {
			System.out.println("division:"+a/b);
		};
		
		mul.andThen(division).accept(10, 10);
		nameAndActivites();
	 }

}
