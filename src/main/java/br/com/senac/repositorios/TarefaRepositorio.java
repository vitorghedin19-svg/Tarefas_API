package br.com.senac.repositorios;

import br.com.senac.entidades.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TarefaRepositorio extends JpaRepository<Tarefa, Long> {
        List<Tarefa> finByDataInicio(LocalDate DataInicio);
        List<Tarefa> findByNomeContaining(String Nome);
}
