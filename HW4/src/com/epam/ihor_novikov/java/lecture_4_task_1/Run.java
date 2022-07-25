package com.epam.ihor_novikov.java.lecture_4_task_1;

import java.util.Arrays;

public class Run {

    public static void main(String[] args) {
        Electric_devices microWave = new MicroWave("Delfi", "Kitchen", 1000, 5,true);
        Electric_devices vacuumCleaner = new VacuumCleaner("Saturn", "Bedroom", 1800,
                1200,false);
        Electric_devices washingMachine = new WashingMachine("Whirpool", "Bathroom", 2000, 500,
                true);

        Electric_devices[] electric_devices = new Electric_devices[3];
        electric_devices[0] = vacuumCleaner;
        electric_devices[1] = microWave;
        electric_devices[2] = washingMachine;
        Arrays.sort(electric_devices);

        for (Electric_devices devices : electric_devices) {
            System.out.println(devices);

        }
        System.out.println("Sum of power : " + Electric_devices.sumOfPowerOnDevices(electric_devices)
                + " ватт");
        System.out.println(Electric_devices.findByRoom(electric_devices));


    }
}
