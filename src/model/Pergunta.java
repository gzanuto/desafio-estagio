package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pergunta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String cursoCodigo;
    private String cursoNome;
    private int perguntaCodigo;
    private String perguntaDesc;
    private List <Opcao> opcoesRespondidas = new ArrayList<>();

    public Pergunta(String cursoCodigo, String cursoNome, int perguntaCodigo, String perguntaDesc) {
        super();
        this.cursoCodigo = cursoCodigo;
        this.cursoNome = cursoNome;
        this.perguntaCodigo = perguntaCodigo;
        this.perguntaDesc = perguntaDesc;
    }

    public String getCursoCodigo() {
        return cursoCodigo;
    }

    public void setCursoCodigo(String cursoCodigo) {
        this.cursoCodigo = cursoCodigo;
    }

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public int getPerguntaCodigo() {
        return perguntaCodigo;
    }

    public void setPerguntaCodigo(int perguntaCodigo) {
        this.perguntaCodigo = perguntaCodigo;
    }

    public String getPerguntaDesc() {
        return perguntaDesc;
    }

    public void setPerguntaDesc(String perguntaDesc) {
        this.perguntaDesc = perguntaDesc;
    }

    public List<Opcao> getOpcoesRespondidas() {
        return opcoesRespondidas;
    }

    public void setOpcoesRespondidas(List<Opcao> opcoesRespondidas) {
        this.opcoesRespondidas = opcoesRespondidas;
    }

    @Override
    public String toString() {
        return "Código do curso: " + cursoCodigo + ". \n" +
                "Nome do curso: " + cursoNome + ". \n" +
                "Código da pergunta: " + perguntaCodigo + ". \n" +
                "Descrição da pergunta: " + perguntaDesc + ". \n" +
                "Lista de respostas: " + opcoesRespondidas;
    }
}