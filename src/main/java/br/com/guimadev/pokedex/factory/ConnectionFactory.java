package br.com.guimadev.pokedex.factory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionFactory {
	
	private final String MAIN_PATH;
	
	public ConnectionFactory(String mainPath) {
		this.MAIN_PATH = mainPath;
	}
	
	public String request(String resource) {
		URI path = URI.create(this.MAIN_PATH + resource);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(path).GET().build();
		
		try {
			return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException("RESPONSE ERROR: Response Failure", e);
		}
	}

}
