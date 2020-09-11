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
import rh.modelo.Municipio;
import rh.modelo.Provincia;

/**
 *
 * @author DGTALE
 */
public class MunicipioDAO {

    String SELECT_ALL = "SELECT * FROM municipio";
    String SELECT_BY_NOME = "SELECT id_municipio, nome_municipio, nome_provincia FROM municipio m INNER JOIN provincia p ON m.id_provincia = p.id_provincia  WHERE m.nome_municipio LIKE ? ";
    String SELECT_BY_PROVINCIA = "SELECT id_municipio, nome_municipio, nome_provincia FROM municipio m INNER JOIN provincia p ON m.id_provincia = p.id_provincia  WHERE P.nome_provincia = ? ";

    public List<Municipio> listaMunicipios() {
        List<Municipio> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio m = new Municipio();
                m.setIdMunicipio(rs.getInt("id_municipio"));
                m.setNomeMunicipio(rs.getString("nome_municipio"));
                lista.add(m);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:"
                    + "MunicipioDAO:"
                    + "listaMunicipios" + ex.getLocalizedMessage());
        }

        return lista;
    }

    public List<Municipio> listaMunicipiosByProvincia(String nomeProvincia) {
        List<Municipio> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(SELECT_BY_PROVINCIA);
            ps.setString(1, nomeProvincia);
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio m = new Municipio();
                m.setIdMunicipio(rs.getInt("id_municipio"));
                m.setNomeMunicipio(rs.getString("nome_municipio"));
                Provincia p = new Provincia();
                p.setNomeProvincia(rs.getString("nome_provincia"));
                lista.add(m);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:"
                    + "MunicipioDAO:"
                    + "listaMunicipiosByProvincia" + ex.getLocalizedMessage());
        }

        return lista;
    }
}
