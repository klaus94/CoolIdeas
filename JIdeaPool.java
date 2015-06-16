import java.util.*;

public class JIdeaPool
{
	private Map<JTopic, Set<JIdea>> pool;


	public JIdeaPool()
	{
		pool = new HashMap<JTopic, Set<JIdea>>();
	}


	// add-methods add a JTopic or a JIdea. 
	// One JIdeaPool wont contain 2 ideas with the same title!
	public void add(JTopic topic)
	{
		pool.put(topic, new HashSet<JIdea>());
	}


	public boolean add(JIdea idea, JTopic topic)
	{
		for (JTopic t: pool.keySet())
		{
			for (JIdea i: pool.get(t))
			{
				if (i.getTitle().equals( idea.getTitle() ))
				{
					return false;				// if title of idea already exists, do not add it to the IdeaPool
				}
			}
		}

		if (!pool.containsKey(topic))			// add topic, if not already in pool
		{
			pool.put(topic, new HashSet<JIdea>());
		}

		pool.get(topic).add(idea);				// add idea to the pool

		return true;
	}


	// remove-methods remove a topic or an idea.
	// if topic of idea does not exist, it returns false
	public boolean remove(JTopic topic)
	{
		pool.remove(topic);
		return true;
	}


	// keep attention on removing all JIdeas in all JTopics!!!
	public boolean remove(JIdea idea)
	{
		boolean removeSuccess = false;

		for (JTopic t: pool.keySet())			// remove idea in all topics
		{
			for (JIdea i: pool.get(t))
			{
				if (i == idea)					// == or equals() ???
				{
					pool.get(t).remove(i);		// remove idea from the set
					removeSuccess = true;
				}
			}
		}

		return removeSuccess;
	}


	// returns Idea with given title, null, if the title does not exist
	public JIdea getIdea(String title)
	{
		for (JTopic t: pool.keySet())
		{
			for (JIdea i: pool.get(t))
			{
				if (i.getTitle().equals(title))
				{
					return i;
				}
			}
		}

		return null;
	}


	public int numberOfTopics()
	{
		return pool.keySet().size();
	}


	public int numberOfIdeas()
	{
		int ideasCount = 0;

		for (JTopic t: pool.keySet())
		{
			ideasCount += pool.get(t).size();
		}

		return ideasCount;
	}

}