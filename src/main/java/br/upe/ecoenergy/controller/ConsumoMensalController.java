package br.upe.ecoenergy.controller;

import br.upe.ecoenergy.domain.ConsumoMensal;
import br.upe.ecoenergy.service.ConsumoMensalService;
import lombok.RequiredArgsConstructor;
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
}
