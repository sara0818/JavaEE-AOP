package controller;


import jdbc.StudentHomeworkJdbc;
import model.Student;
import model.StudentHomework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/mvc")
public class ResubmitHomeworkController {

  @RequestMapping(value="/resubmitHomework")
  public String resubmitHomework(String studentID,String homeworkID,String title,String content){
    ApplicationContext context=new ClassPathXmlApplicationContext("/web/WEB-INF/applicationContext.xml");
    StudentHomework sh = context.getBean("studentHomework",StudentHomework.class);


    sh.setStudentId(Long.parseLong(studentID));
    sh.setHomeworkId(Long.parseLong(homeworkID));
    sh.setHomeworkTitle(title);
    sh.setHomeworkContent(content);

    try {
      StudentHomeworkJdbc.resubmitHomework(sh);
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return "/WEB-INF/index.jsp";
  }
}
