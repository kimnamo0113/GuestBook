package gb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import gb.dao.MessageDao;
import gb.jdbc.ConnectionProvider;
import gb.jdbc.JDBCUtil;
import gb.model.Message;

public class MessageListService {

	private static MessageListService service = new MessageListService();
	
	public static MessageListService getInstance() {
		return service;
	}
	
	public List<Message> getMessageList(){
		Connection conn = null;
		
		try {
			conn=ConnectionProvider.getConnection();
			
			MessageDao dao =MessageDao.getInstance();
			return dao.selectList(conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
	}
	
	
}
