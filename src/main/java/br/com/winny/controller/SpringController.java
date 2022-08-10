package br.com.winny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

	@RequestMapping(value="/adicionaFilme",method = RequestMethod.GET)
	@ResponseBody
	public String adicionaFilme(String nome, String genero, Integer ano) {
		String resposta = "<h2>" + nome + " " + genero + " " + ano + "</h2>";
		return resposta;
	}
}
