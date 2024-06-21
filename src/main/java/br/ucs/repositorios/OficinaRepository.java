package br.ucs.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ucs.entities.Oficina;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Long> {
	@Query("SELECT i FROM Oficina i WHERE i.local = :local")
	List<Oficina> buscaOficinasPorLocal(@Param("local") String local);
	
	@Query("SELECT i FROM Oficina i WHERE i.ministrante = :ministrante")
	List<Oficina> buscaOficinasPorMinistrante(@Param("ministrante") String ministrante);
}
