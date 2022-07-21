package model;

public class Resposta {

    private String dia;
    private int perguntaCodigo;
    private String matricula;
    private String cursoAluno;
    private String opcaoCodigo;

    public Resposta(String dia, int perguntaCodigo, String matricula, String cursoAluno, String opcaoCodigo) {

        this.dia = dia;
        this.perguntaCodigo = perguntaCodigo;
        this.matricula = matricula;
        this.cursoAluno = cursoAluno;
        this.opcaoCodigo = opcaoCodigo;

    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getPerguntaCodigo() {
        return perguntaCodigo;
    }

    public void setPerguntaCodigo(int perguntaCodigo) {
        this.perguntaCodigo = perguntaCodigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCursoAluno() {
        return cursoAluno;
    }

    public void setCursoAluno(String cursoAluno) {
        this.cursoAluno = cursoAluno;
    }

    public String getOpcaoCodigo() {
        return opcaoCodigo;
    }

    public void setOpcaoCodigo(String opcaoCodigo) {
        this.opcaoCodigo = opcaoCodigo;
    }

    @Override
    public String toString() {
        return "Dia da prova: " + dia + ". \n" +
                "Código da pergunta: " + perguntaCodigo + ". \n" +
                "Matrícula do aluno: "  + matricula + ". \n" +
                "Curso do Aluno: " + cursoAluno + ". \n" +
                "Opção selecionada: " + opcaoCodigo + ". ";
    }
}