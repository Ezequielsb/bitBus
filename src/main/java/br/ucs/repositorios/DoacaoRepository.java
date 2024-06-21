package br.ucs.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ucs.entities.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long>{
	@Query("SELECT i FROM Doacao i WHERE i.tipoDoacao = :categoria")
	List<Doacao> buscaDoacaoPorCategoria(@Param("categoria") String categoria);
}
