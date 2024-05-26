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

import br.ucs.entities.Produto;
import br.ucs.services.ProdutoServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CadastrarProdutoController {

	private final ProdutoServices produtoServices;

	@GetMapping("/cadastroProduto")
	public ModelAndView cadastroProduto() {
		ModelAndView mv = new ModelAndView("cadastroProduto");
		mv.addObject("produto", new Produto());
		return mv;
	}

	@PostMapping("/cadastroProduto")
	@ResponseBody
	public ResponseEntity<Map<String, String>> salvarProduto(Model mv, Produto produto) {
		Map<String, String> response = new HashMap<>();
		try {
			this.produtoServices.salvarProduto(produto);
			response.put("status", "success");
			response.put("message", "Produto cadastrado com sucesso!");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("status", "error");
			response.put("message", "Erro ao cadastrar produto!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}
