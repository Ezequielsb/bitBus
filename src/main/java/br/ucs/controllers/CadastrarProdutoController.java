package br.ucs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.entities.Produto;

@Controller
public class CadastrarProdutoController {
	
    @GetMapping("/cadastroProduto")
    public ModelAndView cadastroProduto() {
        ModelAndView mv = new ModelAndView("cadastroProduto");
        mv.addObject("produto", new Produto());
        return mv;
    }

}
