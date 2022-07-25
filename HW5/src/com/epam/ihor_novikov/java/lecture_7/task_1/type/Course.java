package com.epam.ihor_novikov.java.lecture_7.task_1.type;

public class Course {

    private String nameCourse;
    private int durationHours;

    public Course(String nameCourse, int durationHours) {
        this.nameCourse = nameCourse;
        this.durationHours = durationHours;
    }

    public String getNameCourse() {
        return nameCourse;
    }


    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }


    public int getDurationHours() {
        return durationHours;
    }


    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    @Override
    public String toString() {
        return "Course [nameCourse=" + nameCourse + ", durationHours=" + durationHours + "]";
    }

}
