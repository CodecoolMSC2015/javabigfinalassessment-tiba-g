package store.server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

import person.Person;
import servlet.SearchType;

public class PersonStoreServerSocket
{
	private DataReader store;
		
	public void start(int port)
	{
		ServerSocket ss = null;
		try 
		{
			ss = new ServerSocket(port);
			Socket s = ss.accept();

			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();

			ObjectInputStream ois = new ObjectInputStream(is);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			boolean haveSearchCriterial = false;
			boolean haveSearchType = false;
			String errorMessage;
			store = new CSVDataReader("Documentation\\persons.csv");
			
			while (true) 
			{
				int i;
				if ((i = ois.read()) > -1)
				{
					if (i == 1) 
					{
						break;
					}
					Object obj = ois.readObject();

					if (obj instanceof String) 
					{
						try {
							store.SetSearchCriterial((String) obj);
							haveSearchCriterial = true;
							System.out.println("SearchCriterial OK");
						} catch (Exception e) {
							errorMessage = "Wrong search criterial!";
							oos.writeObject(errorMessage);
							haveSearchCriterial = false;
						}
					}
					if (obj instanceof SearchType)
					{
						try {
							store.SetSearchType((SearchType) obj);
							haveSearchType = true;
							System.out.println("SearchType OK");
						} catch (Exception e) {
							
							errorMessage = "Wrong search type!";
							oos.writeObject(errorMessage);
							haveSearchType = false;
						}
					}
					if (haveSearchCriterial && haveSearchType)
					{
						Set<Person> resultSet = store.getPersons();
						oos.writeObject(resultSet);
					}
				}
			}
			oos.close();
			os.close();
			s.close();
			ois.close();
			is.close();
			ss.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}