package com.eol.model.entity;

import com.eol.model.Plano;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Plano plano;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instalador_id")
    private User instalador;

    @CreationTimestamp
    private LocalDate dataCriacao;

    private LocalDate dataAtribuicao;

    private LocalDate dataFinalizacao;

    private Boolean dentroPrazo;

    @Override
    public String toString() {
        return "{\"OrdemServico\":{"
                + "\"id\":\"" + id + "\""
                + ", \"plano\":\"" + plano + "\""
                + ", \"endereco\":" + endereco
                + ", \"DataCriacao\":" + dataCriacao
                + ", \"DataAtribuicao\":" + dataAtribuicao
                + ", \"DataFinalizacao\":" + dataFinalizacao
                + "}}";
    }
}
