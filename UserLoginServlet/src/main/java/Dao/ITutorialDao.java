package Dao;

import java.sql.SQLException;
import java.util.List;

import Pojos.Tutorial;
public interface ITutorialDao 
{
	List<String> getAllTutorials(int topicId) throws SQLException;
}
