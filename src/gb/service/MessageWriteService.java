package gb.service;

import java.sql.Connection;

import gb.dao.MessageDao;
import gb.jdbc.ConnectionProvider;
import gb.jdbc.JDBCUtil;
import gb.model.Message;

public class MessageWriteService {
	private static MessageWriteService service=new MessageWriteService();
	
	public static MessageWriteService getInstance() {
		return service;
	}
	
	public int write(Message message){
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao dao = MessageDao.getInstance();
			return dao.insert(conn, message);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return -1;
	}
}
