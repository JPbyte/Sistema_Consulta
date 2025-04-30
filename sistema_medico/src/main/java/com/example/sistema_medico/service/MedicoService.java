package com.example.sistema_medico.service;

import com.example.sistema_medico.model.Medico;
import com.example.sistema_medico.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public Medico medicoSave(Medico medico) {
        return medicoRepository.save(medico);
    }
}
