package br.ucs.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.entities.Oficina;
import br.ucs.services.OficinaServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CadastrarOficinaController {
	private final OficinaServices oficinaServices;
	
	@GetMapping("/cadastroOficina")
	public ModelAndView cadastroOficina() {
		ModelAndView mv = new ModelAndView("cadastroOficina");
		mv.addObject("oficina", new Oficina());
		return mv;
	}
	
	@PostMapping("/cadastroOficina")
	@ResponseBody
	public ResponseEntity<Map<String, String>> salvarOficina(Model mv, Oficina oficina) {
		Map<String, String> response = new HashMap<>();
		try {
			this.oficinaServices.salvarOficina(oficina);
			response.put("status", "success");
			response.put("message", "Oficina cadastrada com sucesso!");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "error");
			response.put("message", "Erro ao cadastrar oficina!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
