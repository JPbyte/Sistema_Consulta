package com.example.sistema_medico.controller;

import com.example.sistema_medico.model.Consulta;
import com.example.sistema_medico.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;
;
    @PostMapping("/agendar")
    public ResponseEntity<Consulta> agendarConsulta(@RequestBody Consulta consulta) {
        Consulta novaConsulta = consultaService.agendarConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
    }


    @GetMapping("/listar")
    public ResponseEntity<List<Consulta>> listarConsultas() {
        List<Consulta> consultas = consultaService.listarConsultas();
        return ResponseEntity.ok(consultas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarConsultaPorId(@PathVariable Long id) {
        Consulta consulta = consultaService.buscarPorId(id);
        return ResponseEntity.ok(consulta);
    }


    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Consulta> cancelarConsulta(@PathVariable Long id) {
        Consulta consultaCancelada = consultaService.cancelarConsulta(id);
        return ResponseEntity.ok(consultaCancelada);
    }

    @PutMapping("/{id}/realizar")
    public ResponseEntity<Consulta> realizarConsulta(@PathVariable Long id) {
        Consulta consultaRealizada = consultaService.marcarComoRealizada(id);
        return ResponseEntity.ok(consultaRealizada);
    }
}
