package com.bridgelabz.reflection.IntermediateLevel;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "ORIGINAL_KEY";

    public static void printApiKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

public class StaticFieldAccess {
    public static void main(String[] args) {
        try {
            // Step 1: Get the Class object
            Class<?> cls = Class.forName("Configuration");

            // Step 2: Get the private static field 'API_KEY'
            Field field = cls.getDeclaredField("API_KEY");

            // Step 3: Make the field accessible
            field.setAccessible(true);

            // Step 4: Modify the value (null for static fields)
            field.set(null, "UPDATED_KEY");

            // Step 5: Verify the change
            Configuration.printApiKey();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

