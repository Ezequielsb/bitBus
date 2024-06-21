package br.ucs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ucs.entities.Doacao;
import br.ucs.repositorios.DoacaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoacaoServices {
	private final EntityManager entityManager;
	private final DoacaoRepository repository;

	@Transactional
	public void salvarDoacao(Doacao doacao) {
		try {
			entityManager.merge(doacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Doacao> getAllDoacoes() {
		return repository.findAll();
	}

	public List<Doacao> buscaDoacaoPorCategoria(String categoria) {
		try {
			return repository.buscaDoacaoPorCategoria(categoria);
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
}
