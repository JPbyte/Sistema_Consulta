package com.example.sistema_medico.controller;


import com.example.sistema_medico.model.Medico;
import com.example.sistema_medico.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}

