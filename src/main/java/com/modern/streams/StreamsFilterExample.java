package com.java.modern.streams;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.java.modern.data.Student;
import com.java.modern.data.StudentDataBase;

public class StreamsFilterExample {

	public static List<Student> filterStudents() {

		List<Student> filteredStudentList = StudentDataBase.getAllStudents().stream()
				.filter(student -> student.getGpa() >= 3.9).filter(student -> student.getGender().equals("female"))
				.collect(toList());

		return filteredStudentList;
	}

	public static void main(String[] args) {

		System.out.println("Filtered Students : " + filterStudents());

	}
}
