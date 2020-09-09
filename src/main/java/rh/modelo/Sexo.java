/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.modelo;

/**
 *
 * @author DGTALE
 */
public enum Sexo {
    MASCULINO("M", "Masculino"), FEMININO("F", "Feminino");
    private String abreviatua;
    private String extensao;

    private Sexo(String abreviatua, String extensao) {
        this.abreviatua = abreviatua;
        this.extensao = extensao;
    }

    public String getAbreviatua() {
        return abreviatua;
    }

    public void setAbreviatua(String abreviatua) {
        this.abreviatua = abreviatua;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public static Sexo getAbreviatura(String id) {

        for (Sexo s : values()) {
            if (s.getAbreviatua().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}
