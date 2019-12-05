package com.eol.controller;

import com.eol.exception.ResourceNotFoundException;
import com.eol.model.entity.OrdemServico;
import com.eol.model.entity.User;
import com.eol.repository.OrdemServicoRepositorio;
import com.eol.security.UserPrincipal;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@Log4j2
@RestController
@RequestMapping("/api/ordem-servico")
public class OrdemServicoApiController {

    @Autowired
    private OrdemServicoRepositorio ordemServicoRepositorio;

    @GetMapping
    public List<OrdemServico> findAllNotStarted() {
        return ordemServicoRepositorio.findAllNotStarted();
    }

    @PutMapping("/atribuir/{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Long id, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        log.info("method=update, id={}", id);
        OrdemServico ordemServico = ordemServicoRepositorio.findById(id).orElseThrow(ResourceNotFoundException::new);
        if (ordemServico.getDataAtribuicao() == null &&
                ordemServico.getInstalador() == null &&
                ordemServico.getDataFinalizacao() == null
        ) {

            User user = User.builder()
                    .id(userPrincipal.getId())
                    .username(userPrincipal.getUsername())
                    .email(userPrincipal.getEmail())
                    .password(userPrincipal.getPassword())
                    .phone(userPrincipal.getPhone())
                    .build();

            ordemServico.setDataAtribuicao(LocalDate.now());
            ordemServico.setInstalador(user);
            ordemServicoRepositorio.save(ordemServico);
        }

    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void close(@PathVariable Long id) {
        log.info("method=close, id={}", id);
        OrdemServico ordemServico = ordemServicoRepositorio.findById(id).orElseThrow(ResourceNotFoundException::new);

        if (ordemServico.getInstalador() != null &&
                ordemServico.getDataAtribuicao() != null &&
                ordemServico.getDataFinalizacao() == null
        ) {
            ordemServico.setDataFinalizacao(LocalDate.now());
        }
    }

}
