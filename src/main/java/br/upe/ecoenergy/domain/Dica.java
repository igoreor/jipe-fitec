package br.upe.ecoenergy.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dica")
public class Dica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String descricao;
}
