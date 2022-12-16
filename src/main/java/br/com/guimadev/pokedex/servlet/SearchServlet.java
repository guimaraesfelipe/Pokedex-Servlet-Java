package br.com.guimadev.pokedex.servlet;

import java.io.IOException;

import br.com.guimadev.pokedex.exception.PokemonNotFoundException;
import br.com.guimadev.pokedex.factory.ConnectionFactory;
import br.com.guimadev.pokedex.model.Pokemon;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("pokemon");
		ConnectionFactory connection = new ConnectionFactory("https://pokeapi.co/api/v2/pokemon/");

		Pokemon searchPokemon = new Pokemon("1", connection);

		if (isParameterValid(parameter)) {
			try {
				searchPokemon = new Pokemon(parameter, connection);
			} catch (PokemonNotFoundException e) {
				searchPokemon = new Pokemon(e);
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("searchPokemon", searchPokemon);
		dispatcher.forward(request, response);
	}

	private Boolean isParameterValid(String parameter) {
		try {
			if (Integer.parseInt(parameter) != 0 && Integer.parseInt(parameter) != 650) {
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			return true;
		}

	}

}
