package controller;


import jdbc.StudentHomeworkJdbc;
import model.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/mvc")
public class StudentHomeworkController {

  @RequestMapping(value="/studentHomework")
  public String addHomework(Model model){
    List<StudentHomework> list = null;
    try {
      list = StudentHomeworkJdbc.selectAll();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    model.addAttribute(list);
    return "/WEB-INF/index.jsp";
  }
}
