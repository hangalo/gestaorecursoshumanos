/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import dao.MunicipioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import rh.modelo.Municipio;

/**
 *
 * @author DGTALE
 */
@Named(value = "municipioBean")
@RequestScoped
public class MunicipioBean {

    MunicipioDAO dao = new MunicipioDAO();
    List<Municipio> municipios;

    @PostConstruct
    public void inicizalizar() {
        municipios = new ArrayList<>();
    }
    
       public List<Municipio> getListaMunicipioos() {
        List<Municipio> lista = new ArrayList<>();
        lista = dao.listaMunicipios();
        return lista;

    }
       
       
         public List<SelectItem> getSelectMunicipios() {
        List<SelectItem> lista = new ArrayList<>();
        for (Municipio m : dao.listaMunicipios()) {
            lista.add(new SelectItem(m, m.getNomeMunicipio()));
        }
        return lista;
    }
}
