package br.upe.ecoenergy.service;

import br.upe.ecoenergy.domain.ConsumoMensal;
import br.upe.ecoenergy.repository.ConsumoMensalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsumoMensalService {
    private final ConsumoMensalRepository repository;

    public ConsumoMensal buscarConsumoMensalPorId(Long id) {
        Optional<ConsumoMensal> consumoMensal = repository.findById(id);

        if (consumoMensal.isEmpty()) {
            throw new RuntimeException("Não foi encontrado um consumo mensal com esse ID.");
        }

        return consumoMensal.get();
    }
}
