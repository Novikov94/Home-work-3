package com.epam.ihor_novikov.java.lesson_12.task_8_3;

import java.io.Serializable;

public class Music implements Serializable {
    private static int id = 1;
    private transient String genre = "Rock";
    private double duration;


    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
