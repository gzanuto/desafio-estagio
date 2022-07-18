package model;

import java.io.Serial;
import java.io.Serializable;

public class Opcao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int codeperg;
    private String opcaomarcada;
    private String opcaodesc;

    public Opcao(int codeperg, String opcaomarcada, String opcaodesc) {

        this.codeperg = codeperg;
        this.opcaomarcada = opcaomarcada;
        this.opcaodesc = opcaodesc;
    }

    public int getCodeperg() {
        return codeperg;
    }

    public void setCodeperg(int codeperg) {
        this.codeperg = codeperg;
    }

    public String getOpcaomarcada() {
        return opcaomarcada;
    }

    public void setOpcaomarcada(String opcaomarcada) {
        this.opcaomarcada = opcaomarcada;
    }

    public String getOpcaodesc() {
        return opcaodesc;
    }

    public void setOpcaodesc(String opcaodesc) {
        this.opcaodesc = opcaodesc;
    }

    @Override
    public String toString() {
        return  "Código da pergunta: " + codeperg + ". " +
                "Opcão escolhida: " + opcaomarcada + ". " +
                "Descrição da opção: " + opcaodesc + ". ";
    }
}
