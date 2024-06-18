package br.ucs.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucs.entities.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long>{

}
