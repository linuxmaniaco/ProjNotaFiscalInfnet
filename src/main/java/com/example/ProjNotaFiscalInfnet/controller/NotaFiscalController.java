package com.example.ProjNotaFiscalInfnet.controller;

import com.example.ProjNotaFiscalInfnet.model.NotaFiscal;
import com.example.ProjNotaFiscalInfnet.service.NotaFiscalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NotaFiscalController {

    private final NotaFiscalService notaFiscalService;

    @GetMapping("/emitir/{pedidoId}")
    public ResponseEntity<?> emitir(@PathVariable String pedidoId){
        NotaFiscal notaFiscal = NotaFiscal.builder().pedidoId(pedidoId).id(new Random().nextLong()).build();
        try {
           NotaFiscal nota = notaFiscalService.emitir(notaFiscal);
           return ResponseEntity.ok().body(nota);
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getNota(@PathVariable Long id){
        NotaFiscal byId = notaFiscalService.findById(id);
        return ResponseEntity.ok(byId);
    }
}
