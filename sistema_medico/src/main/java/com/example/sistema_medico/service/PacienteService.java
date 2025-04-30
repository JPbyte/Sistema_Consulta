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

    public Paciente buscarPacientePorId(Long id){
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public Paciente atualizarPaciente(Paciente paciente){
        Paciente pacienteExistente = buscarPacientePorId(paciente.getId());

        pacienteExistente.setNome(paciente.getNome());
        pacienteExistente.setCpf(paciente.getCpf());
        pacienteExistente.setEmail(paciente.getEmail());
        pacienteExistente.setTelefone(paciente.getTelefone());
        pacienteExistente.setDataNascimento(paciente.getDataNascimento());

        return pacienteRepository.save(pacienteExistente);
    }

    public void deletarPaciente(Long id){
        Paciente paciente = buscarPacientePorId(id);
        pacienteRepository.delete(paciente);
    }
}
