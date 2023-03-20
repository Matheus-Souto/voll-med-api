package med.voll.api.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.api.dto.DadosCadastroConsulta;
import med.voll.api.dto.ValidacaoException;
import med.voll.api.repository.ConsultaRepository;

@Component
public class ValidadorPacienteSemConsulta implements ValidadorAgendamentoDeConsulta{
        
        @Autowired
        private ConsultaRepository repository;

        public void validar(DadosCadastroConsulta dados) {
            var primeiroHorario = dados.data().withHour(7);
            var ultimoHorario = dados.data().withHour(18);
            var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }


}
}
