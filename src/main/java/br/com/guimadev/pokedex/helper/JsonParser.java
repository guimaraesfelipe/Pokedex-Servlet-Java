package br.com.guimadev.pokedex.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.guimadev.pokedex.exception.PokemonNotFoundException;

public class JsonParser {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static JsonNode parse(String content) {
		
		if (content.equals("Not Found")) {
			throw new PokemonNotFoundException("APPLICATION ALERT: Pokemon Not Found");
		}
		
		try {
			return objectMapper.readTree(content);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("PARSE ERROR: Json Parse Failure", e);
		}
	}

}
