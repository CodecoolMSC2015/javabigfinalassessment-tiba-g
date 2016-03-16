package person;

public class Employee extends Person
{
	private int salary;
	private String jobTitle;
	
	public Employee(String name, String email)
	{
		super(name, email);
	}
	
	public int getSalary()
	{
		return salary;
	}
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	public String getJobTitle()
	{
		return jobTitle;
	}
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + name + " email:" + email;
	}
	
	@Override
	public int hashCode()
	{
		return -1;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Employee e = (Employee) obj;
		return e.name.equals(e.getName());
	}
}
