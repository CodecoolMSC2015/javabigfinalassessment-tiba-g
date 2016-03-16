package store.server;

import java.util.List;
import java.util.Set;

import person.Person;
import person.SearchType;

public class CSVDataReader extends DataReader
{
	private String csvFilePath;
	private List<Person> personList; 
	
	@Override
	public Set<Person> getPerson(String searchCriterial, SearchType searchType)
	{
		// TODO Auto-generated method stub
		return null;
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
