package med.voll.api.consulta;

import med.voll.api.dto.DadosCadastroConsulta;
import med.voll.api.dto.ValidacaoException;
import med.voll.api.repository.ConsultaRepository;

public class ValidadorMedicoComConsulta {

    private ConsultaRepository repository;

    public void validar(DadosCadastroConsulta dados) {
        var medicoPossuiOutraConsulta = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsulta) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }

    }
}
