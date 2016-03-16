package store.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import person.Employee;
import person.Person;
import person.Skill;
import servlet.SearchType;

public class CSVDataReader extends DataReader
{
	private String csvFilePath;
	
	CSVDataReader(String csvFilePath)
	{
		this.csvFilePath = csvFilePath;
	}

	@SuppressWarnings("null")
	@Override
	public Set<Person> getPersons()
	{
		BufferedReader reader = null;
		Set<Person> EmployeeSet = new HashSet<Person>();
		String[] searchCriterias = searchCriteria.split(";");
		
		try {
		    File file = new File(csvFilePath);
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    String[] lineElements;
		    
		    while ((line = reader.readLine()) != null) 
		    {	
		    	for(int i = 0; i < searchCriterias.length; i++)
		    	{
			    	lineElements = line.split(",");
			    	if(lineElements[2].equals(searchCriterias[i]))
			    	{
			    		Employee newEmploy = new Employee(lineElements[0], lineElements[1]);
			    		if(!EmployeeSet.contains(newEmploy))
			    		{
				    		List<Skill> skills = new ArrayList<Skill>();
				    		Skill skill = new Skill(lineElements[2], lineElements[3]);
				    		skills.add(skill);
				    		newEmploy.setSkillset(skills);
				    		if(lineElements[5].length() > 0)
				    			newEmploy.setSalary(Integer.valueOf(lineElements[5]));
				    		EmployeeSet.add(newEmploy);
			    		}
			    		else
			    		{
			    			Employee oldEmployee = null;
			    			for (Person e : EmployeeSet)
							{
								if(e.equals(newEmploy))
								{
									oldEmployee = (Employee) e;
								}
							}
			    			List<Skill> skills = oldEmployee.getSkillset();
				    		Skill skill = new Skill(lineElements[2], lineElements[3]);
				    		skills.add(skill);
			    		}
			    	}
		    	}
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}
		Set<Person> resultEmployees = null;
		if(searchType.equals(SearchType.Mandatory))
		{
			int number = searchCriterias.length;
			int sum = 0;
			for (Person person : EmployeeSet)
			{
				for(int i = 0; i < number; i++)
				{
					for (Skill skill : person.getSkillset())
					{
						if(skill.equals(searchCriterias[i]))
						{
							sum++;
						}
					}
				}
				if(sum == number)
				{
					resultEmployees.add(person);
					sum = 0;
				}
			}
			
			return resultEmployees;
		}
		else
		{
			resultEmployees = EmployeeSet;
			return resultEmployees;
		}
	}
	
	@Override
	public void SetSearchCriterial(String searchCriteria)
	{
		this.searchCriteria = searchCriteria;
	}

	@Override
	public void SetSearchType(SearchType searchType)
	{
		this.searchType = searchType;
	}
}
