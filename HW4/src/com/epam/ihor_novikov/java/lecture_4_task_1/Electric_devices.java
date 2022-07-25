package com.epam.ihor_novikov.java.lecture_4_task_1;


import java.util.Scanner;

public abstract class Electric_devices implements Comparable {
    private String name;
    private String room;
    private int watt;
    private boolean turnOn;

    public boolean isTurnOn() {
        return turnOn;
    }

    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }

    public Electric_devices(String name, String room, int watt, boolean turnOn) {
        this.name = name;
        this.room = room;
        this.watt = watt;
        this.turnOn = turnOn;
    }

    public int on() {
        return watt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getPower() {
        return watt;
    }

    public void setPower(int watt) {
        this.watt = watt;
    }


    @Override
    public String toString() {
        return "Electric_devices{" +
                "name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", power=" + watt +
                '}';
    }

    public boolean isOn() {
        return turnOn;
    }

    @Override
    public int compareTo(Object o) {
        Electric_devices tmp = (Electric_devices) o;
        if (this.watt < tmp.watt) {
            return 1;
        } else if (this.watt > tmp.watt) {
            return -1;
        }
        return 0;
    }

    public static int sumOfPowerOnDevices(Electric_devices[] array) {
        int sumOfPower = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].turnOn == true) {
                sumOfPower += array[i].getPower();
            }
        }
        return sumOfPower;
    }

    public static char[] findByRoom(Electric_devices[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter part of room: ");
        Electric_devices search = null;
        String room = scanner.nextLine();
        for (Electric_devices eld : array) {
            if (eld != null && eld.getRoom() != null && eld.getRoom().toLowerCase().equals(room.toLowerCase())){
                search = eld;
                break;
            }
        }

        System.out.println("Search: " + search);
        return new char[0];
    }
}

