package com.epam.ihor_novikov.java.lecture_7.task_1;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import com.epam.ihor_novikov.java.lecture_7.task_1.helper.ReportLong;
import com.epam.ihor_novikov.java.lecture_7.task_1.helper.ReportShort;
import com.epam.ihor_novikov.java.lecture_7.task_1.helper.Source;
import com.epam.ihor_novikov.java.lecture_7.task_1.type.Student;

/** Class for Run programm */
public class Runner {

	public static void startApp(String arg, Calendar currentTime) {

		Student[] students = Source.initialize(currentTime);

		Locale.setDefault(new Locale("en", "EN"));
		Locale localeEN = new Locale("en", "EN");
		ResourceBundle rbEN = ResourceBundle.getBundle("com.epam.ihor_novikov.java.lecture_7.task_1.helper.report.properties", localeEN);
		Locale localeRU = new Locale("ru", "RU");
		ResourceBundle rbRU = ResourceBundle.getBundle("com.epam.ihor_novikov.java.lecture_7_task1.helper.report_ru_ru.properties", localeRU);

		switch (arg) {

		case "0":
			ReportShort.printReportShort(students, currentTime, rbEN);

			break;

		case "1":
			ReportLong.printReportLong(students, currentTime, rbEN);
			break;

		case "2":
			ReportShort.printReportShort(students, currentTime, rbRU);
			break;

		case "3":
			ReportLong.printReportLong(students, currentTime, rbRU);

			break;

		default:
			ReportShort.printReportShort(students, currentTime, rbEN);
			ReportLong.printReportLong(students, currentTime, rbEN);
			ReportShort.printReportShort(students, currentTime, rbRU);
			ReportLong.printReportLong(students, currentTime, rbRU);

		}

	}

}
