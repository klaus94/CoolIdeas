import java.util.*;

public class JIdeaPool
{
	private Map<JTopic, Set<JIdea>> pool;

	public JIdeaPool()
	{
		pool = new HashMap<JTopic, HashSet<JIdea>>();
	}


	// add-methods add a JTopic or a JIdea. 
	// One JIdeaPool wont contain 2 ideas with the same title!
	public void add(JTopic topic)
	{

	}

	public boolean add(JIdea idea, JTopic topic)
	{

	}

	// remove-methods remove a topic or an idea.
	// if topic of idea does not exist, it returns false
	// keep attention on removing all JIdeas in all JTopics!!!
	public boolean remove(JTopic topic)
	{

	}

	public boolean remove(JIdea idea)
	{

	}

	// returns Idea with given title, null, if the title does not exist
	public JIdea getIdea(String title)
	{

	}

	public int numberOfTopics()
	{

	}

	public int numberOfIdeas()
	{

	}

}