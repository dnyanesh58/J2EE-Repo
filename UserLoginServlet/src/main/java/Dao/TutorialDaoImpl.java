package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static Utils.DBUtils.*;
import Pojos.Tutorial;

public class TutorialDaoImpl implements ITutorialDao
{
	
	private Connection cn;
	private PreparedStatement pst;
	
	public TutorialDaoImpl() throws SQLException
	{
		cn = getConnect();
		pst = cn.prepareStatement("select name from tutorials where topic_id=? order by visits desc");
	}
	
	@Override
	public List<String> getAllTutorials(int topicId) throws SQLException 
	{
		pst.setInt(1, topicId);
		List<String> tutNames = new ArrayList<>();
		try(ResultSet rst = pst.executeQuery())
		{
			if (rst.next()) 
			{
				tutNames.add(rst.getString(1)); 
			}
		}
		return tutNames;
	}
	
	public void cleanUp() throws SQLException
	{
		if (pst != null) 
		{
			pst.close();
		}
	}
}
