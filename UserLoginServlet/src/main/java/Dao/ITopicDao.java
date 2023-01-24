package Dao;

import java.sql.SQLException;
import java.util.List;

import Pojos.Topic;

public interface ITopicDao 
{
	List<Topic> getAllTopics() throws SQLException;
}
