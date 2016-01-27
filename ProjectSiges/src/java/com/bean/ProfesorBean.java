/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entity.Facultad;
import com.entity.Profesor;
import com.manager.ServicioFacultad;
import com.manager.ServicioProfesor;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
//import javax.faces.bean.SessionScoped;

/**
 *
 * @author Roberto
 */
@ManagedBean(name = "profesorBean")
@RequestScoped
public class ProfesorBean {

    private List<Profesor> listaProfesores;
    public Profesor profesor;
    private Facultad facultad;
    @EJB
    ServicioProfesor EJBservicioProfesor;
    @EJB
    ServicioFacultad EJBservicioFacutlad;
    
    /*constructor*/
    public ProfesorBean() {
        facultad = new Facultad();//Es para guardar al crear profesor
        profesor = new Profesor();
    }

    /*Getter and Setters*/
    public List<Profesor> getListaProfesores() {
        listaProfesores = EJBservicioProfesor.buscarTodos();
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /*Getters and setters de facultad*/
    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    /*Metodos para realizar el CRUD*/
    public void guardarDatos(ActionEvent actionEvent) {
        String msg;
        
        profesor.setIdFacultad(EJBservicioFacutlad.buscarPorId(facultad.getIdFacultad()));
        if (EJBservicioProfesor.insertar(this.profesor)) {
            msg = "Se creó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al crear el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        System.out.println("Entro a crear profesor");
    }

    public void botonEliminar(ActionEvent actionEvent) {
        String msg;
        if (EJBservicioProfesor.eliminar(this.profesor)) {
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
        profesor.setIdFacultad(EJBservicioFacutlad.buscarPorId(facultad.getIdFacultad()));
        if (EJBservicioProfesor.actualizar(this.profesor)) {
            msg = "Se modificó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al modificar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        System.out.println("Entro a actualizar profesor");
    }
}