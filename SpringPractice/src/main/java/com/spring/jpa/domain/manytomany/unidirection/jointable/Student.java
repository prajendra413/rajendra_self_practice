package com.spring.jpa.domain.manytomany.unidirection.jointable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Student")
public class Student {

	@Id
	@Column(name="StudentId")
	private int studentId;
	
	@Column(name="StudentName")
	private String studentName;
	
	@ManyToMany
	@JoinTable(
			name="Student_Course",
			joinColumns={
					@JoinColumn(name="Student_ID")
			},
			inverseJoinColumns={
					@JoinColumn(name ="Course_ID")
			},
			uniqueConstraints={
					@UniqueConstraint(
							columnNames = { "Student_ID", "Course_ID" }
					)
			}
	)
	private List<Course> courses = new ArrayList<>();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}

