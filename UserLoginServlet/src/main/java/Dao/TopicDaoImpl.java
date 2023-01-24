package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static Utils.DBUtils.*;
import Pojos.Topic;

public class TopicDaoImpl implements ITopicDao
{
	
	private	Connection cn;
	private PreparedStatement pst;
	
	public TopicDaoImpl() throws SQLException
	{
		cn = getConnect();
		pst = cn.prepareStatement("select * from topics");
		System.out.println("In TopicDaoImpl ");
	}
	
	@Override
	public List<Topic> getAllTopics() throws SQLException 
	{
		List<Topic> topics = new ArrayList<Topic>();
		try(ResultSet rst = pst.executeQuery();)
		{
			while (rst.next()) 
			{
				topics.add(new Topic(rst.getInt(1),rst.getString(2)));
			}
		}
		return topics;
	}
	
	public void cleanUp() throws SQLException
	{
		if (pst != null) {
			pst.close();
		}
	}
	
}
