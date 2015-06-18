import java.util.Observable;

public abstract class JContent extends Observable
{

	protected String title;
	protected String description;

	public JContent(String title, String description)
	{
		if (description == null || title == null)
		{
			throw new NullPointerException();
		}

		if (description.equals("") || title.equals(""))
		{
			throw new IllegalArgumentException();
		}

		this.title = title;
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		if (description == null)
		{
			throw new NullPointerException();
		}

		if (description.equals(""))
		{
			throw new IllegalArgumentException();
		}

		if (description.equals(""))
		{
			throw new IllegalArgumentException();
		}

		this.description = description;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		if (title == null)
		{
			throw new NullPointerException();
		}

		if (title.equals(""))
		{
			throw new IllegalArgumentException();
		}

		this.title = title;
	}

	public abstract String toString();

}