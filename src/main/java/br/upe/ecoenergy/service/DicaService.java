package br.upe.ecoenergy.service;

import br.upe.ecoenergy.domain.Dica;
import br.upe.ecoenergy.repository.DicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DicaService {
    private final DicaRepository repository;

    public List<Dica> listarDicas() {
        return repository.findAll();
    }

    public Dica buscarDicaPorId(Long id) {
        Optional<Dica> dica = repository.findById(id);

        if (dica.isEmpty()) {
            throw new RuntimeException("Não foi encontrada uma dica com este ID.");
        }

        return dica.get();
    }

    public Dica adicionarDica(Dica dica) {
        return repository.save(dica);
    }

    public Dica atualizarDica(Long id, Dica dicaAtualizada) {
        Dica dica = buscarDicaPorId(id);

        dica.setTitulo(dicaAtualizada.getTitulo());
        dica.setDescricao(dicaAtualizada.getDescricao());

        return adicionarDica(dica);
    }

    public void deletarDica(Long id) {
        Dica dica = buscarDicaPorId(id);
        repository.delete(dica);
    }
}
