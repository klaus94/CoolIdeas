public class JValuation extends JContent
{
	public JValuation(String title, String description)
	{
		super(title, description);
	}

	public String toString()
	{
		return "Valuation: " + title + "\n" + description;
	}

}