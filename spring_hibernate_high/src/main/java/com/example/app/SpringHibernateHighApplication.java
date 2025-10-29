package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.app.dao.TeacherDAO;
import com.example.app.dao.TeacherDetailDAO;
import com.example.app.entity.Teacher;
import com.example.app.entity.TeacherDetail;

@SpringBootApplication
public class SpringHibernateHighApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateHighApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO, TeacherDetailDAO teacherDetailDAO) {
		return runner -> {
			createTeacher(teacherDAO, teacherDetailDAO);

		};
	}

	private void createTeacher(TeacherDAO teacherDAO, TeacherDetailDAO teacherDetailDAO) {
		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setGender(true);
		teacherDetail.setAddress("hanoi");
		Teacher teacher = new Teacher("hoang", "duc", "duc@gmail.com", teacherDetail);
//		teacherDetailDAO.save(teacherDetail);
		teacherDAO.save(teacher);
		System.out.println("save");
	}
}
