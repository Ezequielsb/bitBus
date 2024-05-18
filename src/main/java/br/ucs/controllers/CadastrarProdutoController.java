package br.ucs.controllers;

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
    public ResponseEntity<String> salvarProduto(Model mv, Produto produto) {
    	this.produtoServices.salvarProduto(produto);
	    return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }

}
