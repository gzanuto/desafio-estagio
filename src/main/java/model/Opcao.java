package model;

import java.io.Serial;
import java.io.Serializable;

public class Opcao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int perguntaCodigo;
    private String opcaoCodigo;
    private String opcaoDesc;

    public Opcao(int perguntaCodigo, String opcaoCodigo, String opcaoDesc) {

        this.perguntaCodigo = perguntaCodigo;
        this.opcaoCodigo = opcaoCodigo;
        this.opcaoDesc = opcaoDesc;
    }
    public Opcao(int perguntaCodigo, String opcaoCodigo) {

        this.perguntaCodigo = perguntaCodigo;
        this.opcaoCodigo = opcaoCodigo;
    }

    public int getPerguntaCodigo() {
        return perguntaCodigo;
    }

    public void setPerguntaCodigo(int perguntaCodigo) {
        this.perguntaCodigo = perguntaCodigo;
    }

    public String getOpcaoCodigo() {
        return opcaoCodigo;
    }

    public void setOpcaoCodigo(String opcaoCodigo) {
        this.opcaoCodigo = opcaoCodigo;
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
                "Opcão escolhida: " + opcaoCodigo + ". " +
                "Descrição da opção: " + opcaoDesc + ". ";
    }

}
