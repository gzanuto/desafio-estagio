package service;

import model.Curso;
import model.Opcao;
import model.Pergunta;
import model.Resposta;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Apresentacao {


    private Reader reader = new Reader();

    public Apresentacao() {

    }

    public void apresentarDados() {

        List<Pergunta> listPerguntas = reader.readPergunta();
        List<Resposta> listRespostas = reader.readResposta();
        List<Opcao> listOpcoes = reader.readOpcao();
        Set<Curso> cursos = new HashSet<>();

        for (Pergunta p : listPerguntas) {
            Curso curso = new Curso(p.getCursocode(), p.getCursoname());
            cursos.add(curso);
        }

        System.out.println(cursos);

        Set<String> opcoesDetalhes = new HashSet<>();

        for (Curso c: cursos) {
            for (Pergunta p : listPerguntas) {
                if(p.getCursocode().equals(c.getCodigo())) {
                    c.getListPerguntas().add(p.getPerguntacode());
                }
                for (Opcao o: listOpcoes) {
                    if (o.getCodeperg() == p.getPerguntacode()) {
                        for (Resposta r: listRespostas) {
                            if (r.getPergcode() == o.getCodeperg()) {
//                            System.out.println(o.getOpcaomarcada());
//                            System.out.println(r.getOpcaocode());
                                if (o.getOpcaomarcada() == r.getOpcaocode()) {
                                    p.getOpcoesRespondidas().add(o.getOpcaomarcada());
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cursos);
        System.out.println(listPerguntas);
    }
}
