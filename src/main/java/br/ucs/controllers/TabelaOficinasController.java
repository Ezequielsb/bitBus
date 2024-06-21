package br.ucs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.services.OficinaServices;
import br.ucs.services.VisitanteServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TabelaOficinasController {
	private final OficinaServices oficinaServices;

	@GetMapping("/tabelaOficinas")
	public ModelAndView exibeOficinas() {
		ModelAndView mv = new ModelAndView("tabelaOficinas");
		mv.addObject("oficinas", oficinaServices.getAllOficinas());

		return mv;
	}
	
	@PostMapping("/tabelaOficinas")
	public ModelAndView pesquisarVisitas(
			@RequestParam(value = "local", required = false) String local,
			@RequestParam(value = "ministrante", required = false) String ministrante) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tabelaOficinas");

		if (local != null && !local.equals("")) {
			mv.addObject("oficinas", oficinaServices.buscaOficinasPorLocal(local));
		} else if (ministrante != null && !ministrante.equals("")) {
			mv.addObject("oficinas", oficinaServices.buscaOficinasPorMinistrante(ministrante));
		}else {
			mv.addObject("oficinas", oficinaServices.getAllOficinas());
		}
		return mv;
	}
}
