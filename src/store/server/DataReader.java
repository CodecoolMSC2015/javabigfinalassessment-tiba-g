package store.server;

import java.util.Set;

import person.Person;
import servlet.SearchType;

public abstract class DataReader
{
	protected String searchCriteria;
	protected SearchType searchType;
	
	public abstract Set<Person> getPersons();
	public abstract void SetSearchCriterial(String searchCriteria);
	public abstract void SetSearchType(SearchType searchType);
}
