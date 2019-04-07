package dao;
//�����װ   ��user�����ӣ�ɾ�������ң�����

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.taglibs.standard.lang.jstl.ValueSuffix;

import domain.User;
import utils.JDBCUtils;

public class UserDao {
	// ��������users����Ϣ
	public void AllUsers() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//����
			conn=JDBCUtils.getConnection();
			//���statement����
			stmt=conn.createStatement();
			//sql���
			String sql="select *from users";
			//�����ڽ������
			rs=stmt.executeQuery(sql);
			//��������������
			System.out.println("id+|+name+|+password+|+email");
			while (rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String email=rs.getString("email");
				System.out.println(id+"|"+name+"|"+password+"|"+email);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	
	//����û�
	public boolean insert(User user){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			 String sql = "INSERT INTO users(id,name,password,email) "+
						"VALUES("
						+ user.getId()
						+ ",'"
						+ user.getUsername()
						+ "','"
						+ user.getPassword()
						+ "','"
						+ user.getEmail()
						+  "')";
				int num = stmt.executeUpdate(sql);
			if(num>0)
			{
	
				return true;
			}
			else {
			
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		finally
		{
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	//����id 
	public User findById(int id) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql="select *from users where id="+id;
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				User user=new User();//��user�������rs�е�����
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	//����ָ��id
	public boolean update(User user) {
		 Connection conn=null;
		 Statement stmt=null;
		 ResultSet rs=null;
		 try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql = "UPDATE users set name='" + user.getUsername()
			+ "',password='" + user.getPassword() + "',email='"
			+ user.getEmail() + "' WHERE id=" + user.getId();
	int num = stmt.executeUpdate(sql);
			if(num>0)
			{
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;		
	}
}
