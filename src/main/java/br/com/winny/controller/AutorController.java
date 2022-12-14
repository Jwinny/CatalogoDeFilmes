package br.com.winny.controller;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.winny.modelo.Autor;
import br.com.winny.util.JPAUtil;

@Controller
public class AutorController {
	
	@RequestMapping(value="consultar-autor",method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Autor consultarAutor(@RequestParam Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		Autor autor = em.find(Autor.class,id);

		return autor;
	}
}
