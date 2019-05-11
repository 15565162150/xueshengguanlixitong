package Stu;

//ѧ����Ϣ����ϵͳ�Ĳ˵�ѡ��
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import org.omg.CORBA.PUBLIC_MEMBER;

import studao.StuDao;

public class StuManage {
  public void  menu() {
      //1.��ӡ�˵�
      //2.����˵�
      //3.switch�˵�ѡ��
      int choose;
      do {
          System.out.println("******************************");
          System.out.println("=======��ӭ����ѧ����Ϣ����ϵͳ=======");
          System.out.println("1.����ѧ��");
          System.out.println("2.�޸�ѧ��");
          System.out.println("3.ɾ��ѧ��");
          System.out.println("4.��ѯѧ��");
          System.out.println("5.�˳���ϵͳ");
          System.out.println("��ѡ��1-5����");
          
          Scanner scanner=new Scanner(System.in);
          choose=scanner.nextInt();
          System.out.println("******************************");
          switch (choose) {
          case 1:
              myAdd(); //�˵�ѡ��1��������ѧ��
              break;
          case 2:
              myUpdate();  //�˵�ѡ��2�����޸�ѧ��
              break;
          case 3:
              myDel();  //�˵�ѡ��3����ɾ��ѧ��
              break;
          case 4:
              myList();  //�˵�ѡ��4���ǲ�ѯѧ��
              break;
          case 5:     //�˵�ѡ��5�����˳���ϵͳ
              System.out.println("��ѡ�����˳�ϵͳ��ȷ��Ҫ�˳���(y/n)");
              Scanner scan=new Scanner(System.in);
              String scanExit=scan.next();
              if(scanExit.equals("y")){
              System.exit(-1);
              System.out.println("���ѳɹ��˳�ϵͳ����ӭ���ٴ�ʹ�ã�");
              }
              break;
          default:
              break;
          }
      } while (choose!=5);
  }
  
  //����ѧ����Ϣ
  public void myAdd() {
      
      String continute;
      do {
          Scanner s=new Scanner(System.in);
          String no,name,phone;
          System.out.println("====����ѧ��====");
          System.out.println("ѧ�ţ�");
          no=s.next();
          System.out.println("������");
          name=s.next();
          System.out.println("�ֻ��ţ�");
          phone=s.next();
          
          Stu stu=new Stu(no,name,phone);
          StuDao dao=new StuDao();
          boolean ok=dao.add(stu);
          if (ok) {
              System.out.println("����ɹ���");
          }else {
              System.out.println("����ʧ�ܣ�");
          }
          System.out.println("�Ƿ�������(y/n)��");
          Scanner scanner2=new Scanner(System.in);
          continute=scanner2.next();
      } while (continute.equals("y"));
  }
  
  //ɾ��ѧ����Ϣ
  public void myDel(){
      Scanner s=new Scanner(System.in);
      String no;
      System.out.println("====ɾ��ѧ��====");
      System.out.println("������Ҫɾ����ѧ��ѧ�ţ�");
      no=s.next();
      System.out.println("��ѧ������Ϣ���£�");
      
      StuDao stuDao=new StuDao();
      System.out.println("ѧ��ѧ�ţ�"+stuDao.findSomeone(no).getNo());
      System.out.println("ѧ��������"+stuDao.findSomeone(no).getName());
      System.out.println("ѧ���ֻ��ţ�"+stuDao.findSomeone(no).getPhone());
      
      System.out.println("�Ƿ����ɾ��(y/n)��");
      Scanner scanner3=new Scanner(System.in);
      String x=scanner3.next();
      if (x.equals("y")) {
          Stu stu=new Stu(no,null,null);
          StuDao dao=new StuDao();
          boolean ok=dao.del(no);
          if (ok) {
              System.out.println("ɾ���ɹ���");
          }else {
              System.out.println("ɾ��ʧ�ܣ�");
          }
      }
  }
  //�޸�ѧ����Ϣ
  public void myUpdate(){
      Scanner s=new Scanner(System.in);
      String no;
      System.out.println("====�޸�ѧ��====");
      System.out.println("������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
      no=s.next();
      System.out.println("��ѧ������Ϣ���£�");
      StuDao stuDao=new StuDao();
      System.out.println("ѧ��ѧ�ţ�"+stuDao.findSomeone(no).getNo());
      System.out.println("ѧ��������"+stuDao.findSomeone(no).getName());
      System.out.println("ѧ���ֻ��ţ�"+stuDao.findSomeone(no).getPhone());
      
      System.out.println("�������µ�ѧ����Ϣ��");
      Scanner stuUp=new Scanner(System.in);
      String name,phone;
      System.out.println("ѧ��������");
      name=stuUp.next();
      System.out.println("ѧ���ֻ��ţ�");
      phone=stuUp.next();
      Stu stu=new Stu(no,name,phone);
      StuDao dao=new StuDao();
      boolean ok=dao.update(stu);
      if (ok) {
          System.out.println("����ɹ���");
      }else {
          System.out.println("����ʧ�ܣ�");
      }
  }
  //��ѯѧ����Ϣ
  public void myList(){
      System.out.println("************************");
      System.out.println("====��ѯѧ��====");
      System.out.println("��ѧ������Ϣ���£�");
      System.out.println("ѧ��\t����\t�ֻ���");
      StuDao stuDao=new StuDao();
      List<Stu> list=stuDao.list();
      for (Stu stuList:list) { //ѭ����ӡ����ѯ���
          System.out.println(stuList.getNo()+"\t"+stuList.getName()+"\t"+stuList.getPhone());
      }
      System.out.println("************************");
  }
}
