package model;

import java.io.Serial;
import java.io.Serializable;

public class Resposta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String dia;
    private int pergcode;
    private String matricula;
    private String cursoaluno;
    private String opcaocode;

    public Resposta(String dia, int pergcode, String matricula, String cursoaluno, String opcaocode) {

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
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
        return "Dia da prova: " + dia + ". \n" +
                "Código da pergunta: " + pergcode + ". \n" +
                "Matrícula do aluno: "  + matricula + ". \n" +
                "Curso do Aluno: " + cursoaluno + ". \n" +
                "Opção selecionada: " + opcaocode + ". ";
    }
}