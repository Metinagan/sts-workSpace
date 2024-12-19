package com.metinagan.controller;

import java.util.List;

import com.metinagan.dto.DtoStudent;
import com.metinagan.dto.DtoStudentIU;

public interface IStudentController {
	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	
	public List<DtoStudent> getAllStudent();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id,DtoStudentIU dtoStudentIU);

}
