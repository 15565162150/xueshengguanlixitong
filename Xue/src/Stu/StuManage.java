package Stu;

//学生信息管理系统的菜单选择
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import org.omg.CORBA.PUBLIC_MEMBER;

import studao.StuDao;

public class StuManage {
  public void  menu() {
      //1.打印菜单
      //2.输入菜单
      //3.switch菜单选择
      int choose;
      do {
          System.out.println("******************************");
          System.out.println("=======欢迎进入学生信息管理系统=======");
          System.out.println("1.新增学生");
          System.out.println("2.修改学生");
          System.out.println("3.删除学生");
          System.out.println("4.查询学生");
          System.out.println("5.退出该系统");
          System.out.println("请选择（1-5）：");
          
          Scanner scanner=new Scanner(System.in);
          choose=scanner.nextInt();
          System.out.println("******************************");
          switch (choose) {
          case 1:
              myAdd(); //菜单选择1，是新增学生
              break;
          case 2:
              myUpdate();  //菜单选择2，是修改学生
              break;
          case 3:
              myDel();  //菜单选择3，是删除学生
              break;
          case 4:
              myList();  //菜单选择4，是查询学生
              break;
          case 5:     //菜单选择5，是退出该系统
              System.out.println("您选择了退出系统，确定要退出吗？(y/n)");
              Scanner scan=new Scanner(System.in);
              String scanExit=scan.next();
              if(scanExit.equals("y")){
              System.exit(-1);
              System.out.println("您已成功退出系统，欢迎您再次使用！");
              }
              break;
          default:
              break;
          }
      } while (choose!=5);
  }
  
  //新增学生信息
  public void myAdd() {
      
      String continute;
      do {
          Scanner s=new Scanner(System.in);
          String no,name,phone;
          System.out.println("====新增学生====");
          System.out.println("学号：");
          no=s.next();
          System.out.println("姓名：");
          name=s.next();
          System.out.println("手机号：");
          phone=s.next();
          
          Stu stu=new Stu(no,name,phone);
          StuDao dao=new StuDao();
          boolean ok=dao.add(stu);
          if (ok) {
              System.out.println("保存成功！");
          }else {
              System.out.println("保存失败！");
          }
          System.out.println("是否继续添加(y/n)：");
          Scanner scanner2=new Scanner(System.in);
          continute=scanner2.next();
      } while (continute.equals("y"));
  }
  
  //删除学生信息
  public void myDel(){
      Scanner s=new Scanner(System.in);
      String no;
      System.out.println("====删除学生====");
      System.out.println("请输入要删除的学生学号：");
      no=s.next();
      System.out.println("该学生的信息如下：");
      
      StuDao stuDao=new StuDao();
      System.out.println("学生学号："+stuDao.findSomeone(no).getNo());
      System.out.println("学生姓名："+stuDao.findSomeone(no).getName());
      System.out.println("学生手机号："+stuDao.findSomeone(no).getPhone());
      
      System.out.println("是否真的删除(y/n)：");
      Scanner scanner3=new Scanner(System.in);
      String x=scanner3.next();
      if (x.equals("y")) {
          Stu stu=new Stu(no,null,null);
          StuDao dao=new StuDao();
          boolean ok=dao.del(no);
          if (ok) {
              System.out.println("删除成功！");
          }else {
              System.out.println("删除失败！");
          }
      }
  }
  //修改学生信息
  public void myUpdate(){
      Scanner s=new Scanner(System.in);
      String no;
      System.out.println("====修改学生====");
      System.out.println("请输入要修改的学生学号：");
      no=s.next();
      System.out.println("该学生的信息如下：");
      StuDao stuDao=new StuDao();
      System.out.println("学生学号："+stuDao.findSomeone(no).getNo());
      System.out.println("学生姓名："+stuDao.findSomeone(no).getName());
      System.out.println("学生手机号："+stuDao.findSomeone(no).getPhone());
      
      System.out.println("请输入新的学生信息：");
      Scanner stuUp=new Scanner(System.in);
      String name,phone;
      System.out.println("学生姓名：");
      name=stuUp.next();
      System.out.println("学生手机号：");
      phone=stuUp.next();
      Stu stu=new Stu(no,name,phone);
      StuDao dao=new StuDao();
      boolean ok=dao.update(stu);
      if (ok) {
          System.out.println("保存成功！");
      }else {
          System.out.println("保存失败！");
      }
  }
  //查询学生信息
  public void myList(){
      System.out.println("************************");
      System.out.println("====查询学生====");
      System.out.println("该学生的信息如下：");
      System.out.println("学号\t姓名\t手机号");
      StuDao stuDao=new StuDao();
      List<Stu> list=stuDao.list();
      for (Stu stuList:list) { //循环打印出查询结果
          System.out.println(stuList.getNo()+"\t"+stuList.getName()+"\t"+stuList.getPhone());
      }
      System.out.println("************************");
  }
}
