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
import rh.modelo.Municipio;

/**
 *
 * @author DGTALE
 */
@FacesConverter("municipioConverter")
public class MunicipioConverter implements Converter{
 private static Map<String, Municipio> map = new HashMap<String, Municipio>();
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         return map.get(value);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
          if (value instanceof Municipio) {
            Municipio m = (Municipio) value;
            map.put(String.valueOf(m.getIdMunicipio()), m);
            return String.valueOf(m.getIdMunicipio());
        } else {
            return "";
        }

    }
    
}
