package com.eol.repository;

import com.eol.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServicoPorInstalador {

    private User instalador;
    private Long quantidade;

}
