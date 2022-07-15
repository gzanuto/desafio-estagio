package model;

import java.io.Serial;
import java.io.Serializable;

public class Respostas implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String dia;
    public int pergcode;
    public int matricula;
    public String cursoaluno;
    public String opcaocode;

    public Respostas(String dia, int pergcode, int matricula, String cursoaluno, String opcaocode) {

        this.dia = dia;
        this.pergcode = pergcode;
        this.matricula = matricula;
        this.cursoaluno = cursoaluno;
        this.opcaocode = opcaocode;

    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getPergcode() {
        return pergcode;
    }

    public void setPergcode(int pergcode) {
        this.pergcode = pergcode;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;

    }
    public String getCursoaluno() {
        return cursoaluno;
    }

    public void setCursoaluno(String cursoaluno) {
        this.cursoaluno = cursoaluno;
    }

    public String getOpcaocode() {
        return opcaocode;
    }

    public void setOpcaocode(String opcaocode) {
        this.opcaocode = opcaocode;
    }

    @Override
    public String toString() {
        return "Dia da prova: " + dia + ". " +
                "Código da pergunta: " + pergcode + ". " +
                "Matrícula do aluno: "  + matricula + ". " +
                "Curso do Aluno: " + cursoaluno + ". " +
                "Opção selecionada: " + opcaocode;
    }
}