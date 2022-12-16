<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="br.com.guimadev.pokedex.model.Pokemon"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/search" var="linkServletSearch" />

<!DOCTYPE html>

<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="icon" href="./resources/icon/icon-16x16.png">
    <link rel="stylesheet" href="./style.css">

    <title>Pokédex</title>
</head>

<body>
    <main>
    	<script type="text/javascript">
			function searching() {
				document.querySelector('.pokemon__name').innerHTML = "Buscando.....";
				document.querySelector('.pokemon__number').innerHTML = "";
			}
		</script>
    
        <form class="formSearch" action="${linkServletSearch }">
            <input type="search" class="input__search" placeholder="Nome ou Número" name="pokemon" onchange="searching()" required>
        </form>
        
        <c:if test="${not empty searchPokemon.sprite }"> <img src="${searchPokemon.sprite }" alt="pokemon" class="pokemon__image"> </c:if>
        	
        <c:if test="${not empty searchPokemon }">
        	<div class="pokemon__data">
            	<span class="pokemon__number">${searchPokemon.id }<c:if test="${not empty searchPokemon.id }"> - </c:if></span>
            	<span class="pokemon__name">${searchPokemon.name }</span>
        	</div>
        
        	<div class="pokemon__types">
            	<span class="pokemon__type1">${searchPokemon.types[0] }</span>
            	<c:if test="${not empty searchPokemon.types[1] }"> <span class="pokemon__type2"> - ${searchPokemon.types[1] }</span> </c:if>
    	    </div>
	    </c:if>

	    <form class="formButton" action="${linkServletSearch }">
	        <div class="buttons" onclick="searching()">
            	<button class="button btn-prev" name="pokemon" value="${searchPokemon.id - 1}"> &lt; Voltar </button>
            	<button class="button btn-next" name="pokemon" value="${searchPokemon.id + 1}"> Próximo &gt;</button>
        	</div>
	    </form>

        <img src="./resources/img/pokedex.png" alt="pokedex" class="pokedex__image">
    </main>

</body>
</html>