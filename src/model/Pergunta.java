package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pergunta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String cursocode;
    private String cursoname;
    private int perguntacode;
    private String perguntadesc;
    private List <String> opcoesRespondidas = new ArrayList<>();

    public Pergunta(String cursocode, String cursoname, int perguntacode, String perguntadesc) {
        super();
        this.cursocode = cursocode;
        this.cursoname = cursoname;
        this.perguntacode = perguntacode;
        this.perguntadesc = perguntadesc;
    }

    public String getCursocode() {
        return cursocode;
    }

    public void setCursocode(String cursocode) {
        this.cursocode = cursocode;
    }

    public String getCursoname() {
        return cursoname;
    }

    public void setCursoname(String cursoname) {
        this.cursoname = cursoname;
    }

    public int getPerguntacode() {
        return perguntacode;
    }

    public void setPerguntacode(int perguntacode) {
        this.perguntacode = perguntacode;
    }

    public String getPerguntadesc() {
        return perguntadesc;
    }

    public void setPerguntadesc(String perguntadesc) {
        this.perguntadesc = perguntadesc;
    }

    public List<String> getOpcoesRespondidas() {
        return opcoesRespondidas;
    }

    public void setOpcoesRespondidas(List<String> opcoesRespondidas) {
        this.opcoesRespondidas = opcoesRespondidas;
    }

    @Override
    public String toString() {
        return "Código do curso: " + cursocode + ". \n" +
                "Nome do curso: " + cursoname + ". \n" +
                "Código da pergunta: " + perguntacode + ". \n" +
                "Descrição da pergunta: " + perguntadesc + ". \n" +
                "Lista de respostas: " + opcoesRespondidas;
    }
}