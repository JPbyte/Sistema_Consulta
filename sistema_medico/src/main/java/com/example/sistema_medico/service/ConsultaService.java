package com.example.sistema_medico.service;

import com.example.sistema_medico.model.Consulta;
import com.example.sistema_medico.model.Medico;
import com.example.sistema_medico.model.Paciente;
import com.example.sistema_medico.repository.ConsultaRepository;
import com.example.sistema_medico.repository.MedicoRepository;
import com.example.sistema_medico.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public Consulta agendarConsulta(Consulta consulta) {

        Paciente paciente = pacienteRepository.findById(consulta.getPaciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(consulta.getMedico().getId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public void cancelarConsulta(Long id) {
        Consulta consulta = buscarPorId(id);
        consultaRepository.delete(consulta);
    }
}
