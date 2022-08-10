package br.com.winny.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.winny.modelo.Autor;
import br.com.winny.modelo.Filme;
import br.com.winny.util.JPAUtil;

@WebServlet("/persistir-filme")
public class PersisteFilmeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		Integer ano = Integer.valueOf(request.getParameter("ano"));
		
		String nomeAutor = request.getParameter("nomeAutor");
		LocalDate dataNascimentoAutor = LocalDate.parse(request.getParameter("dataNascimentoAutor"));
		
		Autor autor = new Autor(nomeAutor,dataNascimentoAutor);
		
		Filme filme = new Filme(nome, genero, ano);
		filme.setAutor(autor);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin(); //É aconselhavel que a ordem de persistencia seja de "interno" para "externo".
		em.persist(autor);			 //No exemplo autor está dentro de filme. Então autor deve ser persistido antes.
		em.persist(filme);
		em.getTransaction().commit();
		
		em.close();
	}
}
