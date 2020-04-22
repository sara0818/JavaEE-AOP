package aop;

import jdbc.DatabasePool;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Aspect
@Component
public class Aop {
  DatabasePool db;
  public Aop(DatabasePool db){
    this.db=db;
  }

  @Pointcut("execution(* jdbc.StudentHomeworkJdbc.addHomework(..))")
  private void addHomework(){}

  @Pointcut("execution(* jdbc.StudentHomeworkJdbc.addStudent(..))")
  private void addStudent(){}

  @Pointcut("execution(* jdbc.StudentHomeworkJdbc.modifyHomework(..))")
  private void modifyHomework(){}

  @Pointcut("execution(* jdbc.StudentHomeworkJdbc.modifyStudent(..))")
  private void modifyStudent(){}

  @Pointcut("execution(* jdbc.StudentHomeworkJdbc.submitHomework(..))")
  private void submitHomework(){}

  @Pointcut("execution(* jdbc.StudentHomeworkJdbc.resubmitHomework(..))")
  private void resubmitHomework(){}

  @Pointcut("execution(* jdbc.StudentHomeworkJdbc.selectAll(..))")
  private void selectAll(){}

  @Pointcut("addHomework() || addStudent() || modifyHomework() || modifyStudent()" +
    "|| submitHomework() || resubmitHomework() || selectAll()")
  private void service(){}

  @Before("service()")
  public void beginTransaction(){
    try {
      Connection connection = db.getHikariDataSource().getConnection();
      connection.setAutoCommit(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @AfterReturning("service()")
  public void commit(){
    try {
      System.out.println("committing...");
      Connection connection = db.getHikariDataSource().getConnection();
      connection.commit();
      connection.close();//将连接放回连接池
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @AfterThrowing("service()")
  public void rollback(){
    try {
      System.out.println("throwing...");
      Connection connection = db.getHikariDataSource().getConnection();
      connection.rollback();
      connection.close();//将连接放回连接池
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  @After("service()")
  public void adviceMethodInvoked() {
    System.out.println("service method invoked");
  }
}
