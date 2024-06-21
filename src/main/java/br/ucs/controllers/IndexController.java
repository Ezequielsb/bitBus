package br.ucs.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.ucs.entities.Produto;
import br.ucs.services.ProdutoServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	private final ProdutoServices produtoServices;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		List<Produto> produtos = new ArrayList<>();
		produtos = this.produtoServices.getAllProducts();

		mv.addObject("produtos", produtos);
		return mv;
	}

	@PostMapping("/")
	public ModelAndView pesquisarProdutos(
			@RequestParam(value = "categoriaSelect", required = false) String categoriaSelect,
			@RequestParam(value = "codigoProduto", required = false) String codigoProduto,
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "ano", required = false) Integer ano) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");

		if (categoriaSelect != null && !categoriaSelect.equals("")) {
			mv.addObject("produtos", produtoServices.buscaProdutoPorCategoria(categoriaSelect));
		} else if (codigoProduto != null && !codigoProduto.equals("")) {
			mv.addObject("produtos", produtoServices.getProdutoById(codigoProduto));
		} else if (nome != null && !nome.equals("")) {
			mv.addObject("produtos", produtoServices.buscaProdutoPorNome(nome));
		} else if (ano != null && ano != 0) {
			mv.addObject("produtos", produtoServices.buscaProdutoPorAno(ano));
		} else {
			mv.addObject("produtos", produtoServices.getAllProducts());
		}
		return mv;
	}
	
	@PostMapping("/adicionarProduto")
	public ModelAndView adicionarProduto(@RequestParam("codigoProduto") String codigoProduto) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("index");
	    produtoServices.adicionaProduto(codigoProduto);
	    List<Produto> produtos = produtoServices.getAllProducts();
	    mv.addObject("produtos", produtos);

	    return mv;
	}
}
