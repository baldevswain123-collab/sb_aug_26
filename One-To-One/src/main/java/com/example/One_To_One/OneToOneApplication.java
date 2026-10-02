package com.example.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication {
	private final StudentRepository studentRepository;
	private final AdressRepository adressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return  args->{
			owninSideOperation();
		};
	}
	private void owninSideOperation(){
		Adress address = Adress.builder()
				.city("BBSR")
				.state("ODISHA")
				.country("India")
				.build();

		Student student = Student.builder()
				.studentName("baldev")
				.studentEmail("Baldev2gmail.com")
				.address(adress)
				.build();

		//   studentRepository.save(student);// because when we try to save owning side, inverse side must be present in database

		//1. Manually save  Address Object then save Student Object
		//   addressRepository.save(address);
		//   studentRepository.save(student);

		//2. Use Cascading
		//   studentRepository.save(student);

		//   UPDATE
//			     Student existingStudent = studentRepository.findById(4).orElseThrow();
//				 existingStudent.setStudentName("Baldev2");
//				 existingStudent.setStudentEmail("B2@gmailcom");
//				 Address existingAddress = existingStudent.getAddress();
//				 existingAddress.setCity("CTC");
//				 studentRepository.save(existingStudent);
//
		//   Remove
//		studentRepository.deleteById(4)

			Student newStudent   = Student.builder()
					.studentName("Binay")
					.studentEmail("B@gmail.com")
					.build();

     		Adress newAddress = Adress.builder()
				.city("Duburi")
				.state("jajpur")
				.country("India")
					.student(newStudent)
				.build(); 



	};


}