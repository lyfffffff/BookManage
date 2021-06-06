package dao;

import java.util.ArrayList;
import java.util.List;

import jdbcutil.JdbcUtil;
import model.BookType;

public class BookTypeDao {
	JdbcUtil jdbc = new JdbcUtil();
	
	public List<BookType> queryBookType(String tname){
		String sql = "select * from tb_type where 1=1 ";
		ArrayList<Object> params = new ArrayList<Object>();
		if(tname!=null && !tname.equals("")){
			sql += "and tname=?";
			params.add(tname);
		}
		List<BookType> list = jdbc.queryPreparedStatement(sql, BookType.class, params);
		return list;
	} 
	
	public void insertBooktype(String tname,String tdes){
		String sql = "insert into tb_type values(null,?,?)";
		jdbc.updatePreparedStatement(sql, tname,tdes);
	}
	
	public void updateBookType(String id,String tname,String tdes){
		String sql="update tb_type set tname=?,tdes=? where id=?";
		jdbc.updatePreparedStatement(sql, tname,tdes,Integer.parseInt(id));
	}
	
	public void deleteBookType(String id){
		String sql="delete from  tb_type where id=?";
		jdbc.updatePreparedStatement(sql,Integer.parseInt(id));
	}
}
