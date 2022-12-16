package br.com.guimadev.pokedex.model;

public class Type {

	private String name;
	
	public Type(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
