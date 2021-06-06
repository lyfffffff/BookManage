package dao;

import java.util.List;

import jdbcutil.JdbcUtil;
import model.User;

public class UserDao {
	
	JdbcUtil jdbc = new JdbcUtil();
	
	public User login(String username,String password){
		String sql="select * from tb_user where username=? and password=?";
		List<User> users = jdbc.queryPreparedStatement(sql, User.class,username,password);
		if(users!=null && users.size()>0){
			return users.get(0);
		}
		return null;
	}
	
}
