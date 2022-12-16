package br.com.guimadev.pokedex.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.guimadev.pokedex.exception.PokemonNotFoundException;
import br.com.guimadev.pokedex.factory.ConnectionFactory;
import br.com.guimadev.pokedex.helper.JsonParser;
import br.com.guimadev.pokedex.helper.TranslateType;

public class Pokemon {

	private Integer id;
	private String name;
	private List<Type> types = new ArrayList<>();
	private String sprite;

	public Pokemon(String parameter, ConnectionFactory connection) {
		String response = connection.request(parameter.toLowerCase());
		JsonNode node = JsonParser.parse(response);
		
		if (node.get("id").asInt() > 649) {
			throw new PokemonNotFoundException("APPLICATION ALERT: Pokemon ID Greater Than 649");
		}

		this.id = node.get("id").asInt();
		this.name = node.get("name").asText();
		this.sprite = node.get("sprites").get("versions").get("generation-v").get("black-white").get("animated")
				.get("front_default").asText();

		node.get("types").forEach(a -> {
			this.types.add(new Type(TranslateType.translate(a.get("type").get("name").asText())));
		});

	}
	
	public Pokemon(PokemonNotFoundException exception) {
		if(exception != null) {
			this.id = 1;
			this.name = "nao encontrado";
		}
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Type> getTypes() {
		return types;
	}

	public String getSprite() {
		return sprite;
	}

}
