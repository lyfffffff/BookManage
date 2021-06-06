package dao;

import java.util.ArrayList;
import java.util.List;

import jdbcutil.JdbcUtil;
import model.Book;

public class BookDao {
	JdbcUtil jdbc = new JdbcUtil();
	
	public void insertBook(Book book){
		String sql = "insert into tb_book values(null,?,?,?,?,?,?,?)";
		jdbc.updatePreparedStatement(sql, book.getBname(),book.getAuthor(),book.getSex(),book.getPublish(),
				book.getPrice(),book.getType(),book.getBdes());
	}
	
	public List<Book> queryBook(String bname,String author){
		StringBuffer sb = new StringBuffer("select t1.bid,t1.bname,t1.author,t1.sex,t1.publish,t1.price,t1.bdes,t2.tname "
				+ " from tb_book t1,tb_type t2 where t1.type=t2.id ");
		List<Object> params = new ArrayList<Object>();
		if(bname!=null && !bname.equals("")){
			sb.append(" and t1.bname=?");
			params.add(bname);
		}
		if(author!=null && !author.equals("")){
			sb.append(" and t1.author=?");
			params.add(author);
		}
		List<Book> books = jdbc.queryPreparedStatement(sb.toString(), Book.class, params);
		return books;
	}
	
	public void deleteBook(String bid){
		String sql="delete from tb_book where bid=?";
		jdbc.updatePreparedStatement(sql, bid);
	}
	
	public void updateBook(Book book){
		String sql="update tb_book set bname=?,author=?,sex=?,publish=?,price=?,type=?,bdes=? where bid=?";
		
		jdbc.updatePreparedStatement(sql, book.getBname(),book.getAuthor(),book.getSex(),book.getPublish(),
				book.getPrice(),book.getType(),book.getBdes(),book.getBid());
	}
	
}
