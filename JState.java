public abstract class JState
{
	protected String currentDiscussion;
	protected JValuation valuation;

	public void discuss(String text)
	{

	}

	public void evaluate(JValuation valuation)
	{

	}

	public void hold()
	{

	}

	public void release()
	{

	}

	public void decline()
	{

	}

	public String getCurrentDiscussion()
	{

	}

	public JValuation getValuation()
	{

	}

	private class Draft extends JState 
	{
		
	}

	private class OpenDraft extends JState 
	{
		
	}

	private class ApprovedIdea extends JState 
	{
		
	}

	private class ReleasedIdea extends JState 
	{
		
	}

	private class DeclinedIdea extends JState
	{
		
	}
}