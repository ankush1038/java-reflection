package com.bridgelabz.reflection.BasicLevel;

import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class PrivateMethodInvoke {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();

            // Get the Class object
            Class<?> cls = calc.getClass();

            // Get the private method 'multiply' with two int parameters
            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

            // Make the method accessible
            method.setAccessible(true);

            // Invoke the method with arguments 6 and 7
            int result = (int) method.invoke(calc, 6, 7);

            System.out.println("Result of multiply(6, 7): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

