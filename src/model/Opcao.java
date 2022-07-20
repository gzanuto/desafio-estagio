package model;

import java.io.Serial;
import java.io.Serializable;

public class Opcao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int perguntaCodigo;
    private String opcaoMarcada;
    private String opcaoDesc;

    public Opcao(int perguntaCodigo, String opcaoMarcada, String opcaoDesc) {

        this.perguntaCodigo = perguntaCodigo;
        this.opcaoMarcada = opcaoMarcada;
        this.opcaoDesc = opcaoDesc;
    }
    public Opcao(int perguntaCodigo, String opcaoMarcada) {

        this.perguntaCodigo = perguntaCodigo;
        this.opcaoMarcada = opcaoMarcada;
    }

    public int getPerguntaCodigo() {
        return perguntaCodigo;
    }

    public void setPerguntaCodigo(int perguntaCodigo) {
        this.perguntaCodigo = perguntaCodigo;
    }

    public String getOpcaoMarcada() {
        return opcaoMarcada;
    }

    public void setOpcaoMarcada(String opcaoMarcada) {
        this.opcaoMarcada = opcaoMarcada;
    }

    public String getOpcaoDesc() {
        return opcaoDesc;
    }

    public void setOpcaoDesc(String opcaoDesc) {
        this.opcaoDesc = opcaoDesc;
    }

    @Override
    public String toString() {
        return  "Código da pergunta: " + perguntaCodigo + ". " +
                "Opcão escolhida: " + opcaoMarcada + ". " +
                "Descrição da opção: " + opcaoDesc + ". ";
    }

}
