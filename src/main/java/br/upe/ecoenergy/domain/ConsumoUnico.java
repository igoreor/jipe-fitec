package br.upe.ecoenergy.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "consumo_unico")
public class ConsumoUnico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double horasUso;


    @ManyToOne
    @JoinColumn(name = "eletrodomestico_id", nullable = false)
    private Eletrodomestico eletrodomestico;

    @ManyToOne
    @JoinColumn(name = "consumo_mensal_id", nullable = false)
    private ConsumoMensal consumoMensal;
}
