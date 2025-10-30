package com.example.app;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.app.dao.CourseDAO;
import com.example.app.dao.TeacherDAO;
import com.example.app.dao.TeacherDetailDAO;
import com.example.app.entity.Course;
import com.example.app.entity.Teacher;
import com.example.app.entity.TeacherDetail;

@SpringBootApplication
public class SpringHibernateHighApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateHighApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO, TeacherDetailDAO teacherDetailDAO,
			CourseDAO courseDAO) {
		return runner -> {
//			createTeacher(teacherDAO, teacherDetailDAO);
//			int i = 1;
//			findTeacherById(teacherDAO, i);
//			int j = 16;
//			findTeacherDetailById(teacherDetailDAO, j);

//			createCourses(teacherDAO, courseDAO);

//			findTeacherWithCourses(teacherDAO, 1);
//			findTeacherWithCoursesLazy(teacherDAO, courseDAO, 1);
			findTeacherWithCoursesLazyJoinFetch(teacherDAO, 1);

		};
	}

	private void findTeacherWithCoursesLazyJoinFetch(TeacherDAO teacherDAO, int i) {
		Teacher teacher1 = teacherDAO.findTeacherByIdJoinFetch(i);
		System.out.println(teacher1);
		System.out.println(teacher1.getCourses());
	}

	private void findTeacherWithCoursesLazy(TeacherDAO teacherDAO, CourseDAO courseDAO, int i) {
		Teacher teacher1 = teacherDAO.findTeacherById(i);
		System.out.println(teacher1);

		List<Course> courses = courseDAO.findCourseByTeacherId(i);
		System.out.println(courses);
	}

	private void findTeacherWithCourses(TeacherDAO teacherDAO, int i) {
		Teacher teacher1 = teacherDAO.findTeacherById(i);
		System.out.println(teacher1);
		System.out.println(teacher1.getCourses());
	}

	private void createCourses(TeacherDAO teacherDAO, CourseDAO courseDAO) {
		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setGender(true);
		teacherDetail.setAddress("hanoi");
		Teacher teacher = new Teacher("hoang", "duc", "duc@gmail.com", teacherDetail, null);

		Course c1 = new Course("hibernate", "good", null, null, null);
		Course c2 = new Course("fullstack", "good", null, null, null);
		teacher.addCourse(c1);
		teacher.addCourse(c2);

		teacherDAO.update(teacher);
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
		Teacher teacher = new Teacher("hoang", "duc", "duc@gmail.com", teacherDetail, null);
//		teacherDetailDAO.save(teacherDetail);
		teacherDAO.save(teacher);
		System.out.println("save");
	}
}
