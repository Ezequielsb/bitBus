package br.ucs.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ucs.entities.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long>{
	@Query("SELECT i FROM Visita i WHERE i.local = :local")
	List<Visita> buscaVisitasPorLocal(@Param("local") String local);
	
	@Query("SELECT i FROM Visita i WHERE i.responsavel = :responsavel")
	List<Visita> buscaVisitasPorResponsavel(@Param("responsavel") String responsavel);
}
