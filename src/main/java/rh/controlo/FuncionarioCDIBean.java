/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import rh.modelo.Funcionario;

/**
 *
 * @author DGTALE
 */
@Named(value = "funcionarioCDIBean")
@RequestScoped
public class FuncionarioCDIBean {

    Funcionario funcionario1 = new Funcionario("Joaquim", "Hangalo", "Informatica", 45, 50000.00);
    Funcionario funcionario2 = new Funcionario("Bartolomeu", "Hangalo", "Juridico", 30, 700000.0);
    Funcionario funcionario3 = new Funcionario("Luzia", "Hangalo", "Contabilidade", 60, 80000.00);
    
    Funcionario funcionario = new Funcionario();
    
    List<Funcionario> funcionarios = new ArrayList<>();

    @PostConstruct
    public void init() {
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
    
    public String guardar() {
        funcionarios.add(funcionario);
        ///funcionario = new Funcionario();
        return "lista-funcionarios";
    }

}
