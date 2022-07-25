package com.epam.ihor_novikov.java.lecture_7.task_1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentProgressReport {


	public static final int STARTTIMEHOUR = 10;

	public static final int ENDTIMEHOUR = 18; 


	public static final int START_DATE1 = -3;

	public static final int START_DATE2 = 10;

	public static void main(String[] args) {

		Calendar currentTime = new GregorianCalendar();
		if (args.length > 0) {
			Runner.startApp(args[0], currentTime);
		} else {
			Runner.startApp("", currentTime);
		}

	}

}
