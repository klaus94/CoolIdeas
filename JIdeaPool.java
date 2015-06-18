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
		if (topic == null)
		{
			throw new NullPointerException();
		}

		if ( !pool.keySet().contains(topic) )
		{
			pool.put(topic, new HashSet<JIdea>());
		}
		
	}


	public void add(JIdea idea, JTopic topic)
	{
		if (topic == null || idea == null)
		{
			throw new NullPointerException();
		}

		/*for (JTopic t: pool.keySet())
		{
			for (JIdea i: pool.get(t))
			{
				if (i.getTitle().equals( idea.getTitle() ))
				{
					return;				// if title of idea already exists, do not add it to the IdeaPool
				}
			}
		}*/


		// if idea already in topic, do not add it
		if (pool.containsKey(topic))
		{
			for (JIdea i: pool.get(topic))
			{
				if (i.getTitle().equals( idea.getTitle() ))
				{
					return;
				}
			}
		}
		else
		{
			// add topic, if not already in pool
			pool.put(topic, new HashSet<JIdea>());
		}


		// even, if idea already is in an other topic, add it to this one
		pool.get(topic).add(idea);

	}


	// remove-methods remove a topic or an idea.
	// if topic of idea does not exist, it returns false
	public boolean remove(JTopic topic)
	{
		if (topic == null)
		{
			throw new NullPointerException();
		}

		if ( !pool.keySet().contains(topic) )
		{
			return false;
		}

		pool.remove(topic);
		return true;
	}


	// keep attention on removing all JIdeas in all JTopics!!!
	public boolean remove(JIdea idea)
	{
		boolean removeSuccess = false;

		if (idea == null)
		{
			throw new NullPointerException();
		}

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
		if (title == null)
		{
			throw new NullPointerException();
		}

		if (title.equals(""))
		{
			throw new IllegalArgumentException();
		}

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
		/*int ideasCount = 0;

		for (JTopic t: pool.keySet())
		{
			ideasCount += pool.get(t).size();
		}*/

		Set<String> individualIdeas = new HashSet<String>();
		for (JTopic t: pool.keySet())
		{
			for (JIdea i: pool.get(t))
			{
				individualIdeas.add(i.getTitle());
			}
		}

		return individualIdeas.size();
	}

	public void removeDeclined()
	{
		for (JTopic t: pool.keySet())
		{
			for (JIdea i: pool.get(t))
			{
				if (i.isDeclined())
				{
					pool.get(t).remove(i);
				}
			}
		}
	}

	public void removeReleased()
	{
		for (JTopic t: pool.keySet())
		{
			for (JIdea i: pool.get(t))
			{
				if (i.isReleased())
				{
					pool.get(t).remove(i);
				}
			}
		}
	}

}