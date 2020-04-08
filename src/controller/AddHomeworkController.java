package controller;


import jdbc.StudentHomeworkJdbc;
import model.Homework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/mvc")
public class AddHomeworkController {
  @RequestMapping(value="/addHomework")
  public String addHomework(String title,String content){
    ApplicationContext context=new ClassPathXmlApplicationContext("/web/WEB-INF/applicationContext.xml");
    Homework homework = context.getBean("homework",Homework.class);
//    Homework homework = new Homework();
    homework.setTitle(title);
    homework.setContent(content);

    try {
      StudentHomeworkJdbc.addHomework(homework);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return "/WEB-INF/index.jsp";
  }


}
