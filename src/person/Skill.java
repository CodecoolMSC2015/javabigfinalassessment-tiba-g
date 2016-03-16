package person;

import java.io.Serializable;

public class Skill implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3059337550806103341L;
	private String name;
	private String description;
	private double rate;
	
	public Skill(String name, String description)
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
