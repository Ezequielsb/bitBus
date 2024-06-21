package br.ucs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ucs.entities.Visita;
import br.ucs.repositorios.VisitaRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitaServices {
	private final EntityManager entityManager;
	private final VisitaRepository repository;

	@Transactional
	public void salvarVisita(Visita visita) {
		try {
			System.out.println("entrou aqui");
			entityManager.merge(visita);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Visita> getAllVisits() {
		return repository.findAll();
	}

	public Visita buscaPorId(Long id) {
		try {
			return repository.getById(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Visita> buscaVisitasPorLocal(String local) {
		return repository.buscaVisitasPorLocal(local);
	}
	
	public List<Visita> buscaVisitasPorResponsavel(String resp) {
		return repository.buscaVisitasPorResponsavel(resp);
	}

}
