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

		// if idea already in pool, do not add it
		for (JTopic t: pool.keySet())
		{
			for (JIdea i: pool.get(t))
			{
				if ( (i != idea) && (i.getTitle().equals( idea.getTitle() )))
				{
					return;							// if idea is different to every idea in pool, but title already used --> do not add it
				}
			}
		}
		
		// add a new topic, if not already in pool
		if ( !pool.keySet().contains(topic) )
		{
			pool.put(topic, new HashSet<JIdea>());
		}


		// add idea to the pool
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
		Object[] removeArray;

		if (idea == null)
		{
			throw new NullPointerException();
		}

		for (JTopic t: pool.keySet())
		{
			// iterate through array --> so that the iterator is not in confilict to remove()
			removeArray = pool.get(t).toArray(new JIdea[0]);

			for (int i = 0; i < removeArray.length; i++)
			{
				if (removeArray[i] == idea)
				{
					pool.get(t).remove(removeArray[i]);
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
		Set<JIdea> removeIdeas = new HashSet<JIdea>();

		// at first collect all ideas, that must be removed
		for (JTopic t: pool.keySet())
		{
			for (JIdea idea: pool.get(t)) 
			{
				if (idea.isDeclined())
				{
					removeIdeas.add(idea);
				}
			}
		}

		// then delete one after the other
		for (JIdea rmIdea: removeIdeas)
		{
			rmIdea.getTitle();
			remove(rmIdea);
		}

	}

	public void removeReleased()
	{
		Set<JIdea> removeIdeas = new HashSet<JIdea>();

		// at first collect all ideas, that must be removed
		for (JTopic t: pool.keySet())
		{
			for (JIdea idea: pool.get(t)) 
			{
				if (idea.isReleased())
				{
					removeIdeas.add(idea);
				}
			}
		}

		// then delete one after the other
		for (JIdea rmIdea: removeIdeas)
		{
			remove(rmIdea);
		}
	}

}