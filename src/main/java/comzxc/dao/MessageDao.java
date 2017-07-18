package comzxc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.zxc.db.DBAccess;
import com.zxc.entity.Message;

/**
 *和message表相关的数据库操作
 */
public class MessageDao {
	

	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command, String description) {
		List<Message> messageList=new ArrayList<Message>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			//通过sqlSession执行sql语句
			messageList = sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != sqlSession) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 单条删除
	 */
	public void deleteOne(int id) {
		List<Message> messageList=new ArrayList<Message>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != sqlSession) {
				sqlSession.close();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("aaaaa");
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
		Map<String, Message> messageMap = new HashMap<String,Message>();
		messageMap.put("key",new Message());
//		Log log = LogFactory.getLog(MessageDao.class);
//		log.debug("debugadf");
//		log.info("infoadf");
//		log.warn("warnadf");
//		log.error("erroradf");
	}
	/**
	 * 根据查询条件查询消息列表
	 */
//	public List<Message> queryMessageList(String command, String description) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro-message?Unicode=true&characterEncoding=utf-8", "root", "mysql");
//			StringBuilder sql= new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
//			List<String> paramList = new ArrayList<String>();
//			if(null != command &&!"".equals(command.trim())) {
//				sql.append(" and COMMAND=?");
//				paramList.add(command);
//			}
//			if(null != description &&!"".equals(description.trim())) {
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paramList.add(description);
//			}
//			PreparedStatement statement = conn.prepareStatement(sql.toString());
//			for(int i  =0; i<paramList.size(); i++) {
//				statement.setString(i+1, paramList.get(i));
//			}
//			ResultSet rs = statement.executeQuery();
//			while(rs.next()) {
//				Message message = new Message();
//				messageList.add(message);
//				message.setId(rs.getInt("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return messageList;
//	}
}
