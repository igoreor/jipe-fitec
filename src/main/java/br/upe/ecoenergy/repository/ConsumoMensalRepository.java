package br.upe.ecoenergy.repository;

import br.upe.ecoenergy.domain.ConsumoMensal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoMensalRepository extends JpaRepository<ConsumoMensal, Long> {
}
