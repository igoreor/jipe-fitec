package br.upe.ecoenergy.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private String id;

    @Column(nullable = false)
    private String nome;

    private Double tarifa;
}
