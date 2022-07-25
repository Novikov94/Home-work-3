package com.epam.ihor_novikov.java.lesson_12.task_8_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Reader {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("music.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Music music1 = (Music)ois.readObject();
            Music music2 = (Music)ois.readObject();
            ois.close();

            System.out.println(music1);
            System.out.println(music2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
