package service;

import model.*;

import java.util.*;

public class Apresentacao {


    private Reader reader = new Reader();

    public Apresentacao() {

    }

    public void apresentarDados() {

        List<Pergunta> listPerguntas = reader.readPergunta();
        List<Resposta> listRespostas = reader.readResposta();
        List<Opcao> listOpcoes = reader.readOpcao();

        Set<Curso> cursos = getCursos(listPerguntas);

        for(Curso c : cursos) {

            c.preencherPerguntas(listPerguntas);

            System.out.println(c.getCodigo() + " - " + c.getNome());
            System.out.println("\n" + "Perguntas:");
            for(Pergunta p : c.getListPerguntas()){

                p.incluirRespostasNasPerguntas(listRespostas, listOpcoes);
                HashMap<Integer, HashMap<String, Double>> porcentagensRespostasPerguntasPorCurso = c.obterPorcentagens();
                System.out.printf("\n" + p.getPerguntaCodigo() + " - " + p.getPerguntaDesc() + "\n");
                System.out.println("\nTotal de entrevistados: " + p.getOpcoesRespondidas().size());
                int respostasCurso = 0;
                for (Aluno aluno: p.getAlunosParticipantes()) {
                    if(aluno.getCursoCodigo().equals(c.getCodigo())) {
                        respostasCurso++;
                    }
                }
                int respostasOutrosCursos = p.getOpcoesRespondidas().size() - respostasCurso;
                System.out.println("Total de entrevistados do curso: " + respostasCurso);
                System.out.println("Total de entrevistados de outros cursos: " + respostasOutrosCursos);
                System.out.println("\nResultado" + " | Porcentagem");
                HashMap<String, Double> porcentagemOpcaoMarcada = porcentagensRespostasPerguntasPorCurso.get(p.getPerguntaCodigo());

                for(String opcaoMarcada : porcentagemOpcaoMarcada.keySet()) {
                    for(Opcao o : listOpcoes){
                        int countChar = 0;
                        if(o.getPerguntaCodigo() == p.getPerguntaCodigo() && o.getOpcaoMarcada().equals(opcaoMarcada)){
                            if(countChar < o.getOpcaoDesc().length()) {

                                countChar = o.getOpcaoDesc().length();
                            }

                            String resultadoCabecalho = "Resultado" + " ".repeat(countChar);
                            String resultadoPorcentagens = o.getOpcaoMarcada() + " - " + o.getOpcaoDesc();

                            System.out.println(opcaoMarcada + " - " + o.getOpcaoDesc()
                                    + " ".repeat(resultadoCabecalho.length() - resultadoPorcentagens.length()) + "| " + porcentagem(porcentagemOpcaoMarcada.get(opcaoMarcada))
                            );
                        }
                    }

                    if(opcaoMarcada.equals("Não Respondida")) {
                        System.out.println(opcaoMarcada
                                + " | " + porcentagem(porcentagemOpcaoMarcada.get(opcaoMarcada))
                                + "\n"
                        );
                    }

                }
            }
            System.out.printf("--------------------------------------------------------------------------\n");
        }
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