package com.epam.ihor_novikov.java.lecture_4_task_2;

public class Calculation {

    private final double first_num ;
    private final double second_num ;

    public Calculation() {
        this.first_num = 0;
        this.second_num = 0;
    }

    public Calculation(double first_num, double second_num) {
        this.first_num = first_num;
        this.second_num = second_num;
    }

    public double add() {
        return first_num + second_num;
    }

    public double sub() {
        return first_num - second_num;
    }

    public double mul() {
        return first_num * second_num;
    }

    public double div() {
        return first_num / second_num;
    }
}

