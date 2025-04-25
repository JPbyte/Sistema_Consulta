package com.example.sistema_medico.repository;

import com.example.sistema_medico.model.Consulta;
import com.example.sistema_medico.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByMedico(Medico medico);
}
