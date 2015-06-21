import java.util.*;

public class JMember implements Observer
{
	private Set<JTopic> topics;

	public JMember()
	{
		topics = new HashSet<JTopic>();
	}

	public void subscribe(JTopic topic)
	{
		if (topic == null)
		{
			throw new NullPointerException();
		}

		topics.add(topic);
		topic.addObserver( this );
	}

	public void unsubscribe(JTopic topic)
	{
		if (topic == null)
		{
			throw new NullPointerException();
		}

		topics.remove(topic);
		topic.deleteObserver( this );
	}

	public Set<JTopic> getSubscribedTopics()
	{
		return topics;
	}

	public void update(Observable arg0, Object arg1)
	{
		System.out.println("The topic " + ((JTopic)arg0).getId() + " has been updated!");
	}


}