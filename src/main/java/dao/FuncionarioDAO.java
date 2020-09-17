/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.util.ConexaoDB;
import rh.modelo.Departamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import rh.modelo.Funcionario;
import rh.modelo.Municipio;
import rh.modelo.Sexo;

/**
 *
 * @author DGTALE
 */
public class FuncionarioDAO {

    /*
   
    


    
     */
    String INSERT = "INSERT INTO funcionario(nome, sobrenome, data_nascimento, rua, casa, bairro, sexo, id_municipio) VALUES(?, ?, ?, ?, ?, ?, ?,?)";
    String UPDATE = "UPDATE funcionario SET nome = ?, sobrenome = ?, data_nascimento = ?, rua = ?, casa = ?, bairro = ?, sexo = ?, id_municipio = ? WHERE id_funcionario = ?";
    String DELETE = "DELETE FROM funcionario WHERE id_funcionario = ?";
    String SELECT_ALL = "SELECT id_funcionario, nome, sobrenome, data_nascimento, rua, casa, bairro, sexo, id_municipio FROM  funcionario";
    String SELECT_BY_NOME = "SELECT id_funcionario, nome, sobrenome, data_nascimento, rua, casa, bairro, sexo, id_municipio FROM  funcionario f WHERE f.nome LIKE ? ";
    String SELECT_BY_NOME_SOBRENOME = "SELECT id_funcionario, nome, sobrenome, data_nascimento, rua, casa, bairro, sexo, id_municipio FROM  funcionario f WHERE f.nome = ? AND f.sobrenome = ?";
    String SELECT_BY_DATA_NASCIMENTO = "SELECT id_funcionario, nome, sobrenome, data_nascimento, rua, casa, bairro, sexo, id_municipio FROM  funcionario f WHERE f.data_nascimento BETWEEN ? AND ?";

    public void save(Funcionario f) {
        PreparedStatement ps = null;
        Connection conn = null;
    
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getSobrenome());
            ps.setDate(3, new java.sql.Date(f.getDataNascimento().getTime()));
            ps.setString(4, f.getRua());
            ps.setString(5, f.getCasa());
            ps.setString(6, f.getBairro());
            ps.setString(7, f.getSexo().getAbreviatua());
            ps.setInt(8, f.getMunicipio().getIdMunicipio());
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao inserir dados:"
                    + " DepartamentoDAO:save" + e.getLocalizedMessage());
        }

    }
    
     public void edit(Funcionario f) {
        PreparedStatement ps = null;
        Connection conn = null;
    
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getSobrenome());
            ps.setDate(3, new java.sql.Date(f.getDataNascimento().getTime()));
            ps.setString(4, f.getRua());
            ps.setString(5, f.getCasa());
            ps.setString(6, f.getBairro());
            ps.setString(7, f.getSexo().getAbreviatua());
            ps.setInt(8, f.getMunicipio().getIdMunicipio());
            ps.setInt(9, f.getId());
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao actualizar dados:"
                    + " DepartamentoDAO:save" + e.getLocalizedMessage());
        }

    }

      public void delete(Funcionario f) {
        PreparedStatement ps = null;
        Connection conn = null;
    
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, f.getId());
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao eliminar dados:"
                    + " DepartamentoDAO:save" + e.getLocalizedMessage());
        }

    }
     
    public List<Funcionario> listaTodosFuncionarios() {
        List<Funcionario> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                /*nome, sobrenome, data_nascimento, 
                rua, casa, bairro, sexo, id_municipio*/
                Funcionario f = new Funcionario();
                f.setId(rs.getInt(1));
                f.setNome(rs.getString("nome"));
                f.setSobrenome(rs.getString("sobrenome"));
                f.setDataNascimento(rs.getDate("data_nascimento"));
                f.setRua(rs.getString(5));
                f.setCasa(rs.getString(6));
                f.setBairro(rs.getString(7));
                f.setSexo(Sexo.getAbreviatura(rs.getString(8)));
                
                Municipio municipio = new Municipio();
                municipio.setIdMunicipio(rs.getInt("id_municipio"));
                f.setMunicipio(municipio);
               
                lista.add(f);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:"
                    + "FuncionarioDAO:"
                    + "listaTodosFuncionarios" + ex.getLocalizedMessage());
        }

        return lista;
    }

    public List<Departamento> listaFuncionariosByNome(String nome) {
        List<Departamento> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(SELECT_BY_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                Departamento d = new Departamento();
                d.setSigla(rs.getString(1));
                d.setNome(rs.getString(2));
                lista.add(d);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:"
                    + "FuncionarioDAO:"
                    + "listaFuncionariosByNome" + ex.getLocalizedMessage());
        }

        return lista;
    }
}
