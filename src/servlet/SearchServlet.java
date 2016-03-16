package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import person.Person;
import store.server.PersonStoreServerSocket;

public class SearchServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Set<Person> resultPersons = new HashSet<>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SearchType st = null;
		String searchType = request.getParameter("SearchType");
		String criterial = request.getParameter("Criterial");
		if(searchType.equals(SearchType.Mandatory))
		{
			st = SearchType.Mandatory;
		}
		else if(searchType.equals(SearchType.Optional))
		{
			st = SearchType.Optional;
		}
		PersonStoreServerSocket p = new PersonStoreServerSocket();
		Client c = new Client(criterial, st);
		c.start();
		resultPersons = c.getResultPersons();
		for (Person person : resultPersons)
		{
			out.println(person);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}
}
