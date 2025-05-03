package com.example.sistema_medico.controller;

import com.example.sistema_medico.model.Paciente;
import com.example.sistema_medico.service.MedicoService;
import com.example.sistema_medico.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping("/cadastro")
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){
        Paciente paciente1 = pacienteService.pacienteSave(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(paciente1);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listarPacientes(){
        List<Paciente> pacientesListados = pacienteService.listarPacientes();

        return ResponseEntity.ok(pacientesListados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacienteId(@PathVariable Long id){
        Paciente paciente = pacienteService.buscarPacientePorId(id);

        return ResponseEntity.ok(paciente);
    }
}
