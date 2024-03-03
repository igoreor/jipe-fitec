package br.upe.ecoenergy.controller;

import br.upe.ecoenergy.domain.ConsumoUnico;
import br.upe.ecoenergy.domain.Eletrodomestico;
import br.upe.ecoenergy.service.ConsumoUnicoService;
import br.upe.ecoenergy.service.EletrodomesticoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumos-unicos")
@RequiredArgsConstructor
public class ConsumoUnicoController {

    private ConsumoUnicoService consumoUnicoService;

    @GetMapping
    public ResponseEntity<List<ConsumoUnico>> listarConsumosUnicos() {
        List<ConsumoUnico> listaConsumoUnico = consumoUnicoService.consumos();
        return ResponseEntity.ok(listaConsumoUnico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoUnico> buscarConsumoUnicoPorId(@PathVariable Long id) {
        ConsumoUnico  consumoUnico = consumoUnicoService.buscarConsumoUnicoPorId(id);
        return ResponseEntity.ok(consumoUnico);
    }

    @PostMapping
    public ResponseEntity<ConsumoUnico> registrarconsumoUnico(@RequestBody ConsumoUnico consumoUnico) {
        ConsumoUnico novoConsumoUnico = consumoUnicoService.registrarConsumoUnico(consumoUnico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConsumoUnico);
    }

    @PutMapping
    public ResponseEntity<ConsumoUnico> atualizarConsumoUnico(@RequestBody ConsumoUnico consumoUnicoAtualizado) {
        ConsumoUnico consumoUnico = consumoUnicoService.atualizarConsumoUnico(consumoUnicoAtualizado);
        return ResponseEntity.ok(consumoUnico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsumoUnico(@PathVariable Long id) {
        consumoUnicoService.deletarConsumoUnico(id);
        return ResponseEntity.noContent().build();
    }
}
