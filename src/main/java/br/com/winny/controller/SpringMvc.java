package br.com.winny.controller;

import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringMvc {

	@RequestMapping(value = "/spring-mvc-version", method = RequestMethod.GET)
	@ResponseBody
	public String getVersion() {
		String body = "<h2> Spring MVC configurado em funcionamento </h2>";
		body += "Version: " + SpringVersion.getVersion();

		return body;
	}
}
