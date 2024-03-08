package br.upe.ecoenergy.controller;

import br.upe.ecoenergy.domain.ConsumoMensal;
import br.upe.ecoenergy.domain.ConsumoUnico;
import br.upe.ecoenergy.service.ConsumoMensalService;
import br.upe.ecoenergy.service.ConsumoUnicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumos-unicos")
@RequiredArgsConstructor
public class ConsumoUnicoController {

    private final ConsumoUnicoService consumoUnicoService;
    private final ConsumoMensalService consumoMensalService;

    @GetMapping
    public ResponseEntity<List<ConsumoUnico>> listarConsumosUnicos() {
        List<ConsumoUnico> listaConsumoUnico = consumoUnicoService.consumos();
        return ResponseEntity.ok(listaConsumoUnico);
    }

    @GetMapping("/consumo-mensal/{id}")
    public ResponseEntity<List<ConsumoUnico>> listarConsumosUnicosPorConsumoMensalId(@PathVariable Long id) {
        List<ConsumoUnico> consumoUnicos = consumoUnicoService.consumosUnicosPorConsumoMensalId(id);
        return ResponseEntity.ok(consumoUnicos);
    }

    @PostMapping("/calcular-consumo-mensal/{id}")
    public ResponseEntity<ConsumoMensal> calcularConsumoMensal(@PathVariable Long id) {
        Double kilowattsHoraTotal = consumoUnicoService.calcularConsumoMensal(id);
        ConsumoMensal consumoMensal = consumoMensalService.buscarConsumoMensalPorId(id);

        consumoMensal.setKilowattsHoraTotal(kilowattsHoraTotal);
        consumoMensalService.atualizarConsumoMensal(consumoMensal);

        return ResponseEntity.ok(consumoMensal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoUnico> buscarConsumoUnicoPorId(@PathVariable Long id) {
        ConsumoUnico consumoUnico = consumoUnicoService.buscarConsumoUnicoPorId(id);
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
