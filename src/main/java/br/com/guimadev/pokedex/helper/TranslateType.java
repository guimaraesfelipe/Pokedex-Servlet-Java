package br.com.guimadev.pokedex.helper;

public abstract class TranslateType {

	public static String translate(String type) {

		switch (type) {
			case "bug": {
				return type = "inseto";
			}
			case "dark": {
				return type = "sombrio";
			}
			case "dragon": {
				return type = "dragão";
			}
			case "electric": {
				return type = "elétrico";
			}
			case "fairy": {
				return type = "fada";
			}
			case "fighting": {
				return type = "lutador";
			}
			case "fire": {
				return type = "fogo";
			}
			case "flying": {
				return type = "voador";
			}
			case "ghost": {
				return type = "fantasma";
			}
			case "grass": {
				return type = "planta";
			}
			case "ground": {
				return type = "terrestre";
			}
			case "ice": {
				return type = "gelo";
			}
			case "normal": {
				return type = "normal";
			}
			case "poison": {
				return type = "venenoso";
			}
			case "psychic": {
				return type = "psíquico";
			}
			case "rock": {
				return type = "pedra";
			}
			case "steel": {
				return type = "aço";
			}
			case "water": {
				return type = "água";
			}
			default:
				throw new IllegalArgumentException("Valor invalido: " + type);
		}
	}

}
