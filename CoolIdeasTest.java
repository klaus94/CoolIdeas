public class CoolIdeasTest
{

	public static void main(String[] args)
	{
		JIdeaPool myPool = new JIdeaPool();
		JTopic t1 = new JTopic("t1", "es geht um die Weltherrschaft", 1);
		JTopic t2 = new JTopic("t2", "es geht um Strom aus Hamsterrädern", 2);
		
		JIdea i1 = new JIdea("i1", "das wird nur was mit keksen");
		JIdea i2 = new JIdea("i2", "ganz viel Schokolade essen.");
		JIdea i3 = new JIdea("i3", "...");


		myPool.add(i1, t1);		
		myPool.add(i2, t1);
		myPool.add(i1, t2);
		myPool.add(i3, t2);
		// T1 [i1("i1"), i2("i2")]
		// T2 [i1("i1"), i3("i3")]


		i1.decline();
		i2.decline();
		i3.decline();
		myPool.removeDeclined();

		/*JMember m = new JMember();
		m.subscribe(t1);
		t1.setTitle("t1.1");		// --> Topic changed --> notify --> Member.update


		/*JIdea i = new JIdea("title", "description");
		i.hold();		// --> openDraft
		i.discuss("test");
		System.out.println("discussion: " + i.getCurrentDiscussion());
		i.discuss("test2");
		System.out.println("discussion: " + i.getCurrentDiscussion());

		//i1.decline();
		/*i1.decline();
		
		myPool.removeDeclined();

		if (myPool.getIdea(i1.getTitle()) == null)
		{
			System.out.println("success! deleted i1");
		}

		i2.decline();
		i3.decline();
		myPool.removeDeclined();
		if (myPool.getIdea(i3.getTitle()) == null && myPool.getIdea(i2.getTitle()) == null)
		{
			System.out.println("success! deleted i2, i3");
		}*/
	}

}