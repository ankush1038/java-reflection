package com.bridgelabz.reflection.IntermediateLevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Annotation;

// Create a custom annotation
@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@interface Author {
    String name();
}

// Apply annotation to a class
@Author(name = "Ankush Sharma")
class Book {
    private String title = "Reflection in Java";
}

public class AnnotationExample {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> cls = Class.forName("Book");

            // Check if @Author is present
            if (cls.isAnnotationPresent(Author.class)) {
                // Retrieve the annotation
                Author author = cls.getAnnotation(Author.class);
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("@Author annotation not present.");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

