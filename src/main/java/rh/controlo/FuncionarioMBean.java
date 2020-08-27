/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import rh.modelo.Funcionario;

/**
 *
 * @author DGTALE
 */
@Named(value = "funcionarioMBean")
@RequestScoped
public class FuncionarioMBean {

    Funcionario funcionario = new Funcionario();

    @PostConstruct
    public void init() {

    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String guardar() {

        return "resultado";
    }

}
