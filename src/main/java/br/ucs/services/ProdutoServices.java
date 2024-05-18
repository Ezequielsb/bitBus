package br.ucs.services;

import org.springframework.stereotype.Service;

import br.ucs.entities.Produto;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServices {
	private final EntityManager entityManager;
	//private final ProdutoRepository repository;
	
	@Transactional
	public void salvarProduto(Produto produto) {
		try {
			entityManager.persist(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
