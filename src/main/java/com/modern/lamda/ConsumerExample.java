/**
 * 
 */
package com.modern.lamda;

import java.util.List;
import java.util.function.Consumer;

import com.modern.data.Student;
import com.modern.data.StudentDataBase;

/**
 * @author prabh
 *
 */
public class ConsumerExample {
	public static Consumer<Student>	c2 = (student) -> System.out.println(student);
	public static Consumer<Student>	c3 = (student) -> System.out.println(student.getActivities());
	
	public static void printNames() {
		System.out.println("-------printNames----------");
		
		List<Student> list = StudentDataBase.getAllStudents();
		list.forEach(c2);
	}
	
	public static void printNamesAndActivites() {
		System.out.println("-------printNamesAndActivites----------");
		
		List<Student> list = StudentDataBase.getAllStudents();
		list.forEach(c2.andThen(c3));
	}
	public static void printNamesAndActivitesWithCondition() {
		System.out.println("-------printNamesAndActivitesWithCondition----------");
		List<Student> list = StudentDataBase.getAllStudents();
		list.forEach(student -> {
			if(student.getGradeLevel() >= 3 && student.getGpa() >= 3.5) {
				c2.andThen(c3).accept(student);
			}
		});
	}
	public static void main(String[] args) {
		Consumer<String>	consumer = (s)	-> System.out.println(s.toUpperCase());
		consumer.accept("java8");
		//printNames();
		//printNamesAndActivites();
		printNamesAndActivitesWithCondition();
	}
	
	

}
