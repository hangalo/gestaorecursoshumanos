/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import dao.DepartamentoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import rh.modelo.Departamento;

@Named(value = "departamentoCDIBean")
@RequestScoped
public class DepartamentoCDIBean {

    Departamento departamento;
    DepartamentoDAO dao = new DepartamentoDAO();
    
    List<Departamento> departamentos;
    
@PostConstruct
public void ini(){
departamento = new Departamento();
departamentos = new ArrayList<>();
departamentos = dao.listaDepartamentos();
}
   
public String save() {
        dao.save(departamento);
        departamento = new Departamento();
       return "departamento";
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

}
