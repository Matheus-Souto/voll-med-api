package med.voll.api.consulta;

import java.time.Duration;
import java.time.LocalDateTime;

import med.voll.api.dto.DadosCadastroConsulta;
import med.voll.api.dto.ValidacaoException;

public class ValidadorHorarioAntecedencia {
    public void validar(DadosCadastroConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedencia mínima de 30 minutos");
        }
    }
}
