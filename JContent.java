public abstract class JContent
{

	protected String title;
	protected String description;

	public JContent(String title, String description)
	{
		this.title = title;
		this.description = description;
	}

	public String getDescription();

	public void setDescription(String description);

	public String getTitle();

	public void SetTitle(String title);

	public abstract toString();

}