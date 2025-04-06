package com.bridgelabz.reflection.IntermediateLevel;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            MathOperations obj = new MathOperations();
            Class<?> cls = obj.getClass();

            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = sc.nextLine();

            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Get the method by name and parameter types
            Method method = cls.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            Object result = method.invoke(obj, num1, num2);

            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

