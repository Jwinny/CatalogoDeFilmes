package br.com.winny.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.winny.modelo.Filme;
import br.com.winny.util.JPAUtil;

@WebServlet("/filme")
public class FilmeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Filme filme = em.find(Filme.class, 1);
		
		ArrayList<Filme> listaFiltrada = new ArrayList<Filme>();
		listaFiltrada.add(filme);
		
		request.setAttribute("listaFiltrada", listaFiltrada); // objeto adicionado a requisição
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-filmes.jsp"); //redirecionamento para a pagina JSP
		dispatcher.forward(request, response); //passando os parametros que serão usados no redirecionamento
		
		

	}
}
