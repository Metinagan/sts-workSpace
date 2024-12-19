package com.metinagan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metinagan.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	//HQL kullandığımız için class isimleri ve değişken ile yazıyoruz.
	//eğerki native query yazarsak veirtabanındaki tablo ismi ile
	@Query(value = "from Student" , nativeQuery = false)
	List<Student> findAllStudent();
	
	//Sql sorgusu için böyle yazıyoruz.
	//student şeması içerisindeki student tablosunan git.
	@Query(value = "select * from student.student" , nativeQuery = true)
	List<Student> findAllStudent1();
	
	
	//iki noktayı dışarıdan gelen değişkenden önce kullan
	@Query(value = "from Student s WHERE s.id= :studentId" , nativeQuery = false)
	Optional<Student> findStudentById(Integer studentId);

}
