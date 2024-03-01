package br.upe.ecoenergy.repository;

import br.upe.ecoenergy.domain.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long> {
}
