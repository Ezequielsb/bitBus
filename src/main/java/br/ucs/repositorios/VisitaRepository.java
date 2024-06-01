package br.ucs.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucs.entities.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long>{

}
