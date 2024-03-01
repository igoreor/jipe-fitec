package br.upe.ecoenergy.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "consumo_mensal")
public class ConsumoMensal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private Double kilowattsHoraTotal;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
