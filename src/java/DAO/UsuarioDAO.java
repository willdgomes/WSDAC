/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Usuario;
import DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomes
 */
public class UsuarioDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    PreparedStatement stmt2 = null;
    ResultSet rs = null; 
    
    private String buscarTodosUsuarios = "select * from usuarios";
    private String stmtBuscaUsuario = "select idUsuario, nome,"
            + "usuario, perfil from usuarios where usuario = ? and senha = ?"; //"select idUsuario, nome, login, nome, senha from Usuario where login = ? and senha = ?";
    private String insereUsuario = "insert into usuarios (nomeUsuario, emailUsuario, login, senha, perfil, dataNascimento) values (?, ?, ?, ?, ?, ?)";
    private String deletarUsuario = "delete from usuario where idUsuario = ?";
    
    
    public List<Usuario> buscarTodosUsuarios() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> listaUsuarios = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarTodosUsuarios);
            rs = stmt.executeQuery();
            listaUsuarios = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nome"), rs.getString("usuario"), rs.getString("senha"), rs.getString("perfil"));
                listaUsuarios.add(usuario);
            }  
        return listaUsuarios;
        }
    catch(SQLException ex){
            throw new RuntimeException("Erro ao listar os usuarios no banco de dados. Origem=" + ex.getMessage());
    }
        finally{
            try {
            rs.close();
        } catch (Exception ex) {
            System.out.println("Erro ao fechar rs. Ex=" + ex.getMessage());
        };
        try {
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
        };
        try {
            con.close();;
        } catch (Exception ex) {
            System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
        };
    }
    }
    
    public Usuario lerUsuario (String user, String senha){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaUsuario);
            stmt.setString(1, user);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();   
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setUsuario(rs.getString("usuario"));
                u.setPerfil(rs.getString("perfil"));
                return u;
            }
            else {
                return null;
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar usuario" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }
    
    public void inserirUsuario (Usuario u){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insereUsuario);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getUsuario());
            stmt.setString(4, u.getSenha());
            stmt.setString(5, u.getPerfil());
            stmt.executeUpdate();   
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar usuario" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }
    
}
