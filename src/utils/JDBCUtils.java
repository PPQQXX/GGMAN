package utils;
// �������ͷ���Դ
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	//���ݿ�����
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		//��������
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//��������
		String url="jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "123456";
		Connection conn=DriverManager.getConnection(url, user, password);
		return conn;
	}
	//�ر����ӣ��ͷ���Դ
	//��ѯ--�ͷ�
	public static void release(Statement stmt,Connection conn) {
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			stmt=null;
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			conn=null;
		}
	}
	//����
	public static void  release(ResultSet rs,Statement stmt,Connection conn) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			rs=null;
		}
		release(stmt, conn);//���������Ǹ�
		
	}
}
