package br.ucs.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucs.entities.Oficina;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Long> {

}
