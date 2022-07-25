package com.epam.ihor_novikov.java.lecture_4_task_1;

public class WashingMachine extends Electric_devices {
    private int rpm;

    public WashingMachine(String name, String room, int power, int rpm,boolean isOn) {
        super(name, room, power,isOn);
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public void washClothes() {
        System.out.println("I can wash your clothes");
    }


    @Override
    public String toString() {
        return "WashingMachine{" + super.toString() +
                "rpm=" + rpm +
                '}';
    }

}
