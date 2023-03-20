package med.voll.api.consulta;

import org.springframework.stereotype.Component;

import med.voll.api.dto.DadosCadastroConsulta;


public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosCadastroConsulta dados);
}
