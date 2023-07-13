package com.nagarro.library_management.servicesImpl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.nagarro.library_management.constants.Constant;
import com.nagarro.library_management.model.Author;
import com.nagarro.library_management.services.AuthorService;

public class AuthorServiceImpl implements AuthorService{
	
	@Override
	public List<Author> getAuthors() {
		List<Author> authors = new ArrayList<Author>();
		URI url = null;
		try {
			url = new URI(Constant.AUTHOR_API);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpRequest request  = HttpRequest.newBuilder().GET().uri(url).build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> response=null;
		try {
			response = client.send(request,HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = response.body().toString();
		StringBuilder sb = new StringBuilder();
		for(int i =1;i<res.length()-1;i++) {
			sb.append(res.charAt(i));
		}
		String jsonString = sb.toString();
		//JSONObject jsonObject = new JSONObject(jsonString);	
        // Get an array of JSON objects from the JSON object
        JSONArray jsonArray = new JSONArray(res);		
        // Loop through the JSON array and get each object
	    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject obj = jsonArray.getJSONObject(i);
			        Author a = new Author(obj.getInt("id"),obj.getString("name"));
			        authors.add(a);
	   }
		return authors;
	}
}
