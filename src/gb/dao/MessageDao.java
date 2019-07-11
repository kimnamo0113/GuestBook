package gb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gb.jdbc.JDBCUtil;
import gb.model.Message;

public class MessageDao {
	private static MessageDao dao = new MessageDao();
	
	public static MessageDao getInstance() {
		return dao;
	}
	
	public List<Message> selectList(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String query = "select * from guestbook_message order by message_id desc";
			pstmt = conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			ArrayList<Message> list=new ArrayList<>();
			while(rs.next()) {
				Message ms = new Message();
				ms.setMessage_id(rs.getInt("message_id"));
				ms.setGuest_name(rs.getString("guest_name"));
				ms.setPassword(rs.getString("password"));
				ms.setMessage(rs.getString("message"));
				list.add(ms);
			}
			return list;
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	public int insert(Connection conn, Message message) throws SQLException {
		PreparedStatement pstmt = null;
		
		String query="INSERT INTO guestbook.guestbook_message\r\n" + 
				"(guest_name, password, message)\r\n" + 
				"VALUES(?, ?, ?);\r\n";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, message.getGuest_name());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			return pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	public int delete(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		String query="DELETE FROM guestbook.guestbook_message WHERE message_id=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, messageId);
			return pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	public Message selectById(Connection conn,int MessageId) throws SQLException{
		
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String query="SELECT message_id, guest_name, password, message\r\n" + 
				"FROM guestbook.guestbook_message where message_id=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, MessageId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Message ms = new Message();
				ms.setMessage_id(rs.getInt("message_id"));
				ms.setGuest_name(rs.getString("guest_name"));
				ms.setPassword(rs.getString("password"));
				ms.setMessage(rs.getString("message"));
				return ms;
			}
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return null;
	}

	public int update(Connection conn,Message msg) {
		PreparedStatement pstmt=null;
		String sql="UPDATE guestbook.guestbook_message\r\n" + 
				"SET message=?\r\n" + 
				"WHERE message_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, msg.getMessage());
			pstmt.setInt(2, msg.getMessage_id());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		
		
		return 0;
	}
}
