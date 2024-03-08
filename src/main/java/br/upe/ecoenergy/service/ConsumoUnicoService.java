package br.upe.ecoenergy.service;

import br.upe.ecoenergy.domain.ConsumoUnico;
import br.upe.ecoenergy.repository.ConsumoUnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsumoUnicoService {

    private final ConsumoUnicoRepository repository;
    private final ConsumoMensalService consumoMensalService;

    public List<ConsumoUnico> consumos() {
        return repository.findAll();
    }

    public List<ConsumoUnico> consumosUnicosPorConsumoMensalId(Long id) {
        return repository.findAllByConsumoMensal_Id(id);
    }

    public Double calcularConsumoMensal(Long id) {
        List<ConsumoUnico> consumoUnicos = consumosUnicosPorConsumoMensalId(id);

        if (consumoUnicos.isEmpty()) {
            return 0.0;
        }

        Double wattsHoraTotal = 0.0;
        for (ConsumoUnico consumoUnico : consumoUnicos) {
            Double potencia = consumoUnico.getEletrodomestico().getPotencia();
            Double horasUso = consumoUnico.getHorasUso();
            wattsHoraTotal += potencia * horasUso;
        }

        Double kilowattsHoraTotal = wattsHoraTotal / 1000;
        return kilowattsHoraTotal;
    }

    public ConsumoUnico buscarConsumoUnicoPorId(Long id) {
        Optional<ConsumoUnico> consumoUnico = repository.findById(id);

        if (consumoUnico.isEmpty()) {
            throw new RuntimeException("Não foi encontrado Consumo único para esse Eletrodoméstico.");
        }

        return consumoUnico.get();
    }

    public ConsumoUnico registrarConsumoUnico(ConsumoUnico consumoUnico) {
        return repository.save(consumoUnico);
    }

    public ConsumoUnico atualizarConsumoUnico(ConsumoUnico consumoUnicoAtualizado) {

        ConsumoUnico consumoUnico = buscarConsumoUnicoPorId(consumoUnicoAtualizado.getId());
        if (consumoUnico.getId() == null) {
            throw new RuntimeException("Forneça o id do consumo unico que deseja atualizar");
        }

        consumoUnico.setHorasUso(consumoUnicoAtualizado.getHorasUso());


        return registrarConsumoUnico(consumoUnico);
    }

    public void deletarConsumoUnico(Long id) {
        ConsumoUnico consumoUnico = buscarConsumoUnicoPorId(id);
        repository.delete(consumoUnico);
    }
}
