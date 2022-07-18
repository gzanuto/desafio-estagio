package service;

import model.Opcao;
import model.Pergunta;
import model.Resposta;

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


    // GERANDO LISTA DE PERGUNTAS


    public List<Pergunta> readPergunta() {


        List<Pergunta> list = new ArrayList<Pergunta>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_PERGUNTAS))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vectperg = line.split(",");
                String cursocode = vectperg[0];
                String cursoname = vectperg[1];
                int perguntacode = Integer.parseInt(vectperg[2]);
                String perguntadesc = vectperg[3];

                Pergunta perg = new Pergunta(cursocode, cursoname, perguntacode, perguntadesc);
                list.add(perg);

                line = br.readLine();
            }

        }

        catch (IOException e) {
            System.out.println(e.getMessage());

        }
        return list;
    }



    // GERANDO LISTA DE RESPOSTAS



    public List<Resposta> readResposta() {

        List<Resposta> list = new ArrayList<Resposta>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_RESPOSTAS))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vectresp = line.split(",");
                String dia = vectresp[0];
                int pergcode = Integer.parseInt(vectresp[1]);
                String matricula = vectresp[2];
                String cursoaluno = vectresp[3];
                String opcaocode = vectresp[4];

                Resposta resp = new Resposta(dia, pergcode, matricula, cursoaluno, opcaocode);
                list.add(resp);

                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());

        }
        return list;
    }


    // GERANDO LISTA DE OPCOES


    public List<Opcao> readOpcao() {

        List<Opcao> list = new ArrayList<Opcao>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_OPCOES))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vectopt = line.split(",");
                int codeperg = Integer.parseInt(vectopt[0]);
                String opcaomarcada = vectopt[1];
                String opcaodesc = vectopt[2];


                Opcao opc = new Opcao(codeperg, opcaomarcada, opcaodesc);
                list.add(opc);

                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());

        }
        return list;

    }

}

