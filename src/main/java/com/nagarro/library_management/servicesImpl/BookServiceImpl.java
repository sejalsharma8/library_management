package com.nagarro.library_management.servicesImpl;

import org.json.JSONArray;
import org.json.JSONObject;
import com.nagarro.library_management.model.Book;
import com.nagarro.library_management.services.BookService;
import com.nagarro.library_management.constants.Constant;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<Book>();
		URI url = null;
		try {
			url = new URI(Constant.BOOK_API);
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		HttpRequest request = HttpRequest.newBuilder().GET().uri(url).build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = response.body().toString();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < res.length() - 1; i++) {
			sb.append(res.charAt(i));
		}
		String jsonString = sb.toString();
		// JSONObject jsonObject = new JSONObject(jsonString);
		// Get an array of JSON objects from the JSON object
		JSONArray jsonArray = new JSONArray(res);
		// Loop through the JSON array and get each object
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject obj = jsonArray.getJSONObject(i);
			Book b = new Book(obj.getInt("id"), obj.getString("title"), obj.getString("author"), obj.getString("date"));
			books.add(b);
		}
		return books;
	}

	public void addBook(Book b) {
		URI url = null;
		try {
			url = new URI(Constant.BOOK_API);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpClient client = HttpClient.newHttpClient();
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(b);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpRequest request = HttpRequest.newBuilder().uri(url).header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(json)).build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateBook(Book b) {
		HttpClient client = HttpClient.newHttpClient();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(b);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = Constant.BOOK_API + "/" + b.getId();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json")
				.PUT(HttpRequest.BodyPublishers.ofString(json)).build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteBook(int id) {
		HttpClient client = HttpClient.newHttpClient();
		String url = Constant.BOOK_API + "/" + id;
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).DELETE().build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
