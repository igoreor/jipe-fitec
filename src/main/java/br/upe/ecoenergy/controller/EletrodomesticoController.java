package br.upe.ecoenergy.controller;

import br.upe.ecoenergy.domain.Eletrodomestico;
import br.upe.ecoenergy.service.EletrodomesticoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eletrodomestico")
@RequiredArgsConstructor
public class EletrodomesticoController {
    private final EletrodomesticoService eletrodomesticoService;

    @GetMapping
    public ResponseEntity<List<Eletrodomestico>> listarEletrodomesticos() {
        List<Eletrodomestico> eletrodomesticos = eletrodomesticoService.eletrodomesticos();
        return ResponseEntity.ok(eletrodomesticos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eletrodomestico> buscarEletrodomesticoPorId(@PathVariable Long id) {
        Eletrodomestico eletrodomestico = eletrodomesticoService.buscarEletrodomesticoPorId(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping
    public ResponseEntity<Eletrodomestico> registrarEletrodomestico(@RequestBody Eletrodomestico eletrodomestico) {
        Eletrodomestico novoEletrodomestico = eletrodomesticoService.registrarEletrodomestico(eletrodomestico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEletrodomestico);
    }

    @PutMapping
    public ResponseEntity<Eletrodomestico> atualizarEletrodomestico(@RequestBody Eletrodomestico eletrodomesticoAtualizado) {
        Eletrodomestico eletrodomestico = eletrodomesticoService.atualizarEletrodomestico(eletrodomesticoAtualizado);
        return ResponseEntity.ok(eletrodomestico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEletrodomestico(@PathVariable Long id) {
        eletrodomesticoService.deletarEletrodomestico(id);
        return ResponseEntity.noContent().build();
    }

}
