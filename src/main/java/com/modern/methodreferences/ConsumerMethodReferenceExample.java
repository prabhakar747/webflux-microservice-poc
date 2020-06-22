package com.modern.methodreferences;

import java.util.function.Consumer;

import com.modern.data.Student;
import com.modern.data.StudentDataBase;

public class ConsumerMethodReferenceExample {

    /**
     * Class::instancemethod
     */
    static Consumer<Student>  c1= System.out::println;


    /**
     * instance::instancemethod
     */
    static Consumer<Student> c2 = (student -> student.printListOfActivities());
    static Consumer<Student> c3 = (Student::printListOfActivities);

    public static void main(String[] args) {

        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);
        StudentDataBase.getAllStudents().forEach(c3);
    }

}
