/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.util.ConexaoDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import rh.modelo.Municipio;
import rh.modelo.Provincia;

/**
 *
 * @author DGTALE
 */
public class ProvinciaDAO {

    String SELECT_ALL = "SELECT id_provincia, nome_provincia FROM provincia";
    
    public List<Provincia> listaProvincias() {
        List<Provincia> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Provincia p = new Provincia();
                p.setIdProvincia(rs.getInt("id_provincia"));
                p.setNomeProvincia(rs.getString("nome_provincia"));
                
                lista.add(p);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:"
                    + "ProvinciaDAO:"
                    + "listaProvincias" + ex.getLocalizedMessage());
        }

        return lista;
    }

   
}
