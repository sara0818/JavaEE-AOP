package controller;


import jdbc.StudentHomeworkJdbc;
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/mvc")
public class ModifyStudentController {

  @RequestMapping(value="/modifyStudent")
  public String modifyStudent(String modifyName,String orginalName){
    Student s = new Student();
    s.setName(modifyName);

    try {
      StudentHomeworkJdbc.modifyStudent(s,orginalName);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return "/WEB-INF/index.jsp";
  }
}
