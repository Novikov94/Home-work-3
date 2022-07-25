package com.epam.ihor_novikov.java.lecture_7.task_1.helper;

import com.epam.ihor_novikov.java.lecture_7.task_1.StudentProgressReport;
import com.epam.ihor_novikov.java.lecture_7.task_1.type.Course;
import com.epam.ihor_novikov.java.lecture_7.task_1.type.Student;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.ResourceBundle;


public class ReportLong {

    private static int MIN_WIDE_REPORT = 32;
    private static int LENGTH_WORD_CURRENT_DATE = 15;
    private static int LENGTH_HOURSES_COURSE = 4;
    private static int LENGTH_NUMBER_COURSE = 3;


    public static void printReportLong(Student[] students, Calendar currentTime, ResourceBundle rb) {

        int wideReport = getWideReport(students);
        String line = getLine(wideReport);

        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        for (Student currentStudent : students) {

            int minWideSecondColumn = wideReport - LENGTH_WORD_CURRENT_DATE;
            String lineFormater = "%-" + LENGTH_WORD_CURRENT_DATE + "s %" + minWideSecondColumn + "s\n";

            fmt.format(line + "\n");

            fmt.format(lineFormater, rb.getString("currentTime"), getDateToString(currentTime));

            fmt.format(lineFormater, rb.getString("startDate"), getDateToString(currentStudent.getStartDate()));

            fmt.format(lineFormater, rb.getString("finishDate"), getDateToString(currentStudent.getEndDate()));

            String tmpString = StudentProgressReport.STARTTIMEHOUR + ":00 - " + StudentProgressReport.ENDTIMEHOUR
                    + ":00";
            fmt.format(lineFormater, rb.getString("workingTime"), tmpString);

            fmt.format(lineFormater, rb.getString("student"), currentStudent.getNameStudent());

            fmt.format(lineFormater, rb.getString("CURRICULUM"),
                    currentStudent.getCurriculumStudent().getNameCurriculum());
            fmt.format(line + "\n");

            int i = 1;
            lineFormater = "%-" + (wideReport - LENGTH_HOURSES_COURSE - LENGTH_NUMBER_COURSE) + "s %"
                    + LENGTH_HOURSES_COURSE + "s\n";

            for (Course currentCourse : currentStudent.getCurriculumStudent().getCoursesInCurriculum()) {

                fmt.format(i + ". " + lineFormater, currentCourse.getNameCourse(), currentCourse.getDurationHours());
                i++;
            }
            fmt.format(line + "\n");
            fmt.format(rb.getString("TOTAL") + currentStudent.getCurriculumStudent().getSumHours() + "\n");

            if (Time.timeProgrammPassed(currentStudent, currentTime)) {
                fmt.format(rb.getString("completed"));
            } else {
                fmt.format(rb.getString("notCompleted"));
            }

            int workhours = Time.getDiffWorkTimeInHours(currentStudent, currentTime);

            int day = workhours / (StudentProgressReport.ENDTIMEHOUR - StudentProgressReport.STARTTIMEHOUR);
            int hours = workhours % (StudentProgressReport.ENDTIMEHOUR - StudentProgressReport.STARTTIMEHOUR);

            fmt.format(day + rb.getString("day") + hours + rb.getString("hours") + "\n\n");

            System.out.println(sb.toString());

            sb.setLength(0);

        }
        fmt.close();
    }

    private static String getDateToString(Calendar time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String tmp = dateFormat.format(time.getTime());
        return tmp;
    }

    private static int getWideReport(Student[] students) {
        int wideReport = MIN_WIDE_REPORT;
        int tmpWideReport = 0;

        for (Student currentStudent : students) {

            int lengthNameStudent = currentStudent.getNameStudent().length();
            int lengthCurriculumStudent = currentStudent.getCurriculumStudent().getNameCurriculum().length();

            if (lengthNameStudent > lengthCurriculumStudent) {
                tmpWideReport = lengthNameStudent;
            } else {
                tmpWideReport = lengthCurriculumStudent;
            }

            if ((tmpWideReport + LENGTH_WORD_CURRENT_DATE) > wideReport) {
                wideReport = tmpWideReport + LENGTH_WORD_CURRENT_DATE;
            }
        }
        return wideReport;
    }

    private static String getLine(int wideReport) {

        StringBuilder line = new StringBuilder(wideReport);
        for (int i = 0; i <= wideReport; i++) {
            line.append("-");
        }
        return line.toString();
    }

}
