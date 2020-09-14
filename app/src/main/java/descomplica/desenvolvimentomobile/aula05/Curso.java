package descomplica.desenvolvimentomobile.aula05;

import java.io.Serializable;

public class Curso implements Serializable {
    private String nome;
    private String periodo;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso(String nome, String periodo, String descricao) {
        this.nome = nome;
        this.periodo = periodo;
        this.descricao = descricao;
    }
}
