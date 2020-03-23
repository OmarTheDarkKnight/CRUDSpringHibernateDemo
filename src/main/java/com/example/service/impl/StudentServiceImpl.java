/**
 * 
 */
package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.StudentDao;
import com.example.model.Student;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	public StudentServiceImpl() {}

	/* (non-Javadoc)
	 * @see com.example.service.StudentService#add(com.example.model.Student)
	 */
	@Transactional
	public void add(Student student) {
		studentDao.add(student);
	}

	/* (non-Javadoc)
	 * @see com.example.service.StudentService#getStudent(int)
	 */
	@Transactional
	public Student getStudent(int studentId) {
		return studentDao.getStudent(studentId);
	}

	/* (non-Javadoc)
	 * @see com.example.service.StudentService#getAllStudents()
	 */
	@Transactional
	public List getAllStudents() {
		return studentDao.getAllStudents();
	}

	/* (non-Javadoc)
	 * @see com.example.service.StudentService#edit(com.example.model.Student)
	 */
	@Transactional
	public void edit(Student student) {
		studentDao.edit(student);
	}

	/* (non-Javadoc)
	 * @see com.example.service.StudentService#delete(int)
	 */
	@Transactional
	public void delete(int studentId) {
		studentDao.delete(studentId);
	}

}
