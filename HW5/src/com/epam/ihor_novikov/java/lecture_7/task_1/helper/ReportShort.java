package com.epam.ihor_novikov.java.lecture_7.task_1.helper;

import com.epam.ihor_novikov.java.lecture_7.task_1.StudentProgressReport;
import com.epam.ihor_novikov.java.lecture_7.task_1.type.Student;

import java.util.Calendar;
import java.util.ResourceBundle;


public class ReportShort {

    public static void printReportShort(Student[] students, Calendar currentTime, ResourceBundle rb) {

        for (Student currentStudent : students) {

            System.out.print(currentStudent.getNameStudent() + " - " + currentStudent.getCurriculumStudent().getNameCurriculum());

            if (Time.timeProgrammPassed(currentStudent, currentTime)) {
                System.out.print(rb.getString("completed"));
            } else {
                System.out.print(rb.getString("notCompleted"));
            }

            int workhours = Time.getDiffWorkTimeInHours(currentStudent, currentTime);

            int day = workhours / (StudentProgressReport.ENDTIMEHOUR - StudentProgressReport.STARTTIMEHOUR);
            int hours = workhours % (StudentProgressReport.ENDTIMEHOUR - StudentProgressReport.STARTTIMEHOUR);

            System.out.println(day + rb.getString("day") + hours + rb.getString("hours"));
        }
    }
}
