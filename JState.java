
public abstract class JState
{
	protected String currentDiscussion;
	protected JValuation valuation;

	public void discuss(String text)
	{
		throw new IllegalStateException();
	}

	public void evaluate(JValuation valuation)
	{
		throw new IllegalStateException();
	}

	public void hold()
	{
		throw new IllegalStateException();
	}

	public void release()
	{
		throw new IllegalStateException();
	}

	public void decline()
	{
		throw new IllegalStateException();
	}

	public String getCurrentDiscussion()
	{
		return currentDiscussion;
	}

	public JValuation getValuation()
	{
		return valuation;
	}

	public class Draft extends JState 
	{
		public void hold()
		{
			(JState) this = new OpenDraft();
		}

		public void decline()
		{
			(JState) this = new DeclinedIdea();
		}
	}

	public class OpenDraft extends JState 
	{
		public void hold()
		{
			(JState) this = new ApprovedIdea();
		}

		public void evaluate(JValuation valuation)
		{
			this.valuation = valuation;
		}

		public void discuss(String text)
		{
			if (currentDiscussion.equals("")) {
				currentDiscussion = text;
			} else {
				currentDiscussion = (currentDiscussion + "\n" + text);
			}
		}

		public void decline()
		{
			(JState) this = new DeclinedIdea();
		}
	}

	public class ApprovedIdea extends JState 
	{
		public void release()
		{
			(JState) this = new ReleasedIdea();
		}
	}

	public class ReleasedIdea extends JState 
	{
		
	}

	public class DeclinedIdea extends JState
	{
		
	}
}