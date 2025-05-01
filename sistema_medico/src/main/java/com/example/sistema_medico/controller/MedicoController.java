package com.example.sistema_medico.controller;


import com.example.sistema_medico.model.Medico;
import com.example.sistema_medico.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Medico> salvarMedico(@RequestBody Medico medico){
        Medico salvarMedico = medicoService.medicoSave(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvarMedico);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Medico>> listarMedico(){
        List<Medico> medicos = medicoService.listarMedicos();
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarMedicoId(@PathVariable Long id){
        Medico medico = medicoService.buscarMedicoId(id);
        return ResponseEntity.ok(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizarMedico(@PathVariable Long id, @RequestBody Medico medico){
        medico.setId(id);
        Medico medicoAtualizado = medicoService.atualizarMedico(medico);
        return ResponseEntity.ok(medicoAtualizado);
    }


}

