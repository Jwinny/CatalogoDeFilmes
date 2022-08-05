package br.com.winny.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.winny.modelo.Filme;

@WebServlet("/oficina-filme")
public class OficinaJavaWebServlet extends HttpServlet {

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

		Integer ano = Integer.parseInt(request.getParameter("ano"));

		response.setContentType("text/HTML"); // Define o tipo de resposta que a lista retorna

		PrintWriter out = response.getWriter();

		out.println("<h2>Lista de Filmes</h2>");

		out.println("<ul>");

		filmes.stream().filter(filme -> filme.getAno() >= ano).forEach(filme -> {
			out.println(String.format("<li>Nome: %s", filme.getNome()));
			out.println(String.format("<br>Gênero: %s", filme.getGenero()));
			out.println(String.format("<br>Ano: %s </li>", filme.getAno()));
		});

		out.println("</ul>");
		out.close();
	}
}
