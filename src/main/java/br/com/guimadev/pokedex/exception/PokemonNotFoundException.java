package br.com.guimadev.pokedex.exception;

public class PokemonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PokemonNotFoundException(String msg) {
		super(msg);
	}

}
