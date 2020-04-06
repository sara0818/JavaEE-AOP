package controller;


import jdbc.StudentHomeworkJdbc;
import model.Homework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/mvc")
public class AddHomeworkController {
  @RequestMapping(value="/addHomework")
  public String addHomework(String title,String content){
    Homework homework = new Homework();
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
