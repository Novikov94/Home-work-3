package src.src.com.epam.ihor_novikov.java.lecture_3.task_2;

import java.util.Scanner;

public class OperationsWithStrings {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter count of line: ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.print("Error");
            return;
        }
        Scanner scanner1 = new Scanner(System.in);
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter line № " + (i + 1) + ": ");
            strings[i] = scanner1.nextLine();
        }
        OperationsWithStrings operationsWithStrings = new OperationsWithStrings();
        operationsWithStrings.lengthOfTheLines(strings);
    }

    public void lengthOfTheLines(String[] str) {
        double avr = 0;
        for (String item : str) {
            avr += item.length();
        }
        avr /= str.length;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() < avr) {
                System.out.println("Line less than average is: " + '"' + str[i] + '"');
                System.out.println("Length = " + str[i].length());
            }
        }
    }
}

