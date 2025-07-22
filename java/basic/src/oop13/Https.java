package oop13;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Https {
	public static void main(String[] args) throws IOException, InterruptedException {
		String apiUrl = "https://jsonplaceholder.typicode.com/posts";

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("상태 코드: " + response.statusCode());
		System.out.println("응답 헤더: " + response.headers().map());
		System.out.println("응답 Body: " + response.body());

		ObjectMapper mapper = new ObjectMapper();
		Post post = mapper.readValue(response.body(), Post.class);
		System.out.println("post = " + post);
	}
}