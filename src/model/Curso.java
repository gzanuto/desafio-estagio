package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private List <Pergunta> listPerguntas = new ArrayList<>();
    private String codigo;
    private String nome;

    public Curso(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public List<Pergunta> getListPerguntas() {
        return listPerguntas;
    }

    public void setListPerguntas(List<Pergunta> listPerguntas) {
        this.listPerguntas = listPerguntas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "listPerguntas=" + listPerguntas +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public boolean equals(String codigo) {
        if (this.getCodigo() == codigo){
            return true;
        }
        return false;
    }
}
