/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Date;

/**
 *
 * @author gomes
 */
public class Usuario {

    private int idUsuario;
    private String nome;
    private String usuario;
    private String senha;
    private String perfil;
    
    public Usuario(){
        
    }

    public Usuario(int idUsuario, String nome, String usuario, String senha, String perfil) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
