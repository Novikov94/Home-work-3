package com.epam.ihor_novikov.java.lecture_4_task_1;

public class VacuumCleaner extends Electric_devices  {
    private int suctionPower;

    public VacuumCleaner(String name, String room, int watt, int suctionPower, boolean isOn) {
        super(name, room, watt,isOn);
        this.suctionPower = suctionPower;
    }

    public int getSuctionPower() {
        return suctionPower;
    }

    public void setSuctionPower(int suctionPower) {
        this.suctionPower = suctionPower;
    }

    @Override
    public String toString() {
        return "VacuumCleaner{ " + super.toString() +
                "suctionPower= " + suctionPower +
                '}';
    }


}
