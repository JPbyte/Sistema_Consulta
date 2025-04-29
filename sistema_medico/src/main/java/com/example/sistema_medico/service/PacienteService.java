package com.example.sistema_medico.service;

import com.example.sistema_medico.model.Paciente;
import com.example.sistema_medico.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public Paciente pacienteSave(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }

    public Paciente buscarPacientePorId(@RequestParam Long id){
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }
}
