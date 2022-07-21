package service;

import model.Opcao;
import model.Pergunta;
import model.Resposta;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_PERGUNTAS, StandardCharsets.UTF_8))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vectPerg = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                String cursoCode = vectPerg[0];
                String cursoName = vectPerg[1];
                int perguntaCode = Integer.parseInt(vectPerg[2]);
                String perguntaDesc = vectPerg[3];

                Pergunta perg = new Pergunta(cursoCode, cursoName, perguntaCode, perguntaDesc);
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

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_RESPOSTAS, StandardCharsets.UTF_8))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vectResp = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                String dia = vectResp[0];
                int pergCode = Integer.parseInt(vectResp[1]);
                String matricula = vectResp[2];
                String cursoAluno = vectResp[3];
                String opcaoCode = vectResp[4];

                Resposta resp = new Resposta(dia, pergCode, matricula, cursoAluno, opcaoCode);
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

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_OPCOES, StandardCharsets.UTF_8))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vectOpt = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                int codePerg = Integer.parseInt(vectOpt[0]);
                String opcaoMarcada = vectOpt[1];
                String opcaoDesc = vectOpt[2];


                Opcao opc = new Opcao(codePerg, opcaoMarcada, opcaoDesc);
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

