package br.upe.ecoenergy.service;


import br.upe.ecoenergy.domain.Eletrodomestico;
import br.upe.ecoenergy.repository.EletrodomesticoRepository;;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EletrodomesticoService {

    private final EletrodomesticoRepository repository;

    public List<Eletrodomestico> eletrodomesticos() {
        return repository.findAll();
    }

    public Eletrodomestico buscarEletrodomesticoPorId(Long id) {
        Optional<Eletrodomestico> eletrodomestico = repository.findById(id);

        if (eletrodomestico.isEmpty()) {
            throw new RuntimeException("Não foi encontrado Eletrodoméstico com esse ID.");
        }

        return eletrodomestico.get();
    }

    public Eletrodomestico registrarEletrodomestico(Eletrodomestico eletrodomestico) {
        return repository.save(eletrodomestico);
    }

    public Eletrodomestico atualizarEletrodomestico(Eletrodomestico eletrodomesticoAtualizado) {

        Eletrodomestico eletrodomestico = buscarEletrodomesticoPorId(eletrodomesticoAtualizado.getId());
        if (eletrodomesticoAtualizado.getId() == null){
            throw new RuntimeException("Forneça o id do eletrodomestico que deseja atualizar");
        }

        eletrodomestico.setNome(eletrodomesticoAtualizado.getNome());
        eletrodomestico.setPotencia(eletrodomesticoAtualizado.getPotencia());
        eletrodomestico.setUsuario(eletrodomesticoAtualizado.getUsuario());

        return registrarEletrodomestico(eletrodomestico);
    }

    public void deletarEletrodomestico(Long id) {
        Eletrodomestico eletrodomestico = buscarEletrodomesticoPorId(id);
        repository.delete(eletrodomestico);
    }
}
