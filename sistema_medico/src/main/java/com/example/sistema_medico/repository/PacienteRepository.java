package com.example.sistema_medico.repository;

import com.example.sistema_medico.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNome(String nome);
}
