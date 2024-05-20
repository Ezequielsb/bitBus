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
			if (prodAux != null) {
				prodAux.setQuantidade(prodAux.getQuantidade() + produto.getQuantidade());
				entityManager.merge(prodAux);
			} else {
				entityManager.persist(produto);
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
			return repository.getById(id);
		} catch (Exception e) {
			return null;
		}
	}
}
