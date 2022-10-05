package lu.cronos._06_httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Exercise_Step_01_HttpClient_Synchronous {

	public static void main(String[] args) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest
					.newBuilder()
					.uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
					.build();

			// Synchronous call
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println(response.body());

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} 

	}

}
