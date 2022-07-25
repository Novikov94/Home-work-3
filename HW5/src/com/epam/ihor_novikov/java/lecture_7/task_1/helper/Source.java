package com.epam.ihor_novikov.java.lecture_7.task_1.helper;

import com.epam.ihor_novikov.java.lecture_7.task_1.StudentProgressReport;
import com.epam.ihor_novikov.java.lecture_7.task_1.type.Course;
import com.epam.ihor_novikov.java.lecture_7.task_1.type.Curriculum;
import com.epam.ihor_novikov.java.lecture_7.task_1.type.Student;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Source {

    public static Student[] initialize(Calendar currentTime) {

        Course[] courses;
        courses = new Course[]{new Course("Java Servlets", 16),
                new Course("Struts Framework", 24),
                new Course("Java", 8), new Course("JFC/Swing ", 16),
                new Course("JDBC", 16),};

        Curriculum j2EEDeveloper = new Curriculum("J2EE Developer", courses[0], courses[1]);
        Curriculum javaDeveloper = new Curriculum("Java Developer", courses[2], courses[3], courses[4]);

        currentTime.set(Calendar.MILLISECOND, 0);
        currentTime.set(Calendar.SECOND, 0);
        currentTime.set(Calendar.MINUTE, 0);

        Calendar startTime1;
        startTime1 = new GregorianCalendar();
        Calendar startTime2 = new GregorianCalendar();
        startTime1 = (Calendar) currentTime.clone();
        startTime2 = (Calendar) currentTime.clone();

        startTime1.add(Calendar.DATE, StudentProgressReport.START_DATE1);
        startTime2.add(Calendar.DATE, StudentProgressReport.START_DATE2);

        Student students[] = new Student[]{new Student("Ivanov Ivan - have very long name",
                j2EEDeveloper, startTime1),
                new Student("Petrov Petr", javaDeveloper, startTime2)};

        return students;
    }

}
