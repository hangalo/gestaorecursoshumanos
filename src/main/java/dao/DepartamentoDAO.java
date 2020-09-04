/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.util.ConexaoDB;
import rh.modelo.Departamento;
import java.sql.*;

/**
 *
 * @author DGTALE
 */
public class DepartamentoDAO {
    
    String INSERT="INSERT INTO departamento VALUES(?, ?)";
    String UPDATE="";
    String DELETE ="";
    String SELECT_ALL="SELECT * FROM departamento";
    String SELECT_BY_NOME="";
    String SELECT_BY_SIGLA="";
    
    
    public void save(Departamento d){
    PreparedStatement ps=null;
    Connection conn =null;
     
        try {
           conn=ConexaoDB.ligarBD();
           ps = conn.prepareStatement(INSERT);
           ps.setString(1, d.getSigla());
           ps.setString(2, d.getNome());
           ps.executeUpdate();
        } catch (SQLException e) {
            
            System.err.println("Erro ao inserir dados:"
                    + " DepartamentoDAO:save"+e.getLocalizedMessage());
        }
    
    
    }
}
