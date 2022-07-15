package service;

import model.Perguntas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private String CAMINHO_PERGUNTAS = "resources/perguntas.csv";
    private String CAMINHO_RESPOSTAS = "resources/respostas.csv";
    private String CAMINHO_OPCOES = "resources/opcoes.csv";

    public Reader() {
    }

    public List<Perguntas> readPergunta() {

        // Gerando lista de PERGUNTAS

        List<Perguntas> list = new ArrayList<Perguntas>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_PERGUNTAS))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vectperg = line.split(",");
                String cursocode = vectperg[0];
                String cursoname = vectperg[1];
                int perguntacode = Integer.parseInt(vectperg[2]);
                String perguntadesc = vectperg[3];

                Perguntas perg = new Perguntas(cursocode, cursoname, perguntacode, perguntadesc);
                list.add(perg);

                line = br.readLine();
            }

        }

        catch (IOException e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

//    public List<Respostas> readResposta {
//
//    }
}
