package br.ucs.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.entities.Doacao;
import br.ucs.entities.Produto;
import br.ucs.services.DoacaoServices;
import br.ucs.services.ProdutoServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class TabelaDoacoesController {
	private final DoacaoServices doacaoServices;
	private final ProdutoServices produtoServices;

	@GetMapping("/tabelaDoacoes")
	public ModelAndView exibeDoacoes() {
		ModelAndView mv = new ModelAndView("tabelaDoacoes");
		mv.addObject("doacoes", doacaoServices.getAllDoacoes());

		return mv;
	}

	@GetMapping("/cadastroDoacao")
	public ModelAndView cadastraDoacao() {
		ModelAndView mv = new ModelAndView("cadastroDoacao");
		mv.addObject("doacao", new Doacao());
		List<Produto> opcoesProduto = produtoServices.getAllProducts();
		mv.addObject("opcoesProduto", opcoesProduto);
		return mv;
	}

	@PostMapping("/tabelaDoacoes")
	public ModelAndView pesquisarDoacoes(@RequestParam(value = "filtroDoacao", required = false) String filtroDoacao) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tabelaDoacoes");

		if (filtroDoacao != null && !filtroDoacao.equals("")) {
			mv.addObject("doacoes", doacaoServices.buscaDoacaoPorCategoria(filtroDoacao));
		} else {
			mv.addObject("doacoes", doacaoServices.getAllDoacoes());
		}
		mv.addObject("filtroDoacao", filtroDoacao);

		return mv;
	}

	@PostMapping("/cadastroDoacao")
	@ResponseBody
	public ResponseEntity<Map<String, String>> salvarDoacao(Model mv, Doacao doacao,
			@RequestParam(value = "selectProduto", required = false) String produtoSelecionado) {
		Map<String, String> response = new HashMap<>();
		if (produtoSelecionado != null && doacao.getTipoDoacao().equals("Produto")) {
			System.out.println("Achou produto");
			Produto p = this.produtoServices.getProdutoById(produtoSelecionado);
			doacao.setProduto(p);
		}
		try {
			this.doacaoServices.salvarDoacao(doacao);
			response.put("status", "success");
			response.put("message", "Doação cadastrada com sucesso!");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "error");
			response.put("message", "Erro ao cadastrar doação!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
