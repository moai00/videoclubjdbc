/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Pelicula {
    
        private String codigo;
    private String titulo;

    public static final String PROP_TITULO = "titulo";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String oldTitulo = this.titulo;
        this.titulo = titulo;
        propertyChangeSupport.firePropertyChange(PROP_TITULO, oldTitulo, titulo);
    }


    public static final String PROP_CODIGO = "codigo";

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange(PROP_CODIGO, oldCodigo, codigo);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
