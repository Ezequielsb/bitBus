package br.ucs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.services.OficinaServices;
import br.ucs.services.VisitanteServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TabelaOficinasController {
	private final OficinaServices oficinaServices;
	private final VisitanteServices visitantesServices;

	@GetMapping("/tabelaOficinas")
	public ModelAndView exibeOficinas() {
		ModelAndView mv = new ModelAndView("tabelaOficinas");
		mv.addObject("oficinas", oficinaServices.getAllOficinas());

		return mv;
	}

}
