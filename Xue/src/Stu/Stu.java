package Stu;

//ʵ���࣬��װѧ��������
/**
* @authorScatlett
*/
public class Stu {
private String no;  //ѧ��
private String name;  //����
private String phone;  //�ֻ���

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
  //�޲ι��캯��
  public Stu() {
      super();
      // TODO Auto-generated constructor stub
    }
  //�вι��캯��
  public Stu(String no, String name, String phone) {
      super();
      this.no = no;
      this.name = name;
      this.phone = phone;
   }
}
