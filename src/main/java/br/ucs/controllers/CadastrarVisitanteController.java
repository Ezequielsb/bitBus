package br.ucs.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.entities.Oficina;
import br.ucs.entities.Visita;
import br.ucs.entities.Visitante;
import br.ucs.entities.VisitanteOficina;
import br.ucs.services.OficinaServices;
import br.ucs.services.VisitaServices;
import br.ucs.services.VisitanteServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CadastrarVisitanteController {
	private final VisitaServices visitaServices;
	private final VisitanteServices visitanteServices;
	private final OficinaServices oficinaServices;

	@GetMapping("/cadastroVisitante")
	public ModelAndView cadastroVisita(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("cadastroVisitante");
		Visitante visitante = new Visitante();

		Visita visita = visitaServices.buscaPorId(id);
		visitante.setVisita(visita);
		mv.addObject("visitante", visitante);
		return mv;
	}
	
	@GetMapping("/cadVisitanteOficina")
	public ModelAndView cadastroVisitanteOficina(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("cadVisitanteOficina");
		VisitanteOficina visitante = new VisitanteOficina();

		Oficina oficina = oficinaServices.buscaPorId(id);
		visitante.setOficina(oficina);
		mv.addObject("visitante", visitante);
		return mv;
	}

	@PostMapping("/cadastroVisitante")
	@ResponseBody
	public ResponseEntity<Map<String, String>> salvarVisitante(@ModelAttribute Visitante visitante) {
		Map<String, String> response = new HashMap<>();
		try {
			this.visitanteServices.salvarVisitante(visitante);
			response.put("status", "success");
			response.put("message", "Visitante cadastrado com sucesso!");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "error");
			response.put("message", "Erro ao cadastrar visitante!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	@PostMapping("/cadVisitanteOficina")
	@ResponseBody
	public ResponseEntity<Map<String, String>> salvarVisitanteOficina(@ModelAttribute VisitanteOficina visitante) {
		Map<String, String> response = new HashMap<>();
		try {
			this.visitanteServices.salvarVisitanteOficina(visitante);
			response.put("status", "success");
			response.put("message", "Visitante cadastrado com sucesso!");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "error");
			response.put("message", "Erro ao cadastrar visitante!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
