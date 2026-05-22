package br.com.senac.services;

import br.com.senac.dtos.TarefaDTO;
import br.com.senac.dtos.TarefaFiltroDTO;
import br.com.senac.entidades.Tarefa;
import br.com.senac.repositorios.TarefaRepositorio;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private TarefaRepositorio tarefaRepositorio;

    public TarefaService(TarefaRepositorio tarefaRepositorio) {
        this.tarefaRepositorio = tarefaRepositorio;
    }

    public List<Tarefa> listar(TarefaFiltroDTO filtro) {

        if (filtro.getNome() != null) {
            return tarefaRepositorio.findByNomeContaining(
                    filtro.getNome()
            );
        }

        if (filtro.getDataInicio() != null) {
            return tarefaRepositorio.finByDataInicio(
                    filtro.getDataInicio()
            );
        }

        return tarefaRepositorio.findAll();
    }

    public Tarefa criar(TarefaDTO tarefas) {Tarefa tarefa = this.tarefaDTOParaTarefa(tarefas);

        return tarefaRepositorio.save(tarefa);
    }

    public Tarefa atualizar(
            Long id,
            TarefaDTO tarefaDTO
    ) {

        if (tarefaRepositorio.existsById(id)) {

            Tarefa tarefa =
                    this.tarefaDTOParaTarefa(tarefaDTO);

            tarefa.setId(id);

            return tarefaRepositorio.save(tarefa);
        }

        throw new RuntimeException("Tarefa não encontrada");
    }

    public void deletar(Long id) {

        if (tarefaRepositorio.existsById(id)) {
            tarefaRepositorio.deleteById(id);
            return;
        }

        throw new RuntimeException("Tarefa não encontrada");
    }

    public Tarefa listarById(Long id) {

        Optional<Tarefa> retorno =
                tarefaRepositorio.findById(id);

        if (retorno.isPresent()) {
            return retorno.get();
        }

        throw new RuntimeException("Tarefa não encontrada");
    }

    private Tarefa tarefaDTOParaTarefa(
            TarefaDTO entrada
    ) {

        Tarefa saida = new Tarefa();

        saida.setNome(entrada.getNome());
        saida.setDescricao(entrada.getDescricao());
        saida.setDataInicio(entrada.getDataInicio());
        saida.setDataFinal(entrada.getDataFinal());
        saida.setAutor(entrada.getAutor());

        return saida;
    }
}