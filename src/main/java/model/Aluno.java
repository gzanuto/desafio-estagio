package model;

public class Aluno {

    private String matricula;
    private String cursoCodigo;

    public Aluno(String matricula, String cursoCodigo) {
        this.matricula = matricula;
        this.cursoCodigo = cursoCodigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCursoCodigo() {
        return cursoCodigo;
    }

    public void setCursoCodigo(String cursoCodigo) {
        this.cursoCodigo = cursoCodigo;
    }
}
