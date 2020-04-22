package controller;


import jdbc.StudentHomeworkJdbc;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/mvc")
public class ModifyStudentController {

  @RequestMapping(value="/modifyStudent")
  public String modifyStudent(String modifyName,String orginalName){
    ApplicationContext context=new ClassPathXmlApplicationContext("/web/WEB-INF/applicationContext.xml");
    Student s = context.getBean("student",Student.class);
    s.setName(modifyName);

    try {
      StudentHomeworkJdbc.modifyStudent(s,orginalName);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return "/WEB-INF/index.jsp";
  }
}
