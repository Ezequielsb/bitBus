package br.ucs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ucs.entities.Visitante;
import br.ucs.entities.VisitanteOficina;
import br.ucs.repositorios.VisitanteOficinaRepository;
import br.ucs.repositorios.VisitanteRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitanteServices {
	private final EntityManager entityManager;
	private final VisitanteRepository repository;
	private final VisitanteOficinaRepository repositoryOficina;

	

	@Transactional
	public void salvarVisitante(Visitante visitante) {
		try {
			entityManager.merge(visitante);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Visitante> getAllVisitants() {
		return repository.findAll();
	}

	public Visitante buscaPorId(Long id) {
		try {
			return repository.getById(id);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Visitante> buscaVisitantePorVisita(Long id){
		return repository.buscaVisitantePorVisita(id);
	}
	
	public List<VisitanteOficina> buscaVisitantePorOficina(Long id){
		return repositoryOficina.buscaVisitantePorOficina(id);
	}
	
	@Transactional
	public void salvarVisitanteOficina(VisitanteOficina visitante) {
		try {
			entityManager.merge(visitante);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<VisitanteOficina> getAllVisitantsOficina() {
		return repositoryOficina.findAll();
	}

	public VisitanteOficina buscaPorIdOficina(Long id) {
		try {
			return repositoryOficina.getById(id);
		} catch (Exception e) {
			return null;
		}
	}
}
