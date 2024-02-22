package br.upe.ecoenergy.repository;

import br.upe.ecoenergy.domain.ConsumoUnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoUnicoRepository extends JpaRepository<ConsumoUnico, Long> {
}
