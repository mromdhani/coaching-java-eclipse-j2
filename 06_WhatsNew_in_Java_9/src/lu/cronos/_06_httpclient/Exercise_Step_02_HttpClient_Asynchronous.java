package lu.cronos._06_httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exercise_Step_02_HttpClient_Asynchronous {

	public static void main(String[] args) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest
					.newBuilder()
					.uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
					.build();

			// Synchronous call
			// HttpResponse<String> response = client.send(request, ...
			// System.out.println(response.body());

			// Asynchronous call

			CompletableFuture<HttpResponse<String>> responseFutureTask = client.sendAsync(request,
					BodyHandlers.ofString());

			responseFutureTask.thenAccept(resp -> System.out.println(resp.body()));

			System.out.println("Result of the Asynchrnous call:");

			responseFutureTask.get();

			// responseFutureTask.join();
			// //https://onefeed.xyz/posts/20210323-completablefuture-join-vs-get.html

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}
