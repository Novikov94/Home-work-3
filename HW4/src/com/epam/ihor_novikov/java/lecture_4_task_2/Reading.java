package com.epam.ihor_novikov.java.lecture_4_task_2;

import java.util.Scanner;

public class Reading {
    public static double readNextDouble(){
        Scanner scanner = new Scanner(System.in);
        double i = 0;
        if(scanner.hasNextDouble()){
            i = scanner.nextDouble();
        }
        else{
            System.out.println("Wrong input");
        }
        return i;
    }
}
