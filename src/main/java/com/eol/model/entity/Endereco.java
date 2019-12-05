package com.eol.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cidade;
    private String bairro;
    private String rua;

    @Override
    public String toString() {
        return "{\"Endereco\":{"
                + "\"id\":\"" + id + "\""
                + ", \"cidade\":\"" + cidade + "\""
                + ", \"bairro\":\"" + bairro + "\""
                + ", \"rua\":\"" + rua + "\""
                + "}}";
    }
}
