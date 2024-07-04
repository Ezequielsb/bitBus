package br.ucs.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ucs.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {
	
	@Query("SELECT i FROM Produto i WHERE i.codigoProduto = :codigo")
	Produto buscaPorCodigo(@Param("codigo") String codigo);
	
	@Query("SELECT i FROM Produto i WHERE i.categoria = :categoria")
	List<Produto> buscaPorCategoria(@Param("categoria") String categoria);
	
	@Query("SELECT i FROM Produto i WHERE i.nome LIKE %:nome%")
	List<Produto> buscaPorNome(@Param("nome") String nome);
	
	@Query("SELECT i FROM Produto i WHERE i.ano = :ano")
	List<Produto> buscaPorAno(@Param("ano") Integer ano);
	
	@Query("SELECT i FROM Produto i order by i.codigoProduto ASC")
	List<Produto> buscarTodos();
}
