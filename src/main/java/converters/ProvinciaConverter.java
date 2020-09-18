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
import rh.modelo.Provincia;

/**
 *
 * @author desenvolvimento
 */
@FacesConverter("provinciaConverter")
public class ProvinciaConverter implements Converter {

    private static Map<String, Provincia> mapa = new HashMap<String, Provincia>();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return mapa.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Provincia) {
            Provincia p = (Provincia) value;
            mapa.put(String.valueOf(p.getIdProvincia()), p);
            return String.valueOf(p.getIdProvincia());
        } else {
            return "";
        }

    }

}
