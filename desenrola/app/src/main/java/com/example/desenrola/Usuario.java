package com.example.desenrola;

import java.util.regex.Pattern;

public class Usuario {
    private String nome;
    private String senha;
    private String nivel;
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{10,}$";
    private static final Pattern PATTERN = Pattern.compile(PASSWORD_REGEX);

    public Usuario(String nome, String senha, String nivel) {
        this.nome = nome;
        this.senha = senha;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void trocarSenha(String novaSenha) {
        if (novaSenha != null && PATTERN.matcher(novaSenha).matches()) {
            this.senha = novaSenha;
            System.out.println("Senha modificada com sucesso!");
        } else {
            System.out.println("Senha inválida! A senha deve ter no mínimo 10 caracteres, " +
                    "contendo uma letra maiúscula, uma minúscula e um número.");
        }
    }

    public void verificarAdm() {
        if (this.nivel.equals("adm")) {
            System.out.println("É administrador");
        } else {
            System.out.println("Não é administrador");
        }
    }
}
