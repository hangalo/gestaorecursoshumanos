/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import rh.modelo.Departamento;

/**
 *
 * @author DGTALE
 */
@FacesConverter("departamentoConverter")
public class DepartamentoConverter implements Converter {

    private static Map<String, Departamento> map = new HashMap<String, Departamento>();

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        return map.get(arg2);
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if (arg2 instanceof Departamento) {
            Departamento dp = (Departamento) arg2;
            map.put(dp.getSigla(), dp);
            return dp.getSigla();
        } else {
            return "";
        }

    }

}
