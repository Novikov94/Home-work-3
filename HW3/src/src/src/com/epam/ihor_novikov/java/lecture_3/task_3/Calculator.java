package src.src.com.epam.ihor_novikov.java.lecture_3.task_3;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int first_num = getInt();
        int second_num = getInt();
        char operation = getOperation();
        int result = calc(first_num, second_num, operation);
        System.out.println("Result is: " + result);
    }

    public static int getInt() {
        System.out.println("Enter number:");
        int operand;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("Error! Try it one more time!");
            scanner.next();
            operand = getInt();
        }
        return operand;
    }

    public static char getOperation() {
        System.out.println("Enter the operation:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Error! Try it one more time!");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }


    public static int add(int first_num, int second_num) {
        return first_num + second_num;
    }

    public static int sub(int first_num, int second_num){
        return first_num - second_num;
    }
    public static int mul(int first_num, int second_num){
        return first_num * second_num;
    }
    public static int div(int first_num, int second_num){
        return first_num / second_num;
    }

    public static int calc(int first_num, int second_num,char operation) {
        int result;
        switch (operation) {
            case '+' -> result = add(first_num, second_num);
            case '-' -> result = sub(first_num, second_num);
            case '*' -> result = mul(first_num, second_num);
            case '/' -> result = div(first_num, second_num);
            default -> {
                System.out.println("Incorrect operation!");
                result = calc(first_num, second_num,getOperation());
            }
        }
        return result;
    }
}

