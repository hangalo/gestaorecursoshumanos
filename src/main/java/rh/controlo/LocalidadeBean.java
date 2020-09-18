/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import dao.MunicipioDAO;
import dao.ProvinciaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import rh.modelo.Municipio;
import rh.modelo.Provincia;

/**
 *
 * @author DGTALE
 */
@Named(value = "localidadeBean")
@RequestScoped
public class LocalidadeBean {

    List<Municipio> municipios;
  
   Provincia provincia = new Provincia();

    MunicipioDAO municipioDAO = new MunicipioDAO();
    ProvinciaDAO provinciaDAO = new ProvinciaDAO();

    @PostConstruct
    public void inicizalizar() {
        municipios = new ArrayList<>();
      }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    
    
    
    
    public List<SelectItem> getSelectMunicipios() {
        List<SelectItem> lista = new ArrayList<>();
        for (Municipio m : municipioDAO.listaMunicipios()) {
            lista.add(new SelectItem(m, m.getNomeMunicipio()));
        }
        return lista;
    }

    public List<SelectItem> getSelectProvincias() {
        List<SelectItem> lista = new ArrayList<>();
        for (Provincia p : provinciaDAO.listaProvincias()) {
            lista.add(new SelectItem(p, p.getNomeProvincia()));
        }
        return lista;
    }

    public void listaMunicipiosDaProvincia(AjaxBehaviorEvent event) {
        System.out.println(">>>>>>>>>>>>>>>>Passsou"+event.toString());
        municipios = municipioDAO.listaMunicipiosDaProvincia(provincia);
        for (Municipio municipio : municipios) {
            System.out.println(">>>>>>>>>>"+municipio.getNomeMunicipio());
        }
    }
}
