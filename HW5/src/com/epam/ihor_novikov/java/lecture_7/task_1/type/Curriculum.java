package com.epam.ihor_novikov.java.lecture_7.task_1.type;

public class Curriculum {

    private String nameCurriculum;
    private Course coursesInCurriculum[];
    private int sumHours;

    public Curriculum(String nameCurriculum, Course... courses) {
        this.nameCurriculum = nameCurriculum;
        this.sumHours = 0;
        int i = courses.length;
        this.coursesInCurriculum = new Course[i];
        for (int j = 0; j < i; j++) {
            this.coursesInCurriculum[j] = new Course(courses[j].getNameCourse(), courses[j].getDurationHours());
            this.sumHours = this.sumHours + courses[j].getDurationHours();
        }
    }

    public int getSumHours() {
        return sumHours;
    }


    public String getNameCurriculum() {
        return nameCurriculum;
    }


    public void setNameCurriculum(String nameCurriculum) {
        this.nameCurriculum = nameCurriculum;
    }

    public Course[] getCoursesInCurriculum() {
        return coursesInCurriculum;
    }

}