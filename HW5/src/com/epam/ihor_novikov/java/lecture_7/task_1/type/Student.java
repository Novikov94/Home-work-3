package com.epam.ihor_novikov.java.lecture_7.task_1.type;

import com.epam.ihor_novikov.java.lecture_7.task_1.helper.Time;

import java.util.Calendar;

public class Student {

	private String nameStudent;
	private Curriculum curriculumStudent;
	private Calendar startDate;
	private Calendar endDate;

	public Student(String nameStudent, Curriculum curriculumStudent, Calendar startDate) {
		this.nameStudent = nameStudent;
		this.curriculumStudent = curriculumStudent;
		this.startDate = Time.getStartDate(startDate);
		this.endDate = Time.getEndDate(startDate, curriculumStudent);
	}

	public String getNameStudent() {
		return nameStudent;
	}


	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public Curriculum getCurriculumStudent() {
		return curriculumStudent;
	}


	public void setCurriculumStudent(Curriculum curriculumStudent) {
		this.curriculumStudent = curriculumStudent;
	}

	public Calendar getStartDate() {
		return startDate;
	}


	public Calendar getEndDate() {
		return endDate;
	}


	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Student [nameStudent=" + nameStudent + ", curriculumStudent=" + curriculumStudent.getNameCurriculum()
				+ ", startDate=" + startDate.get(Calendar.DAY_OF_YEAR) + ", endDate="
				+ endDate.get(Calendar.DAY_OF_YEAR) + "]";
	}

}
