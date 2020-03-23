package com.example.service;

import java.util.List;
import com.example.model.Student;

public interface StudentService {
	public void add(Student student);
	public Student getStudent(int studentId);
	public List getAllStudents();
	public void edit(Student student);
	public void delete(int studentId);
}
