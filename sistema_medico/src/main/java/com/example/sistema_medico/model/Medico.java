package com.example.sistema_medico.model;

import com.example.sistema_medico.enums.EspecialidadeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "crm", nullable = false, unique = true)
    private String crm;

    @Column(name= "email", nullable = false)
    private String email;

    @Column(name= "telefone")
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade", nullable = false)
    private EspecialidadeEnum especialidade;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Consulta> consultas;
}
