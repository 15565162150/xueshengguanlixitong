package Stu;

//实体类，封装学生类数据
/**
* @authorScatlett
*/
public class Stu {
private String no;  //学号
private String name;  //姓名
private String phone;  //手机号

//getter setter
  public String getNo() {
      return no;
  }
  public void setNo(String no) {
      this.no = no;
  }
  public String getName() {
      return name;
  }
  public void setName(String name) {
      this.name = name;
  }
  public String getPhone() {
      return phone;
  }
  public void setPhone(String phone) {
      this.phone = phone;
  }
  //无参构造函数
  public Stu() {
      super();
      // TODO Auto-generated constructor stub
    }
  //有参构造函数
  public Stu(String no, String name, String phone) {
      super();
      this.no = no;
      this.name = name;
      this.phone = phone;
   }
}
