package br.ucs.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.entities.Visita;
import br.ucs.entities.Visitante;
import br.ucs.services.VisitaServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CadastrarVisitaController {
	private VisitaServices visitaServices;
	
	@GetMapping("/cadastroVisita")
	public ModelAndView cadastroVisita() {
		ModelAndView mv = new ModelAndView("cadastroVisita");
		mv.addObject("visita", new Visita());
		return mv;
	}
	
	@PostMapping("/cadastroVisita")
	@ResponseBody
	public ResponseEntity<Map<String, String>> salvarVisita(Model mv, Visita visita) {
		Map<String, String> response = new HashMap<>();
		try {
			List<Visitante> visitantes = new ArrayList<>();
			visita.setVisitantes(visitantes);
			this.visitaServices.salvarVisita(visita);
			response.put("status", "success");
			response.put("message", "Visita cadastrada com sucesso!");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "error");
			response.put("message", "Erro ao cadastrar visita!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}
