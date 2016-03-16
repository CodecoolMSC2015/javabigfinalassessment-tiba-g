package person;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7558914342706599481L;
	protected String name;
	protected String email;
	protected List<Skill> skillset;	
	
	Person()
	{
		
	}
	
	Person(String name, String email)
	{
		this.name = name;
		this.email = email;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<Skill> getSkillset()
	{
		return skillset;
	}

	public void setSkillset(List<Skill> skillset)
	{
		this.skillset = skillset;
	}
	
	public void addSkill(Skill skill)
	{
		skillset.add(skill);
	}
}
