package com.modern.methodreferences;

import java.util.function.Supplier;

import com.modern.data.Student;

public class SupplierMethodReferenceExample {

    Supplier<Student> studentSupplier = Student::new;

    public static void main(String[] args) {

        System.out.println();

    }
}
