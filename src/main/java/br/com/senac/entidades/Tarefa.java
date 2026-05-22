package br.com.senac.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private LocalDate dataInicio;

    private LocalDate dataFinal;

    @Column(nullable = false)
    private String autor;

    public Long getId() {return id;}

    public String getNome() {return nome;}

    public String getDescricao() {return descricao;}

    public LocalDate getDataInicio() {return dataInicio;}

    public LocalDate getDataFinal() {return dataFinal;}

    public String getAutor() {return autor;}

    public void setId(Long id) {this.id = id;}

    public void setNome(String nome) {this.nome = nome;}

    public void setDescricao(String descricao) {this.descricao = descricao;    }

    public void setDataInicio(LocalDate dataInicio) {this.dataInicio = dataInicio;}

    public void setDataFinal(LocalDate dataFinal) {this.dataFinal = dataFinal;}

    public void setAutor(String autor) {this.autor = autor;}
}
