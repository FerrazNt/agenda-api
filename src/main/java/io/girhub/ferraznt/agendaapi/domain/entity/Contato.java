package io.girhub.ferraznt.agendaapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

    @Id
    @Column(name ="id", updatable = false)
    @SequenceGenerator(name = "seq_id_contato", sequenceName = "contato_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_contato")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column
    private Boolean favorito;
}

