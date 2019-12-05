package com.eol.web;


import com.eol.model.entity.OrdemServico;
import com.eol.model.entity.User;
import com.eol.repository.EnderecoRepositorio;
import com.eol.repository.OrdemServicoRepositorio;
import com.eol.security.UserPrincipal;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@Log4j2
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepositorio repoOs;

    @Autowired
    private EnderecoRepositorio repoEnd;

    @ModelAttribute
    public OrdemServico ordemServico() { return new OrdemServico(); }

    @GetMapping
    public String exibir() { return "os-form"; }

    @PostMapping
    public String criaOrdemServico(OrdemServico os, @AuthenticationPrincipal UserPrincipal usuario) {
        log.info("method=criaOrdemServico, os={}, usuario={}", os, usuario);

        User user = User.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .password(usuario.getPassword())
                .phone(usuario.getPhone())
                .build();

        os.setDataCriacao(LocalDate.now());
        os.setUsuario(user);

        repoEnd.save(os.getEndereco());
        repoOs.save(os);

        return "os-criada";
    }

}
