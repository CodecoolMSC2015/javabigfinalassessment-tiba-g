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
import person.SearchType;
import person.Skill;

public class CSVDataReader extends DataReader
{
	private String csvFilePath;
	
	CSVDataReader(String csvFilePath)
	{
		this.csvFilePath = csvFilePath;
	}

	@Override
	public Set<Person> getPersons()
	{
		BufferedReader reader = null;
		Set<Person> resultEmployees = new HashSet<Person>();
		
		try {
		    File file = new File(csvFilePath);
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    String[] lineElements;
		    String[] searchCriterias = searchCriteria.split(",");
		    
		    while ((line = reader.readLine()) != null) 
		    {	
		    	for(int i = 0; i < searchCriterias.length; i++)
		    	{
			    	lineElements = line.split(",");
			    	if(lineElements[2].equals(searchCriterias[i]))
			    	{
			    		Employee newEmploy = new Employee(lineElements[0], lineElements[1]);
			    		if(!resultEmployees.contains(newEmploy))
			    		{
				    		List<Skill> skills = new ArrayList<Skill>();
				    		Skill skill = new Skill(lineElements[2], lineElements[3]);
				    		skills.add(skill);
				    		newEmploy.setSkillset(skills);
				    		newEmploy.setSalary(Integer.valueOf(lineElements[5]));
				    		resultEmployees.add(newEmploy);
			    		}
			    		else
			    		{
			    			Employee oldEmployee = null;
			    			for (Person e : resultEmployees)
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
	   
		return resultEmployees;
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
