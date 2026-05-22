package br.com.senac.dtos;

import java.time.LocalDate;

public class TarefaFiltroDTO {

    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String autor;

    public TarefaFiltroDTO(
            String nome,
            String descricao,
            LocalDate dataInicio,
            LocalDate dataFinal,
            String autor) {

        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.autor = autor;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public LocalDate getDataInicio() {return dataInicio;}

    public void setDataInicio(LocalDate dataInicio) {this.dataInicio = dataInicio;}

    public LocalDate getDataFinal() {return dataFinal;}

    public void setDataFinal(LocalDate dataFinal) {this.dataFinal = dataFinal;}

    public String getAutor() {return autor;}

    public void setAutor(String autor) {this.autor = autor;}

}
