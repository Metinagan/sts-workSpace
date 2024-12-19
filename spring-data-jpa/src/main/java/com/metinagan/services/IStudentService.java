package com.metinagan.services;

import java.util.List;

import com.metinagan.dto.DtoStudent;
import com.metinagan.dto.DtoStudentIU;

public interface IStudentService {
	
	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent> getAllStudent();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id,DtoStudentIU dtoStudentIU);

}
