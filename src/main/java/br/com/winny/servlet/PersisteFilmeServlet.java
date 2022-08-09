package br.com.winny.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.winny.modelo.Filme;
import br.com.winny.util.JPAUtil;

@WebServlet("/persistir-filme")
public class PersisteFilmeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		Integer ano = Integer.valueOf(request.getParameter("ano"));
		
		Filme filme = new Filme(nome, genero, ano);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();
		
		em.close();
	}
}
