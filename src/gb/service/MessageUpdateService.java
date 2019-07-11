package gb.service;

import java.sql.Connection;
import java.sql.SQLException;

import gb.dao.MessageDao;
import gb.jdbc.ConnectionProvider;
import gb.jdbc.JDBCUtil;
import gb.model.Message;

public class MessageUpdateService {
	private static MessageUpdateService service=new MessageUpdateService();
	public static MessageUpdateService getInstance() {
		return service;
	}
	
	public int update(Message msg,String newPassword) {
		Connection conn = null;
		try {
			if(!msg.getPassword().equals(newPassword)) {
				return -2;
			}
			conn = ConnectionProvider.getConnection();
			MessageDao dao = MessageDao.getInstance();
			int res=dao.update(conn,msg);
			return res;
		}finally {
			JDBCUtil.close(conn);
		}
	}
	public Message select(int MessageId) throws SQLException {
		Connection conn =null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao dao = MessageDao.getInstance();
			Message selMsg=dao.selectById(conn, MessageId);
			return selMsg;
		}finally {
			JDBCUtil.close(conn);
		}
	}
	
}
