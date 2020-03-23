package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Student;
import com.example.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	//welcome page
	@RequestMapping("/index")
	public String welcomeForm(Map<String, Object> map) {
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudents());
		return "student"; // name of the jsp file
	}
	
	//Does all the works
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult bindings, @RequestParam String action, Map<String, Object> map) {
		Student studentResult = new Student();
		String resutlString;
		
		switch(action.toLowerCase()) {
		case "add":
			studentService.add(student);
			studentResult = student;
			resutlString = "Student added successfully!";
			break;
		
		case "edit":
			studentService.edit(student);
			studentResult = student;
			resutlString = "Student edited successfully!";
			break;
			
		case "delete":
			studentService.delete(student.getId());
			resutlString = "Student deleted successfully!";
			break;
			
		case "search":
			Student searchedStudent = studentService.getStudent(student.getId());
			studentResult = searchedStudent != null ? searchedStudent : new Student();
			resutlString = searchedStudent != null ? "No student found" : "Student found";
			break;
			
		default:
			resutlString = "No valid action found";
			break;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudents());
		map.put("userMessage", resutlString);
		return "student"; // name of the jsp file
	}

}
