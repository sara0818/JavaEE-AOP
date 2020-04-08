package controller;


import jdbc.StudentHomeworkJdbc;
import model.Homework;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/mvc")
public class AddStudentController {

  @RequestMapping(value="/addStudent")
  public String addStudent(String studentName){
    ApplicationContext context=new ClassPathXmlApplicationContext("/web/WEB-INF/applicationContext.xml");
    Student s = context.getBean("student",Student.class);
//    Student s = new Student();

    s.setName(studentName);

    try {
      StudentHomeworkJdbc.addStudent(s);
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return "/WEB-INF/index.jsp";
  }
}
