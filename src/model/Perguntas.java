package model;

import java.io.Serial;
import java.io.Serializable;

public class Perguntas implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String cursocode;
    public String cursoname;
    public int perguntacode;
    public String perguntadesc;

    public Perguntas() {
    }

    public Perguntas(String cursocode, String cursoname, int perguntacode, String perguntadesc) {
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

    @Override
    public String toString() {
        return "Código do curso: " + cursocode + ". " +
                "Nome do curso: " + cursoname + ". " +
                "Código da pergunta: " + perguntacode + ". " +
                "Descrição da pergunta: " + perguntadesc;
    }
}