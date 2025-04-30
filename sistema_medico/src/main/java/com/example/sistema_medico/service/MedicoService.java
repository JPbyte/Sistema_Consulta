package com.example.sistema_medico.service;

import com.example.sistema_medico.model.Medico;
import com.example.sistema_medico.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public Medico medicoSave(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listarMedicos(){
        return medicoRepository.findAll();
    }

    public Medico buscarMedicoId(Long id){
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medico não encontrado"));
    }

    public Medico atualizarMedico(Medico medico){
        Medico medicoExistente = buscarMedicoId(medico.getId());

        medicoExistente.setNome(medico.getNome());
        medicoExistente.setCrm(medico.getCrm());
        medicoExistente.setEmail(medico.getEmail());
        medicoExistente.setTelefone(medico.getTelefone());
        medicoExistente.setEspecialidade(medico.getEspecialidade());
        medicoExistente.setConsultas(medico.getConsultas());

        return medicoRepository.save(medicoExistente);
    }

    public void deletarMedico(Long id){
        Medico medico = buscarMedicoId(id);
        medicoRepository.delete(medico);
    }


}
