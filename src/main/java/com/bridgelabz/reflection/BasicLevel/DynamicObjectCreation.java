package com.bridgelabz.reflection.BasicLevel;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> cls = Class.forName("Student");

            // Get the constructor with parameters (String, int)
            Constructor<?> constructor = cls.getConstructor(String.class, int.class);

            // Create the object using Constructor's newInstance method
            Object obj = constructor.newInstance("Ravi", 101);

            // Cast the object and invoke method
            Student student = (Student) obj;
            student.displayInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


