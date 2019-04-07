package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutPut {
	public static void main(String[] args) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			// 1. ע�����ݿ������ ��registerDriver��ʲô��ϵ??
			//ʵ���ϴ˷�ʽ�Ǽ�������������һ������������ע�����Ρ�driverԴ���Զ�ע��һ��
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 System.out.println("�������ݿ�...");
			 
			// 2.ͨ��DriverManager��ȡ���ݿ�����
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, username, password);
			// 3.ͨ��Connection�����ȡStatement����
			 System.out.println(" ʵ����Statement����...");
			stmt = conn.createStatement();
			// 4.ʹ��Statementִ��SQL��䡣
			String sql = "select * from users";
			rs = stmt.executeQuery(sql);
			// 5. ����ResultSet�����
			System.out.println("id| name | password | email");
			while (rs.next()) { // ͨ���ֶμ���
				int id = rs.getInt("id"); // ͨ��������ȡָ���ֶε�ֵ
				String name = rs.getString("name");
				String psw = rs.getString("password");
				String email = rs.getString("email");
				System.out.println(id + " | " + name + " | " + psw + " | " + email);
			}
			//preparedstatement����    �������Ĳ��룬ע�᣿��
			/*String str="insert into users(id,name,password,email) values(?,?,?,?)";
			PreparedStatement prestmt=conn.prepareStatement(str);
			prestmt.setInt(1, 4);
			prestmt.setString(2, "lzy");
			prestmt.setString(3, "1186");
			prestmt.setObject(4, "lzy@qq.com");
			prestmt.executeUpdate();*/
			
			//����̳��ڴ˴���
			/*  // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();*/
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6.�������ݿ���Դ
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}
