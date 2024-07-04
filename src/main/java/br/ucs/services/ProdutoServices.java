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
			entityManager.merge(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void adicionaProduto(String produto) {
		try {
			Produto p = getProdutoById(produto);
			p.setQuantidade(p.getQuantidade() + 1);
			entityManager.merge(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Produto> getAllProducts() {
		return repository.buscarTodos();
	}

	public Produto getProdutoById(String id) {
		try {
			return repository.buscaPorCodigo(id);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Produto> buscaProdutoPorCategoria(String categoria) {
		try {
			return repository.buscaPorCategoria(categoria);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Produto> buscaProdutoPorNome(String nome) {
		try {
			return repository.buscaPorNome(nome);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Produto> buscaProdutoPorAno(Integer ano) {
		try {
			return repository.buscaPorAno(ano);
		} catch (Exception e) {
			return null;
		}
	}
}
