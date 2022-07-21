package service;

import model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Apresentacao {


    private Reader reader = new Reader();

    public Apresentacao() {

    }

    public void apresentarDados() {

        try {
            List<Pergunta> listPerguntas = reader.readPergunta();
            List<Resposta> listRespostas = reader.readResposta();
            List<Opcao> listOpcoes = reader.readOpcao();

            Set<Curso> cursos = getCursos(listPerguntas);

            escreverResultado(listPerguntas, listRespostas, listOpcoes, cursos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void escreverResultado(List<Pergunta> listPerguntas, List<Resposta> listRespostas, List<Opcao> listOpcoes, Set<Curso> cursos) throws IOException {

        FileWriter fw = new FileWriter("target/resultadoEnquete.txt", StandardCharsets.UTF_8);
        PrintWriter pw = new PrintWriter(fw);

        for (Curso c : cursos) {

            c.preencherPerguntas(listPerguntas);

            pw.println(c.getCodigo() + " - " + c.getNome());
            pw.println("\n" + "Perguntas:");

            for (Pergunta p : c.getListPerguntas()) {

                p.incluirRespostasNasPerguntas(listRespostas, listOpcoes);
                HashMap<Integer, HashMap<String, Double>> porcentagensRespostasPerguntasPorCurso = c.obterPorcentagens();
                pw.println("\n" + p.getPerguntaCodigo() + " - " + p.getPerguntaDesc() + "\n");
                pw.println("\nTotal de entrevistados: " + p.getOpcoesRespondidas().size());
                int respostasCurso = 0;
                for (Aluno aluno : p.getAlunosParticipantes()) {
                    if (aluno.getCursoCodigo().equals(c.getCodigo())) {
                        respostasCurso++;
                    }
                }
                int respostasOutrosCursos = p.getOpcoesRespondidas().size() - respostasCurso;
                pw.println("Total de entrevistados do curso: " + respostasCurso);
                pw.println("Total de entrevistados de outros cursos: " + respostasOutrosCursos);
                pw.println("\nResultado" + " | Porcentagem");
                HashMap<String, Double> porcentagemOpcaoMarcada = porcentagensRespostasPerguntasPorCurso.get(p.getPerguntaCodigo());

                for (String opcaoMarcada : porcentagemOpcaoMarcada.keySet()) {
                    for (Opcao o : listOpcoes) {
                        int countChar = 0;
                        if (o.getPerguntaCodigo() == p.getPerguntaCodigo() && o.getOpcaoCodigo().equals(opcaoMarcada)) {
                            if (countChar < o.getOpcaoDesc().length()) {

                                countChar = o.getOpcaoDesc().length();
                            }

                            String resultadoCabecalho = "Resultado" + " ".repeat(countChar);
                            String resultadoPorcentagens = o.getOpcaoCodigo() + " - " + o.getOpcaoDesc();

                            pw.println(opcaoMarcada + " - " + o.getOpcaoDesc()
                                    + " ".repeat(resultadoCabecalho.length() - resultadoPorcentagens.length()) + "| " + porcentagem(porcentagemOpcaoMarcada.get(opcaoMarcada))
                            );
                        }
                    }

                    if (opcaoMarcada.equals("Não Respondida")) {
                        pw.println(opcaoMarcada
                                + " | " + porcentagem(porcentagemOpcaoMarcada.get(opcaoMarcada))
                                + "\n"
                        );
                    }
                }
            }
            pw.println("------------------------------------------------------------------------");
        }
        pw.close();
    }


    private String porcentagem(double v) {
        return String.format("%.0f%%",100*v);
    }

    private Set<Curso> getCursos(List<Pergunta> perguntas) {
        Set<Curso> cursos = new HashSet<>();
        Set<String> cursoCodes = new HashSet<>();
        for (Pergunta p : perguntas) {
            Curso curso = new Curso(p.getCursoCodigo(), p.getCursoNome());
            if(cursos.isEmpty()  || !cursoCodes.contains(curso.getCodigo())){
                cursoCodes.add(curso.getCodigo());
                cursos.add(curso);
            }
        }
        return cursos;
    }

}