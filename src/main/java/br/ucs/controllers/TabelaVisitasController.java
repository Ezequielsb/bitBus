package br.ucs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.services.VisitaServices;
import br.ucs.services.VisitanteServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TabelaVisitasController {
	private final VisitaServices visitaServices;
	private final VisitanteServices visitantesServices;
	
	@GetMapping("/tabelaVisitas")
	public ModelAndView exibeVisitas() {
		ModelAndView mv = new ModelAndView("tabelaVisitas");
		mv.addObject("visitas", visitaServices.getAllVisits());

		return mv;
	}
	
	@GetMapping("/tabelaVisitantes")
	public ModelAndView exibeVisitantes(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("tabelaVisitantes");
		mv.addObject("visitantes", visitantesServices.buscaVisitantePorVisita(id));
		return mv;
	}
	
	@GetMapping("/tabelaVisitantesOficina")
	public ModelAndView exibeVisitantesOficina(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("tabelaVisitantesOficina");
		mv.addObject("visitantes", visitantesServices.buscaVisitantePorOficina(id));
		return mv;
	}

}
