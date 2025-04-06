package com.bridgelabz.reflection.Advanced;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(obj, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: Field not found - " + fieldName);
                }
            }

            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Object mapping failed", e);
        }
    }
}

class Student {
    private String name;
    private int age;

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class TestMapper {
    public static void main(String[] args) {
        Map<String, Object> studentData = new HashMap<>();
        studentData.put("name", "Ankush Sharma");
        studentData.put("age", 21);

        Student student = CustomObjectMapper.toObject(Student.class, studentData);
        student.display();
    }
}
