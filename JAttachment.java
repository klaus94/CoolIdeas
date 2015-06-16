import java.io.File;

public class JAttachment extends JContent
{
	private File file;

	public JAttachment(String title, String description, File file)
	{
		super(title, description);
		this.file = file;
	}

	public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public String toString()
	{
		return "Attachment: " + title + "\n" + description;
	}

}