package controller;


import jdbc.StudentHomeworkJdbc;
import model.Homework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/mvc")
public class ModifyHomeworkController {

  @RequestMapping(value="/modifyHomework")
  public String modifyHomework(String title,String content){
    Homework h = new Homework();
    h.setContent(content);

    try {
      StudentHomeworkJdbc.modifyHomework(h,title);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return "/WEB-INF/index.jsp";
  }
}
