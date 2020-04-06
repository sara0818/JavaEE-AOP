package controller;


import jdbc.StudentHomeworkJdbc;
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/mvc")
public class AddStudentController {

  @RequestMapping(value="/addStudent")
  public String addStudent(String studentName){
    Student s = new Student();

    s.setName(studentName);

    try {
      StudentHomeworkJdbc.addStudent(s);
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return "/WEB-INF/index.jsp";
  }
}
