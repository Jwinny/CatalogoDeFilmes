<%@ page import="br.com.winny.modelo.Filme"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Filmes</title>
</head>
<body>
	<h2>Lista de Filmes</h2>
	<ul>
		<%
		ArrayList<Filme> list = new ArrayList<Filme>();
		list = (ArrayList<Filme>) request.getAttribute("listaFiltrada");

		for (Filme filme : list) {
		%>

		<li>
			<%
			out.println("Nome: " + filme.getNome());
			out.println("<br>Gênero: " + filme.getGenero());
			out.println("<br>Ano: " + filme.getAno());
			%>
		</li>

		<%
		}
		%>
	</ul>
</body>
</html>