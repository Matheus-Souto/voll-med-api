package med.voll.api.consulta;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import med.voll.api.dto.DadosCadastroConsulta;
import med.voll.api.dto.ValidacaoException;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamentoDeConsulta{
    public void validar(DadosCadastroConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() < 7;
        var depoisEncerramento = dataConsulta.getHour() > 18;
        if (domingo || antesDaAbertura || depoisEncerramento) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
