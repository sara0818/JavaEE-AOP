package controller;


import jdbc.StudentHomeworkJdbc;
import model.Homework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/mvc")
public class ModifyHomeworkController {

  @RequestMapping(value="/modifyHomework")
  public String modifyHomework(String title,String content){
    ApplicationContext context=new ClassPathXmlApplicationContext("/web/WEB-INF/applicationContext.xml");
    Homework h = context.getBean("homework",Homework.class);
    h.setContent(content);

    try {
      StudentHomeworkJdbc.modifyHomework(h,title);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return "/WEB-INF/index.jsp";
  }
}
