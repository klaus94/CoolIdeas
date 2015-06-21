public class JTopic extends JContent
{
	private int id;

	public JTopic(String title, String description, int id)
	{
		super(title, description);
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public String toString()
	{
		return "Topic: " + title + "\n" + description;
	}

	// overwrite inherited methods:
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

		this.description = description;
		setChanged();
		notifyObservers(description);
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
		setChanged();
		notifyObservers(title);
	}

}