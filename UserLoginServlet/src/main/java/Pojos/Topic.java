package Pojos;

public class Topic 
{
	private int topicId;
	private String topicName;
	
	public Topic(int topicId, String topicName) 
	{
		super();
		this.topicId = topicId;
		this.topicName = topicName;
	}
	
	public int getTopicId() 
	{
		return topicId;
	}
	
	public void setTopicId(int topicId) 
	{
		this.topicId = topicId;
	}
	
	public String getTopicName() 
	{
		return topicName;
	}
	
	public void setTopicName(String topicName) 
	{
		this.topicName = topicName;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + "]\n";
	}
}
