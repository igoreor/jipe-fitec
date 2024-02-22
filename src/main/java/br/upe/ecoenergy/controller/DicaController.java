package br.upe.ecoenergy.controller;

import br.upe.ecoenergy.domain.Dica;
import br.upe.ecoenergy.service.DicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dicas")
@RequiredArgsConstructor
public class DicaController {

    private final DicaService dicaService;

    @GetMapping
    public ResponseEntity<List<Dica>> listarDicas() {
        List<Dica> dicas = dicaService.listarDicas();
        return ResponseEntity.ok(dicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dica> buscarDicaPorId(@PathVariable Long id) {
        Dica dica = dicaService.buscarDicaPorId(id);
        return ResponseEntity.ok(dica);
    }

    @PostMapping
    public ResponseEntity<Dica> adicionarDica(@RequestBody Dica dica) {
        Dica novaDica = dicaService.adicionarDica(dica);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dica> atualizarDica(@PathVariable Long id, @RequestBody Dica dicaAtualizada) {
        Dica dica = dicaService.atualizarDica(id, dicaAtualizada);
        return ResponseEntity.ok(dica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDica(@PathVariable Long id) {
        dicaService.deletarDica(id);
        return ResponseEntity.noContent().build();
    }
}
