package br.upe.ecoenergy.repository;

import br.upe.ecoenergy.domain.ConsumoUnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumoUnicoRepository extends JpaRepository<ConsumoUnico, Long> {
    List<ConsumoUnico> findAllByConsumoMensal_Id(Long id);
}
