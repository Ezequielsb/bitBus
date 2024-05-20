package br.ucs.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Produto> produtos = this.produtoServices.getAllProducts();
		mv.addObject("produtos", produtos);
		return mv;
	}
}
