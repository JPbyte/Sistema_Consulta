package com.example.sistema_medico.repository;

import com.example.sistema_medico.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findByCrm(String crm);
}
