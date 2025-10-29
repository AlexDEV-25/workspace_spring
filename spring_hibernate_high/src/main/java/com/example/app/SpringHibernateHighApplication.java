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
//			createTeacher(teacherDAO, teacherDetailDAO);
			int i = 1;
			findTeacherById(teacherDAO, i);
			int j = 16;
			findTeacherDetailById(teacherDetailDAO, j);

		};
	}

	private void findTeacherDetailById(TeacherDetailDAO teacherDetailDAO, int i) {
		if (teacherDetailDAO.findTeacherDetailById(i) != null) {
			System.out.println(teacherDetailDAO.findTeacherDetailById(i).toString());
			System.out.println(teacherDetailDAO.findTeacherDetailById(i).getTeacher());
		} else {
			System.out.println("noo");
		}
	}

	private void findTeacherById(TeacherDAO teacherDAO, int i) {
		if (teacherDAO.findTeacherById(i) != null) {
			System.out.println(teacherDAO.findTeacherById(i).toString());
			System.out.println(teacherDAO.findTeacherById(i).getTeacherDetail());
		} else {
			System.out.println("noo");
		}
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
