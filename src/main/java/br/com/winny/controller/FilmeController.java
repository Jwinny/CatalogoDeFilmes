package br.com.winny.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/persistir-filme", method = RequestMethod.GET)
	public String persistirFilme(@RequestParam String nome, @RequestParam String genero, @RequestParam String ano,
			@RequestParam String nomeAutor, @RequestParam String dataNascimentoAutor) {
		Autor autor = new Autor(nomeAutor, LocalDate.parse(dataNascimentoAutor));

		Filme filme = new Filme(nome, genero, Integer.valueOf(ano));
		filme.setAutor(autor);

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin(); // É aconselhavel que a ordem de persistencia seja de "interno" para "externo".
		em.persist(autor); // No exemplo autor está dentro de filme. Então autor deve ser persistido antes.
		em.persist(filme);
		em.getTransaction().commit();

		em.close();
		return "persistir-filme-view";

	}

	@RequestMapping(value = "/consulta-filme", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView consultarFilme(@RequestParam Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		Filme filme = em.find(Filme.class, id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("consultar-filme-view");
		modelAndView.addObject("nome", filme.getNome());
		modelAndView.addObject("genero", filme.getGenero());
		modelAndView.addObject("ano", filme.getAno());
		return modelAndView;
		
	}
}
