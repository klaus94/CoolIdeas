import java.util.*;

public class JIdea extends JContent
{

	private List<JAttachment> attachments;
	private JState state;

	public JIdea (String title, String description) 
	{
		super(title, description);
		attachments = new ArrayList<JAttachment>();
		state = state.new Draft();
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
		return (state instanceof JState.DeclinedIdea);
	}

	public boolean isReleased()
	{
		return (state instanceof JState.ReleasedIdea);
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

}