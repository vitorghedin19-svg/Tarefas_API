package br.com.senac.controllers;

import br.com.senac.dtos.TarefaDTO;
import br.com.senac.dtos.TarefaFiltroDTO;
import br.com.senac.entidades.Tarefa;
import br.com.senac.services.TarefaService;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/listar")
    public List<Tarefa> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) LocalDate dataInicio
    ) {

        TarefaFiltroDTO filtro = new TarefaFiltroDTO(
                nome,
                null,
                dataInicio,
                null,
                null
        );

        return tarefaService.listar(filtro);
    }

    @GetMapping("/listar/{id}")
    public Tarefa listarById(
            @PathVariable Long id
    ) {
        return tarefaService.listarById(id);
    }

    @PostMapping("/criar")
    public Tarefa criar(
            @RequestBody TarefaDTO tarefaDTO
    ) {
        return tarefaService.criar(tarefaDTO);
    }

    @PutMapping("/atualizar/{id}")
    public Tarefa atualizar(
            @PathVariable Long id,
            @RequestBody TarefaDTO tarefaDTO
    ) {
        return tarefaService.atualizar(id, tarefaDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        tarefaService.deletar(id);
    }
}