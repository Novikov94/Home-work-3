package com.epam.ihor_novikov.java.lesson_12.task_8_2;

import java.util.HashMap;

public class HashCode {
    private static String genre;

    public HashCode(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCode that = (HashCode) o;
        return genre.equals(that.genre);
    }

    @Override
    public int hashCode () {
        int result = 0;
        if(genre.length() > 3){
            for (int i =0; i < 4 ; i++){
                result += genre.charAt(i);
            }
        } else {
            for (int i =0; i < genre.length() ; i++){
                result += genre.charAt(i);
            }
        }
        return result ;

    }

    @Override
    public String toString() {
        return genre;
    }

    public static void main(String[] args) {
        HashMap<Integer,HashCode> map = new HashMap<>();
        map.put(1,new HashCode("Rock"));
        map.put(2,new HashCode("Pop"));
        map.put(3,new HashCode("Rap"));
        map.put(4,new HashCode("Classical"));
        map.put(5,new HashCode("Jaz"));
        map.put(6,new HashCode("Disco"));

        for (int i = 1; i < map.size() + 1; i++) {
            System.out.println(i + "-" + map.get(i) + ": " + map.get(i).hashCode());
        }
    }
}
