package br.upe.ecoenergy.controller;

import br.upe.ecoenergy.domain.ConsumoMensal;
import br.upe.ecoenergy.service.ConsumoMensalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumos-mensais")
@RequiredArgsConstructor
public class ConsumoMensalController {

    private final ConsumoMensalService consumoMensalService;

    @GetMapping
    public ResponseEntity<List<ConsumoMensal>> listarConsumosMensais() {
        List<ConsumoMensal> consumosMensais = consumoMensalService.consumosMensais();
        return ResponseEntity.ok(consumosMensais);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<ConsumoMensal>> listarConsumosMensaisPorUsuarioId(@PathVariable String id) {
        List<ConsumoMensal> consumoMensais = consumoMensalService.consumoMensaisPorUsuarioId(id);
        return ResponseEntity.ok(consumoMensais);
    }

    @GetMapping("/usuario/{id}/{mes}")
    public ResponseEntity<List<ConsumoMensal>> listarConsumosMensaisPorUsuarioIdEMes(@PathVariable String id, @PathVariable String mes) {
        List<ConsumoMensal> consumosMensais = consumoMensalService.consumoMensaisPorUsuarioIdEMes(id, mes);
        return ResponseEntity.ok(consumosMensais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoMensal> buscarConsumoMensalPorId(@PathVariable Long id) {
        ConsumoMensal consumoMensal = consumoMensalService.buscarConsumoMensalPorId(id);
        return ResponseEntity.ok(consumoMensal);
    }

    @PostMapping
    public ResponseEntity<ConsumoMensal> registrarConsumoMensal(@RequestBody ConsumoMensal consumoMensal) {
        ConsumoMensal novoConsumoMensal = consumoMensalService.registrarConsumoMensal(consumoMensal);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConsumoMensal);
    }

    @PutMapping
    public ResponseEntity<ConsumoMensal> atualizarConsumoMensal(@RequestBody ConsumoMensal consumoMensalAtualizado) {
        ConsumoMensal consumoMensal = consumoMensalService.atualizarConsumoMensal(consumoMensalAtualizado);
        return ResponseEntity.ok(consumoMensal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsumoMensal(@PathVariable Long id) {
        consumoMensalService.deletarConsumoMensal(id);
        return ResponseEntity.noContent().build();
    }
}
