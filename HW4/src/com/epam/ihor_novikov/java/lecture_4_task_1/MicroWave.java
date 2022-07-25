package com.epam.ihor_novikov.java.lecture_4_task_1;

public class MicroWave extends Electric_devices {
    private int timeOfWarmUp;

    public MicroWave(String name, String room, int power, int timeOfWarmUp,boolean isOn) {
        super(name, room, power, isOn);
        this.timeOfWarmUp = timeOfWarmUp;
    }

    public void warmUp() {
        System.out.println("I can warm up your meal");
    }

    @Override
    public String toString() {
        return "MicroWave{" + super.toString() +
                "timeOfWarmUp=" + timeOfWarmUp +
                '}';
    }

}
