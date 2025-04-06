package com.bridgelabz.reflection.BasicLevel;

import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class PrivateFieldAccess {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);

            // Get the Class object for Person
            Class<?> cls = person.getClass();

            // Get the private field 'age'
            Field ageField = cls.getDeclaredField("age");

            // Make the private field accessible
            ageField.setAccessible(true);

            // Get the current value of age
            int currentAge = (int) ageField.get(person);
            System.out.println("Original Age: " + currentAge);

            // Modify the value of age
            ageField.set(person, 30);

            // Get the modified value of age
            int modifiedAge = (int) ageField.get(person);
            System.out.println("Modified Age: " + modifiedAge);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
