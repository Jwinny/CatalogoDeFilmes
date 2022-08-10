package br.com.winny.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.winny.modelo.Autor;
import br.com.winny.modelo.Filme;
import br.com.winny.util.JPAUtil;

@Controller
public class FilmeController {

	@RequestMapping(value = "/persistir-filme", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Filme persistirFilme(@RequestBody Filme filme) {

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin(); // É aconselhavel que a ordem de persistencia seja de "interno" para "externo".
		em.persist(filme.getAutor()); // No exemplo autor está dentro de filme. Então autor deve ser persistido antes.
		em.persist(filme);
		em.getTransaction().commit();
		em.close();

		return filme;

	}

	@RequestMapping(value = "/consulta-filme", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Filme consultarFilme(@RequestParam Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		Filme filme = em.find(Filme.class, id);

		return filme;

	}
}
