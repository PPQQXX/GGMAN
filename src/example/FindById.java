package example;

import dao.UserDao;
import domain.User;

public class FindById {
	public static void main(String[] args) {
		UserDao ud=new UserDao();
		User user=ud.findById(2);
		System.out.println("id:�����name:"+user.getUsername());//�ܵĺ���
	}
}
