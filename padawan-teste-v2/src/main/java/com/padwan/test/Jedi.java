package com.padwan.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * Representa um Jedi, incluindo nome, status, mentor e contagem de midichlorians.
 */
@Entity  // Anotação para indicar que a classe é uma entidade JPA
public class Jedi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id  // A anotação @Id define o campo que será usado como identificador único
    private String nome;  // Pode ser alterado para um campo numérico, como 'id' se necessário

    @Enumerated(EnumType.STRING)  // Usado para armazenar o valor do enum como uma string no banco de dados
    private Status status;

    private String mentor;
    private int midichlorians;

    /**
     * Enum para representar os diferentes níveis de status de um Jedi.
     */
    public enum Status {
        PADAWAN,
        KNIGHT,
        MASTER
    }

    /**
     * Construtor para criar um objeto Jedi.
     *
     * @param nome         Nome do Jedi.
     * @param status       Status atual do Jedi (PADAWAN, KNIGHT, MASTER).
     * @param mentor       Nome do mentor do Jedi.
     * @param midichlorians Contagem de midichlorians do Jedi (deve ser positiva).
     */
    public Jedi(String nome, Status status, String mentor, int midichlorians) {
        setNome(nome);
        setStatus(status);
        setMentor(mentor);
        setMidichlorians(midichlorians);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("O status não pode ser nulo.");
        }
        this.status = status;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        if (mentor == null || mentor.trim().isEmpty()) {
            throw new IllegalArgumentException("O mentor não pode ser vazio ou nulo.");
        }
        this.mentor = mentor;
    }

    public int getMidichlorians() {
        return midichlorians;
    }

    public void setMidichlorians(int midichlorians) {
        if (midichlorians < 0) {
            throw new IllegalArgumentException("A contagem de midichlorians deve ser positiva.");
        }
        this.midichlorians = midichlorians;
    }

    /**
     * Promove o Jedi para o status MASTER, caso ele seja um KNIGHT.
     */
    public void promoteToMaster() {
        if (this.status == Status.KNIGHT) {
            this.status = Status.MASTER;
        } else {
            throw new IllegalStateException("Apenas um Knight pode ser promovido a Master.");
        }
    }

    /**
     * Retorna uma representação textual do objeto Jedi.
     *
     * @return String representando os atributos do Jedi.
     */
    @Override
    public String toString() {
        return "Jedi{" +
                "nome='" + nome + '\'' +
                ", status=" + status +
                ", mentor='" + mentor + '\'' +
                ", midichlorians=" + midichlorians +
                '}';
    }
}



