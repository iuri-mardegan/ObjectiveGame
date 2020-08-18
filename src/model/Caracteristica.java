package model;

import java.util.List;

public class Caracteristica {

    private String nome;
    private List<Prato> pratoList;

    public Caracteristica(String nome, List<Prato> pratoList) {
        this.nome = nome;
        this.pratoList = pratoList;
    }

    public List<Prato> getPratoList() {
        return pratoList;
    }

    public void setPratoList(List<Prato> pratoList) {
        this.pratoList = pratoList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
