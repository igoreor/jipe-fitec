package br.upe.ecoenergy.service;

import br.upe.ecoenergy.domain.ConsumoMensal;
import br.upe.ecoenergy.repository.ConsumoMensalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsumoMensalService {
    private final ConsumoMensalRepository repository;

    public List<ConsumoMensal> consumosMensais() {
        return repository.findAll();
    }

    public List<ConsumoMensal> consumoMensaisPorUsuarioId(String id) {
        return repository.findAllByUsuario_Id(id);
    }

    public List<ConsumoMensal> consumoMensaisPorUsuarioIdEMes(String usuarioId, String mes) {
        return repository.findAllByUsuario_IdAndNome(usuarioId, mes);
    }

    public ConsumoMensal buscarConsumoMensalPorId(Long id) {
        Optional<ConsumoMensal> consumoMensal = repository.findById(id);

        if (consumoMensal.isEmpty()) {
            throw new RuntimeException("Não foi encontrado um consumo mensal com esse ID.");
        }

        return consumoMensal.get();
    }

    public ConsumoMensal registrarConsumoMensal(ConsumoMensal consumoMensal) {
        return repository.save(consumoMensal);
    }

    public ConsumoMensal atualizarConsumoMensal(ConsumoMensal consumoMensalAtualizado) {
        ConsumoMensal consumoMensal = buscarConsumoMensalPorId(consumoMensalAtualizado.getId());

        consumoMensal.setNome(consumoMensalAtualizado.getNome());
        consumoMensal.setKilowattsHoraTotal(consumoMensalAtualizado.getKilowattsHoraTotal());
        consumoMensal.setUsuario(consumoMensalAtualizado.getUsuario());

        return registrarConsumoMensal(consumoMensal);
    }

    public void deletarConsumoMensal(Long id) {
        ConsumoMensal consumoMensal = buscarConsumoMensalPorId(id);
        repository.delete(consumoMensal);
    }
}
