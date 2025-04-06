package com.bridgelabz.reflection.BasicLevel;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfoReflection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the fully qualified class name (e.g., java.util.ArrayList): ");
        String className = sc.nextLine();

        try {
            Class<?> cls = Class.forName(className);

            System.out.println("\nClass: " + cls.getName());

            // Display Constructors
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor);
            }

            // Display Methods
            Method[] methods = cls.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println("  " + method);
            }

            // Display Fields
            Field[] fields = cls.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println("  " + field);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }

        sc.close();
    }
}

