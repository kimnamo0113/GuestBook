package gb.service;

import java.sql.Connection;

import gb.dao.MessageDao;
import gb.jdbc.ConnectionProvider;
import gb.jdbc.JDBCUtil;
import gb.model.Message;

public class MessageDeleteService {
private static MessageDeleteService service=new MessageDeleteService();
	
	public static MessageDeleteService getInstance() {
		return service;
	}
	
	//-2 : 비밀번호 일치하지 않는 경우
	public int deleteMessage(int messageId, String password){
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao dao = MessageDao.getInstance();
			Message selMsg = dao.selectById(conn, messageId);
			if(!selMsg.getPassword().equals(password)) {
				return -2;
			}else{
				return dao.delete(conn, messageId);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return -1;
	}
	
}
