package com.example.SpringDataJPADemo;

import com.example.SpringDataJPADemo.model.Student;
import com.example.SpringDataJPADemo.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

	public static void main(String[] args) {
	ApplicationContext context= SpringApplication.run(SpringDataJpaDemoApplication.class, args);

		StudentRepository repo=context.getBean("studentRepository",StudentRepository.class);

		 //save into db
		Student st =new Student();
		st.setRollNo(108);st.setName("Deva Kumar");
		st.setMarks(76.56);
		repo.

		//list of all Student
		//repo.findAll().forEach(System.out::println);
	   //find by id
		Optional<Student> stduent= repo.findById(12334);
		System.out.println(stduent.orElse(new Student()));
		//find by Name
		List<Student> students=repo.findByName("Krishna Patel");
	         System.out.println(students);
	}

}
