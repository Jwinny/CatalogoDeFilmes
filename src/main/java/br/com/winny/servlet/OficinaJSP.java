package br.com.winny.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.winny.modelo.Filme;

@WebServlet("/infofilme")
public class OficinaJSP extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Filme coringa = new Filme("Coringa", "Drama", 2019);
		Filme matrix = new Filme("Matrix", "Ação", 1999);
		Filme forestGump = new Filme("Forest Gump", "Drama", 1994);

		ArrayList<Filme> filmes = new ArrayList<Filme>();

		filmes.add(coringa);
		filmes.add(matrix);
		filmes.add(forestGump);

		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		Integer ano = Integer.parseInt(request.getParameter("ano"));

		ArrayList<Filme> listaFiltrada = filmes.stream()
				.filter(filme -> filme.getNome().toLowerCase().equals(nome.toLowerCase()))
				.filter(filme -> filme.getGenero().toLowerCase().equals(genero.toLowerCase()))
				.filter(filme -> filme.getAno().equals(ano))
				.collect(Collectors.toCollection(ArrayList::new));
		
		request.setAttribute("listaFiltrada", listaFiltrada); // objeto adicionado a requisição
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-filmes.jsp"); //redirecionamento para a pagina JSP
		dispatcher.forward(request, response); //passando os parametros que serão usados no redirecionamento
		
		

	}
}
