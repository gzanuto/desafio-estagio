package service;

import model.Curso;
import model.Opcao;
import model.Pergunta;
import model.Resposta;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        incluirRespostasNasPerguntas(listRespostas, cursos);

        for(Curso c : cursos) {
            System.out.printf(c.toString());
        }

    }

    private void incluirRespostasNasPerguntas(List<Resposta> listRespostas, Set<Curso> cursos) {

        for (Resposta r : listRespostas) {
            for(Curso c : cursos) {
                for(Pergunta p : c.getListPerguntas()){
                    if (r.getPergcode() == p.getPerguntacode()){
                        p.getOpcoesRespondidas().add(r.getOpcaocode());
                    }
                }
            }
        }
    }

    private void preencherPerguntasDeCursos(Set<Curso> cursos, List<Pergunta> listPerguntas) {
        for (Curso c: cursos) {
            for (Pergunta p : listPerguntas) {
                if (p.getCursocode().equals(c.getCodigo())) {
                    c.getListPerguntas().add(p);
                }
            }
        }

    }

    private Set<Curso> getCursos(List<Pergunta> perguntas) {
        Set<Curso> cursos = new HashSet<>();
        Set<String> cursoCodes = new HashSet<>();
        for (Pergunta p : perguntas) {
            Curso curso = new Curso(p.getCursocode(), p.getCursoname());
            if(cursos.isEmpty()  || !cursoCodes.contains(curso.getCodigo())){
                cursoCodes.add(curso.getCodigo());
                cursos.add(curso);
            }
        }
        return cursos;
    }

}