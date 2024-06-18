package br.ucs.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ucs.entities.Visitante;
import br.ucs.entities.VisitanteOficina;

@Repository
public interface VisitanteOficinaRepository extends JpaRepository<VisitanteOficina, Long>{
	@Query("SELECT i FROM VisitanteOficina i WHERE i.oficina.id = :id")
	List<VisitanteOficina> buscaVisitantePorOficina(@Param("id") Long id);
}
