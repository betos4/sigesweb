/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.manager.ServicioFacultad;
import com.entity.Facultad;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
//import javax.faces.bean.ViewScoped;

/**
 *
 * @author Roberto
 */
@ManagedBean(name = "facultadBean")
@RequestScoped
public class FacultadBean {

    @EJB
    private ServicioFacultad EJBservicioFacultad;
    private Facultad facultad;
    private List<Facultad> listaFacultades;
    //@EJB
    //ServicioFacultad EJBservicioFacultad;
    //private int selectedItemIndex;

    public FacultadBean() {
        //facultad = new Facultad();
        //facultades = new ArrayList<Facultad>();
    }

    /*Getters and setters*/
    public Facultad getFacultad() {
        if(facultad == null) {
            facultad = new Facultad();
        }
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Facultad> getListaFacultades() {
        listaFacultades = EJBservicioFacultad.buscarTodos();
        return listaFacultades;
    }

    public void setListaFacultades(List<Facultad> listaFacultades) {
        this.listaFacultades = listaFacultades;
    }

    /*METODOS PARA EL CRUD DE FACULTAD*/
    public void botonGuardar(ActionEvent actionEvent) {
        String msg;
        System.out.println("Entro a crear facultad");

        if (EJBservicioFacultad.insertar(this.facultad)) {
            msg = "Se creó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al crear el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }        
    }

    public void botonEliminar(ActionEvent actionEvent) {
        String msg;
        if (EJBservicioFacultad.eliminar(this.facultad)) {
            msg = "Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void botonModificar(ActionEvent actionEvent) {
        String msg;
        if (EJBservicioFacultad.actualizar(this.facultad)) {
            msg = "Se modificó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al modificar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        System.out.println("Entro a actualizar facultad");
    }
}
