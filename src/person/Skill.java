package person;

public class Skill
{
	public String name;
	public String description;
	public double rate;
	
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
