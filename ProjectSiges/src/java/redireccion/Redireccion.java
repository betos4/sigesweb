/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package redireccion;

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

    /*public void getionAdministracion() {
     try {
     FacesContext
     .getCurrentInstance()
     .getExternalContext()
     .redirect("/ProjectSiges/pages/gestionAdministracion/gestionAdministracion.xhtml");
     } catch (Exception e) {
     // TODO: handle exception
     }
     }*/
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
    
    public void crearProfesor() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/pages/gestionAdministracion/profesor/crearProfesor.xhtml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    
    

    public void eliminarProfesor() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/pages/gestionAdministracion/profesor/eliminarProfesor.xhtml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void buscarProfesor() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/pages/gestionAdministracion/profesor/buscarProfesor.xhtml");
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

    public void eliminarFacultad() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/pages/gestionAdministracion/facultad/eliminarFacultad.xhtml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void buscarFacultad() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/pages/gestionAdministracion/facultad/buscarFacultad.xhtml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //BOTONES PARA RETROCEDER DE TODAS LAS PAGINAS
    public void atrasFacultad() {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/ProjectSiges/pages/gestionAdministracion/facultad/listarFacultadIngreso.xhtml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
