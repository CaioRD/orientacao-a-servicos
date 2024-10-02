package com.example.demo.controller;

import com.example.demo.models.CurriculoModel;
import com.example.demo.service.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService curriculoService;

    @PostMapping
    public ResponseEntity<CurriculoModel> createCurriculo(@RequestBody CurriculoModel curriculo) {
        CurriculoModel createdCurriculo = curriculoService.createCurriculo(curriculo);
        return ResponseEntity.ok(createdCurriculo);
    }

    @GetMapping
    public ResponseEntity<List<CurriculoModel>> getAllCurriculos() {
        List<CurriculoModel> curriculos = curriculoService.getAllCurriculos();
        return ResponseEntity.ok(curriculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurriculoModel> getCurriculoById(@PathVariable Long id) {
        Optional<CurriculoModel> curriculo = curriculoService.getCurriculoById(id);
        return curriculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurriculoModel> updateCurriculo(@PathVariable Long id, @RequestBody CurriculoModel curriculoDetails) {
        CurriculoModel updatedCurriculo = curriculoService.updateCurriculo(id, curriculoDetails);
        if (updatedCurriculo != null) {
            return ResponseEntity.ok(updatedCurriculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculo(@PathVariable Long id) {
        curriculoService.deleteCurriculo(id);
        return ResponseEntity.noContent().build();
    }
}
