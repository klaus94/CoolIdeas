import java.util.*;

public class JIdea extends JContent
{

	private List<JAttachment> attachments;
	private JState state;

	public JIdea (String title, String description) 
	{
		super(title, description);
		attachments = new ArrayList<JAttachment>();
		state = new Draft();
	}

	public void discuss(String text)
	{
		state.discuss(text);
	}

	public void evaluate(JValuation valuation)
	{
		state.evaluate(valuation);
	}

	public void hold()
	{
		state.hold();
	}

	public void release()
	{
		state.release();
	}

	public void decline()
	{
		state.decline();
	}

	public boolean isDeclined()
	{
		return (state instanceof DeclinedIdea);
	}

	public boolean isReleased()
	{
		return (state instanceof ReleasedIdea);
	}

	public String getCurrentDiscussion()
	{
		return state.getCurrentDiscussion();
	}

	public JValuation getValuation()
	{
		return state.getValuation();
	}

	public void addAttachment(JAttachment attachment)
	{
		attachments.add(attachment);
	}

	public List<JAttachment> getAttachments()
	{
		return attachments;
	}

	public boolean removeAttachment(JAttachment attachment)
	{
		return attachments.remove(attachment);
	}

	public String toString()
	{
		return ("Idea: " + title + "\n"
			+ description);
	}


	private abstract class JState
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

	}

	public class Draft extends JState 
	{
		public void hold()
		{
			this = new OpenDraft();
		}

		public void decline()
		{
			this.new DeclinedIdea();
		}
	}

	public  class OpenDraft extends JState 
	{
		public void hold()
		{
			this.new ApprovedIdea();
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
			this.new DeclinedIdea();
		}
	}

	public class ApprovedIdea extends JState 
	{
		public void release()
		{
			this.new ReleasedIdea();
		}
	}

	public class ReleasedIdea extends JState 
	{
		
	}

	public class DeclinedIdea extends JState
	{
	
	}


}