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
        preencherPerguntasDeCursos(cursos, listPerguntas);
        incluirRespostasNasPerguntas(listRespostas, cursos, listOpcoes);

        for(Curso c : cursos) {
            HashMap<Integer, HashMap<String, Double>> porcentagensRespostasPerguntasPorCurso = obterPorcentagens(c);
            System.out.println(c.getCodigo() + " - " + c.getNome());
            System.out.println("\n" + "Perguntas:");
            for(Pergunta p : c.getListPerguntas()){
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
//                                    + "\n"
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

    private HashMap<Integer, HashMap<String, Double>> obterPorcentagens(Curso curso) {

        HashMap<Integer, HashMap<String, Double>> perguntasPorCurso = new HashMap<>();

        for (Pergunta p : curso.getListPerguntas()){
            HashMap<String, Double> porcentagensPorOpcao = new HashMap<>();
            perguntasPorCurso.put(p.getPerguntaCodigo(), porcentagensPorOpcao);
            int totalRespostas = p.getOpcoesRespondidas().size();

            Double totalOpcaoMarcada;
            for(Opcao o : p.getOpcoesRespondidas()) {

                Double porcentagemAtual = perguntasPorCurso.get(p.getPerguntaCodigo()).containsKey(o.getOpcaoMarcada()) ?
                        perguntasPorCurso.get(p.getPerguntaCodigo()).get(o.getOpcaoMarcada()) : 0.0;

                if(porcentagemAtual > 0){
                    totalOpcaoMarcada = porcentagemAtual * totalRespostas;
                    totalOpcaoMarcada ++;
                } else {
                    totalOpcaoMarcada = 1.0;
                }

                if(!perguntasPorCurso.get(p.getPerguntaCodigo()).containsKey(o.getOpcaoMarcada())){
                    perguntasPorCurso.get(p.getPerguntaCodigo()).put(o.getOpcaoMarcada(), totalOpcaoMarcada/totalRespostas);
                }
                else {
                    perguntasPorCurso.get(p.getPerguntaCodigo()).replace(o.getOpcaoMarcada(), totalOpcaoMarcada/totalRespostas);
                }
            }
        }
        return perguntasPorCurso;
    }

    private void incluirRespostasNasPerguntas(List<Resposta> listRespostas, Set<Curso> cursos, List<Opcao> listOpcoes) {
        for (Curso c : cursos) {
            for(Pergunta p : c.getListPerguntas()) {
                for(Resposta r : listRespostas){


                    if(r.getOpcaoCodigo().equals("Não Respondida") && r.getPerguntaCodigo() == p.getPerguntaCodigo()) {
                        p.getOpcoesRespondidas().add(new Opcao(p.getPerguntaCodigo(), r.getOpcaoCodigo()));
                    }
                    if (r.getPerguntaCodigo() == p.getPerguntaCodigo()){
                        p.getAlunosParticipantes().add(new Aluno(r.getMatricula(), r.getCursoAluno()));
                        for(Opcao o: listOpcoes) {
                            if(o.getPerguntaCodigo() == r.getPerguntaCodigo() && o.getOpcaoMarcada().equals(r.getOpcaoCodigo())) {
                                p.getOpcoesRespondidas().add(o);
                            }
                        }
                    }
                }
            }
        }
    }

    private void preencherPerguntasDeCursos(Set<Curso> cursos, List<Pergunta> listPerguntas) {
        for (Curso c: cursos) {
            for (Pergunta p : listPerguntas) {
                if (p.getCursoCodigo().equals(c.getCodigo())) {
                    c.getListPerguntas().add(p);
                }
            }
        }
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