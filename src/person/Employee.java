package person;

public class Employee extends Person
{
	public int salary;
	public String jobTitle;
	
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
		// TODO Auto-generated method stub
		return super.toString();
	}
}
