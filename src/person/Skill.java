package person;

public class Skill
{
	private String name;
	private String description;
	private double rate;
	
	Skill(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public double getRate()
	{
		return rate;
	}
}
