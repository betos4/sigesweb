/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

/**
 *
 * @author Roberto
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "redireccion")
@ViewScoped
public class Redireccion {

    public void modulos() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/modulo.xhtml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void ingresarProfesor() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/pages/gestionAdministracion/profesor/listarProfesorIngreso.xhtml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //Esto es para Facultad
    public void ingresarFacultad() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/pages/gestionAdministracion/facultad/listarFacultadIngreso.xhtml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /***************************************Para el boton que regresa a los modulos**************************************/
    public void atrasModulos() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/pages/gestionAdministracion/modulosAdministracion.xhtml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
