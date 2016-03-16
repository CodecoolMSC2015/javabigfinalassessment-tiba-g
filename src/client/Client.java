package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Set;

import person.Person;
import servlet.SearchType;

public class Client
{
	
	private String searchCriterial;
	private SearchType searchType;
	private Set<Person> resultPersons;
	
	public Client(String searchCriterial, SearchType searchType)
	{
		this.searchCriterial = searchCriterial;
		this.searchType = searchType;
	}
	
	public void start()
	{
		try {
			Socket socket = new Socket("localhost", 3333);
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(this.searchCriterial);
			oos.writeObject(this.searchType);
			
			resultPersons = (Set<Person>) ois.readObject();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<Person> getResultPersons()
	{
		return resultPersons;
	}

	public void setResultPersons(Set<Person> resultPersons)
	{
		this.resultPersons = resultPersons;
	}
	
	
}
