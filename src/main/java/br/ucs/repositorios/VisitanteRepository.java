package br.ucs.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ucs.entities.Visitante;

@Repository
public interface VisitanteRepository  extends JpaRepository<Visitante, Long>{
	@Query("SELECT i FROM Visitante i WHERE i.visita.id = :id")
	List<Visitante> buscaVisitantePorVisita(@Param("id") Long id);
}
