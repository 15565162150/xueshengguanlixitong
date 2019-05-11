package studao;

import java.sql.Connection;

//ѧ���������ݷ��ʶ���StuDao
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Stu.DBUtil;
import Stu.Stu;

public class StuDao {
  private Connection con;
  private PreparedStatement pstmt;
  private ResultSet rs;
  
  //����ѧ����Ϣ
public boolean add(Stu stu) {
     String sql="insert into stu(stu_no,stu_name,phone) values(?,?,?)";
  try {
      con=DBUtil.getCon();
      pstmt=con.prepareStatement(sql);
      pstmt.setString(1, stu.getNo());
      pstmt.setString(2, stu.getName());
      pstmt.setString(3, stu.getPhone());
      pstmt.executeUpdate();
  } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return false;
  } catch (SQLException e) {
      e.printStackTrace();
      return false;
  } finally{
      DBUtil.close(con, pstmt, rs);
  }
  return true;
}

//�鿴ѧ���б���1���У�
public List<Stu> list() {
     List<Stu> list=new ArrayList<Stu>();//�������б���ArrayList��
  
     String sql="select * from stu";
  
  try {
      con=DBUtil.getCon();
      pstmt=con.prepareStatement(sql);
//pstmt.executeUpdate();//������ɾ��
      rs=pstmt.executeQuery();//���ڲ�ѯ
      while (rs.next()) {
          
//Stustu=new Stu(rs.getString("stu_no"),rs.getString("stu_name"),rs.getString("phone"));
          //����д�����Ϊ��
          Stu stu=new Stu();
          stu.setNo(rs.getString("stu_no"));//ȡ���������ѧ����һ�е�ֵ����
          stu.setName(rs.getString("stu_name"));
          stu.setPhone(rs.getString("phone"));
          
          list.add(stu);
      }
  } catch (ClassNotFoundException e) {
      e.printStackTrace();
  } catch (SQLException e) {
      e.printStackTrace();
  } finally{
      DBUtil.close(con, pstmt, rs);
  }
  return list;
}
//�鿴ѧ���б���2����ѧ��ѧ����ʾѧ����Ϣ��
  public Stu findSomeone(String no) {
         Stu stu=null;
         String sql="select * from stu where stu_no=?";
      
      try {
          con=DBUtil.getCon();
          pstmt=con.prepareStatement(sql);
//pstmt.executeUpdate();//������ɾ��
          pstmt.setString(1,no);
          rs=pstmt.executeQuery();//���ڲ�ѯ
          while (rs.next()) {
              
//Stustu=new Stu(rs.getString("stu_no"),rs.getString("stu_name"),rs.getString("phone"));
              //����д�����Ϊ��
              stu=new Stu();
              stu.setNo(rs.getString("stu_no"));//ȡ���������ѧ����һ�е�ֵ����
              stu.setName(rs.getString("stu_name"));
              stu.setPhone(rs.getString("phone"));
          }
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (SQLException e) {
          e.printStackTrace();
      } finally{
          DBUtil.close(con, pstmt, rs);
      }
      return stu;
  }
//�޸�ѧ����Ϣ
public boolean update(Stu stu) {
     String sql="update stu set stu_name=?,phone=? wherestu_no=?";
  try {
      con=DBUtil.getCon();
      pstmt=con.prepareStatement(sql);
      pstmt.setString(3, stu.getNo());
      pstmt.setString(1, stu.getName());
      pstmt.setString(2, stu.getPhone());
      pstmt.executeUpdate();
  } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return false;
  } catch (SQLException e) {
      e.printStackTrace();
      return false;
  } finally{
      DBUtil.close(con, pstmt, rs);
  }
  return true;
 }

//ɾ��ѧ����Ϣ
public boolean del(String id) {
     String sql="delete from stu where stu_no=?";
  try {
      con=DBUtil.getCon();
      pstmt=con.prepareStatement(sql);
      pstmt.setString(1,id);
      
      pstmt.executeUpdate();
  } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return false;
  } catch (SQLException e) {
      e.printStackTrace();
      return false;
  } finally{
      DBUtil.close(con, pstmt, rs);
  }
  return true;
 }
}