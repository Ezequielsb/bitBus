package br.ucs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ucs.entities.Produto;
import br.ucs.repositorios.ProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServices {
	private final EntityManager entityManager;
	private final ProdutoRepository repository;

	@Transactional
	public void salvarProduto(Produto produto) {
		try {
			Produto prodAux = null;
			try {
				prodAux = getProdutoById(produto.getCodigoProduto());
			} catch (Exception e) {
			}
			if (prodAux == null) {
				entityManager.merge(produto);
			} else {
				prodAux.setQuantidade(prodAux.getQuantidade() + produto.getQuantidade());
				entityManager.merge(prodAux);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Produto> getAllProducts() {
		return repository.findAll();
	}

	public Produto getProdutoById(String id) {
		try {
			return repository.buscaPorCodigo(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Produto> buscaProdutoPorCategoria(String categoria){
		try {
			return repository.buscaPorCategoria(categoria);
		} catch (Exception e) {
			return null;
		}
	}
	public List<Produto> buscaProdutoPorNome(String nome){
		try {
			return repository.buscaPorNome(nome);
		} catch (Exception e) {
			return null;
		}
	}
	public List<Produto> buscaProdutoPorAno(Integer ano){
		try {
			return repository.buscaPorAno(ano);
		} catch (Exception e) {
			return null;
		}
	}
}
