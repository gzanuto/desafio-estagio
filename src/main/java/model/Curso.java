package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Curso {

    private List <Pergunta> listPerguntas = new ArrayList<>();
    private String codigo;
    private String nome;

    public Curso(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public HashMap<Integer, HashMap<String, Double>> obterPorcentagens() {

        HashMap<Integer, HashMap<String, Double>> perguntasPorCurso = new HashMap<>();

        for (Pergunta p : this.getListPerguntas()){
            HashMap<String, Double> porcentagensPorOpcao = new HashMap<>();
            perguntasPorCurso.put(p.getPerguntaCodigo(), porcentagensPorOpcao);
            int totalRespostas = p.getOpcoesRespondidas().size();

            Double totalOpcaoMarcada;
            for(Opcao o : p.getOpcoesRespondidas()) {

                Double porcentagemAtual = perguntasPorCurso.get(p.getPerguntaCodigo()).containsKey(o.getOpcaoCodigo()) ?
                        perguntasPorCurso.get(p.getPerguntaCodigo()).get(o.getOpcaoCodigo()) : 0.0;

                if(porcentagemAtual > 0){
                    totalOpcaoMarcada = porcentagemAtual * totalRespostas;
                    totalOpcaoMarcada ++;
                } else {
                    totalOpcaoMarcada = 1.0;
                }

                if(!perguntasPorCurso.get(p.getPerguntaCodigo()).containsKey(o.getOpcaoCodigo())){
                    perguntasPorCurso.get(p.getPerguntaCodigo()).put(o.getOpcaoCodigo(), totalOpcaoMarcada/totalRespostas);
                }
                else {
                    perguntasPorCurso.get(p.getPerguntaCodigo()).replace(o.getOpcaoCodigo(), totalOpcaoMarcada/totalRespostas);
                }
            }
        }
        return perguntasPorCurso;
    }

    public void preencherPerguntas(List<Pergunta> listPerguntas) {
        for (Pergunta p : listPerguntas) {
            if (p.getCursoCodigo().equals(this.getCodigo())) {
                this.getListPerguntas().add(p);
            }
        }
    }

    public List<Pergunta> getListPerguntas() {
        return listPerguntas;
    }

    public void setListPerguntas(List<Pergunta> listPerguntas) {
        this.listPerguntas = listPerguntas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "listPerguntas=" + listPerguntas +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public boolean equals(String codigo) {
        if (this.getCodigo() == codigo){
            return true;
        }
        return false;
    }
}
