public abstract class JContent
{

	protected String title;
	protected String description;

	public JContent(String title, String description)
	{
		this.title = title;
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getTitle()
	{
		return title;
	}

	public void SetTitle(String title)
	{
		this.title = title;
	}

	public abstract String toString();

}