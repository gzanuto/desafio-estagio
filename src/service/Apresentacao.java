package service;

import model.Perguntas;

import java.util.List;

public class Apresentacao {



    private Reader reader = new Reader();

    public Apresentacao() {

    }

    public void apresentarDados() {

        List<Perguntas> listPerguntas = reader.readPergunta();

        for (Perguntas p: listPerguntas) {
            System.out.println(p);
        }
    }

}
