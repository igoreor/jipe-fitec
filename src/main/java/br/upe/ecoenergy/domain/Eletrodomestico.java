package br.upe.ecoenergy.domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Eletrodomestico")
public class Eletrodomestico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double potencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
