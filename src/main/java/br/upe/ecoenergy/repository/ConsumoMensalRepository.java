package br.upe.ecoenergy.repository;

import br.upe.ecoenergy.domain.ConsumoMensal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumoMensalRepository extends JpaRepository<ConsumoMensal, Long> {
    List<ConsumoMensal> findAllByUsuario_Id(String id);
}
