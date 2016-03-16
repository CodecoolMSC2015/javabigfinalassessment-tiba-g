package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Set;

import servlet.SearchType;

public class Client
{
	
	private String searchCriterial;
	private SearchType searchType;
	
	Client()
	{
		try {
			Socket socket = new Socket("localhost", 3333);
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(searchCriterial);
			oos.writeObject(searchType);
			
			
			while(ois.read() > -1)
			{
				Object o;
				try
				{
					o = ois.readObject();
					if(o instanceof Set<?>)
					{
						//return to servlet
					}
				} 
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				
			}
			oos.write(1);
			oos.close();
			ois.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
