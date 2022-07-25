package com.epam.ihor_novikov.java.lesson_12.task_8_1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter operation");
        String operation = input.nextLine();
        System.out.println("Enter path");
        String path = input.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> words = new ArrayList<>();

        String str = null;
        while ((str = br.readLine()) != null) {
            words.addAll(Arrays.asList(str.toLowerCase(Locale.ROOT).split(" ")));
        }

        if (operation.equals("frequency")) {

            Map map = new HashMap<>();
            map = words.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));

            System.out.println(map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .limit(2).sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()));

        } else if (operation.equals("length")) {
            words.stream().sorted(Comparator.comparingInt(String::length).reversed())
                    .limit(3).peek(x -> System.out.println(x.length())).forEach(System.out::println);

        } else if (operation.equals("duplicates")) {
            List<String> duplicates = words.stream()
                    .filter(e -> Collections.frequency(words, e) > 1).limit(3).toList();
            duplicates.forEach(System.out::println);

            for (String d : duplicates) {
                String s = d;
                StringBuilder sb = new StringBuilder(s);
                sb.reverse();
                String text = sb.toString().toUpperCase(Locale.ROOT);
                System.out.println(text);
            }
        } else {
            System.out.println("Entered invalid operation");
        }
    }
}