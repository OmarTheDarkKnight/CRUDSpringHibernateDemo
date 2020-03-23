/**
 * 
 */
package com.example.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.StudentDao;
import com.example.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory session;

	/* (non-Javadoc)
	 * @see com.example.dao.StudentDao#add(com.example.model.Student)
	 */
	@Override
	public void add(Student student) {
		session.getCurrentSession().save(student);
	}
	
	/* (non-Javadoc)
	 * @see com.example.dao.StudentDao#getStudent(int)
	 */
	@Override
	public Student getStudent(int studentId) {
		return (Student)session.getCurrentSession().get(Student.class, studentId);
	}

	/* (non-Javadoc)
	 * @see com.example.dao.StudentDao#getAllStudents()
	 */
	@Override
	public List getAllStudents() {
		return session.getCurrentSession().createQuery("from Student").list();
	}

	/* (non-Javadoc)
	 * @see com.example.dao.StudentDao#edit(com.example.model.Student)
	 */
	@Override
	public void edit(Student student) {
		session.getCurrentSession().update(student);
	}

	/* (non-Javadoc)
	 * @see com.example.dao.StudentDao#delete(int)
	 */
	@Override
	public void delete(int studentId) {
		session.getCurrentSession().delete(getStudent(studentId));
	}
}
