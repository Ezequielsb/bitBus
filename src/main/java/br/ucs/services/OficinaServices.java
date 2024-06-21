package br.ucs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ucs.entities.Oficina;
import br.ucs.entities.Visita;
import br.ucs.repositorios.OficinaRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OficinaServices {
	private final EntityManager entityManager;
	private final OficinaRepository repository;
	
	@Transactional
	public void salvarOficina(Oficina oficina) {
		try {
			entityManager.merge(oficina);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Oficina> getAllOficinas() {
		return repository.findAll();
	}
	
	public Oficina buscaPorId(Long id) {
		try {
			return repository.getById(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Oficina> buscaOficinasPorLocal(String local) {
		return repository.buscaOficinasPorLocal(local);
	}
	
	public List<Oficina> buscaOficinasPorMinistrante(String resp) {
		return repository.buscaOficinasPorMinistrante(resp);
	}
}
