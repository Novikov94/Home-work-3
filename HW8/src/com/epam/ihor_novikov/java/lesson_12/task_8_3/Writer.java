package com.epam.ihor_novikov.java.lesson_12.task_8_3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
    public static void main(String[] args) {
        Music music1 = new Music();
        Music music2 = new Music();

        try {
            FileOutputStream fos = new FileOutputStream("music.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(music1);
            oos.writeObject(music2);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
