package com.example.sistema_medico.service;

import com.example.sistema_medico.model.Paciente;
import com.example.sistema_medico.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public Paciente pacienteSave(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

}
