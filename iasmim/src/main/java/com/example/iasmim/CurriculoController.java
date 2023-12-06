package com.example.iasmim;

import com.example.iasmim.Curriculo;
import com.example.iasmim.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import java.util.List;

@RestController
public class CurriculoController {
    
    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public ResponseEntity<List<Curriculo>> listarCurriculos() {
        List<Curriculo> curriculos = curriculoService.listarCurriculos();
        return ResponseEntity.ok(curriculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> buscarCurriculo(@PathVariable Long id) {
        Curriculo curriculo = curriculoService.buscarCurriculo(id);
        return ResponseEntity.ok(curriculo);
    }

    @PostMapping
    public ResponseEntity<Curriculo> cadastrarCurriculo(@RequestBody Curriculo curriculo) {
        Curriculo novoCurriculo = curriculoService.cadastrarCurriculo(curriculo);
        return ResponseEntity.ok(novoCurriculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        Curriculo curriculoAtualizado = curriculoService.atualizarCurriculo(id, curriculo);
        return ResponseEntity.ok(curriculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurriculo(@PathVariable Long id) {
        curriculoService.deletarCurriculo(id);
        return ResponseEntity.noContent().build();
    }
}