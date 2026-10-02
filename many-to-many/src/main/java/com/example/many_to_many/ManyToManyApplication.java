package com.example.many_to_many;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToManyApplication {
	private final StudentRepository studentRepository;
	private final SubjectRepository subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
//			oneWayBinding();
//			Student student1= Student.builder().studentName("Baldev").studentEmail("baldev@gmail.com").build();
//			Student student2= Student.builder().studentName("Anisha").studentEmail("anisha@gmail.com").build();
//			Student student3= Student.builder().studentName("Digital").studentEmail("digital@gmail.com").build();
//
//			Subject subject1= Subject.builder().subjectName("CSS").students(List.of(student1,student2)).build();
//			Subject subject2= Subject.builder().subjectName("HTML").students(List.of(student2,student3)).build();
//			Subject subject3= Subject.builder().subjectName("Javascript").students(List.of(student3,student1)).build();
//			Subject subject4= Subject.builder().subjectName("Angular").students(List.of(student1)).build();
//
//			student1.setSubjects(List.of(subject1,subject3,subject4));
//			student2.setSubjects(List.of(subject1,subject2));
//			student3.setSubjects(List.of(subject2,subject3));
//			subjectRepository.saveAll(List.of(subject1,subject2,subject3,subject4));

//			EXTRACT
			subjectRepository.findAll().forEach(subject -> {
				subject.getStudents().forEach(student -> {
					System.out.println(student.getStudentName()+"---------> "+subject.getSubjectName());
				});
			});
		};
	}



	private void oneWayBinding(){
		//Save
		Subject subject1 = Subject.builder().subjectName("C").build();
		Subject subject2 = Subject.builder().subjectName("C++").build();
		Subject subject3 = Subject.builder().subjectName("Python").build();
		Subject subject4 = Subject.builder().subjectName("Java").build();

		Student student1 = Student.builder()
				.studentName("Amit")
				.studentEmail("amit@gmail.com")
				.subjects(List.of(subject1, subject2))
				.build();

		Student student2 = Student.builder()
				.studentName("Ankit")
				.studentEmail("ankit@gmail.com")
				.subjects(List.of(subject2, subject3))
				.build();

		Student student3 = Student.builder()
				.studentName("Baldev")
				.studentEmail("Baldev@gmail.com")
				.subjects(List.of(subject3, subject4))
				.build();

	//	studentRepository.saveAll(List.of(student1, student2, student3));

	//  Update

	//  Delete

	//  Extract
		studentRepository.findAll().forEach(student -> {
			System.out.println("student name is:"+student.getStudentName());
			student.getSubjects().forEach(subject-> {
				System.out.println(student.getStudentName() + "\t->\t" + subject.getSubjectName());
			});
		});

	}
}
