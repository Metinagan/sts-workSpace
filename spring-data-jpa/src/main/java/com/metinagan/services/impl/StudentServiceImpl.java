package com.metinagan.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metinagan.dto.DtoCourse;
import com.metinagan.dto.DtoStudent;
import com.metinagan.dto.DtoStudentIU;
import com.metinagan.entities.Course;
import com.metinagan.entities.Student;
import com.metinagan.repository.StudentRepository;
import com.metinagan.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtostudentıu) {
		//Dışardan gelen veriyi istediğimiz veri şekline dönüştürüyoruz
		//ve sonra kaydediyoruz.
		Student student=new Student();
		BeanUtils.copyProperties(dtostudentıu, student);
		Student dbStudent=studentRepository.save(student);
		
		//dışarıya döneceğimiz veriyi de istediğimiz şekle dönüştürüyoruz
		DtoStudent dtoStudent=new DtoStudent();
		BeanUtils.copyProperties(dbStudent, dtoStudent);
		return dtoStudent;
	}

	@Override
	public List<DtoStudent> getAllStudent() {
		List<Student> studentList=studentRepository.findAllStudent1();
		List<DtoStudent>dtoList=new ArrayList<>();
		
		for (Student student : studentList) {
			DtoStudent dto=new DtoStudent();
			BeanUtils.copyProperties(student, dto);
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer ıd) {
		Optional<Student> optional = studentRepository.findStudentById(ıd);
		if(optional.isPresent()) {
			DtoStudent dtostudent=new DtoStudent();
			BeanUtils.copyProperties(optional.get(), dtostudent);
			
			
			for (Course course : optional.get().getCourses()) {
				DtoCourse dtocourse=new DtoCourse();
				BeanUtils.copyProperties(course, dtocourse);
				dtostudent.getCourses().add(dtocourse);
				}
			
			return dtostudent;
		}
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> optional =studentRepository.findById(id);
		if (optional!=null) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
		
		Optional<Student> optional=studentRepository.findById(id);
		if(optional.isPresent()) {
			Student student=optional.get();
			
			student.setFirstName(dtoStudentIU.getFirstName());
			student.setLastName(dtoStudentIU.getLastName());
			student.setBirtOfDate(dtoStudentIU.getBirtOfDate());
			Student updatedStudent= studentRepository.save(student);
			
			DtoStudent dtoStudent=new DtoStudent();
			BeanUtils.copyProperties(updatedStudent, dtoStudent);
			return dtoStudent;
		}
		
		return null;
	}

}
