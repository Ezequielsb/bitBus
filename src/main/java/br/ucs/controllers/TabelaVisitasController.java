package br.ucs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.services.VisitaServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TabelaVisitasController {
	private VisitaServices visitaServices;
	
	@GetMapping("/tabelaVisitas")
	public ModelAndView exibeVisitas() {
		ModelAndView mv = new ModelAndView("tabelaVisitas");
		return mv;
	}

}
