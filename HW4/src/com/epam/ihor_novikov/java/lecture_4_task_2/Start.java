package com.epam.ihor_novikov.java.lecture_4_task_2;

public class Start {
    public static void main(String[] args) {
        Reading reading = new Reading();
        double first;
        double second;
        int action;

        do {
            System.out.println("Enter first number: ");
            first = reading.readNextDouble();
            System.out.println("Enter second number");
            second = reading.readNextDouble();

            Calculation calculation = new Calculation(first, second);

            System.out.println("Elect action: ");
            System.out.println("1: Adding ");
            System.out.println("2: Subtract ");
            System.out.println("3: Multiply ");
            System.out.println("4: Division ");
            System.out.println("0: Exit ");

            action = (int) Reading.readNextDouble();

            switch (action) {
                case 1 -> System.out.println("Sum is: " + calculation.add());
                case 2 -> System.out.println("Subtraction is: " + calculation.sub());
                case 3 -> System.out.println("Multiply is: " + calculation.mul());
                case 4 -> System.out.println("Division is: " + calculation.div());
                case 0 -> {
                }
                default -> {
                    System.out.println("Incorrect operation!");
                }
            }

        } while (action != 0);
    }

}