/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entity.Facultad;
import com.entity.Profesor;
import com.manager.ServicioFacultad;
import com.manager.ServicioProfesor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.faces.bean.SessionScoped;

/**
 *
 * @author Roberto
 */
@ManagedBean(name = "profesorBean")
@SessionScoped
public class ProfesorBean implements Serializable{

    private List<Profesor> listaProfesores;
    public Profesor profesor;
    private Facultad facultad;
    @EJB
    ServicioProfesor servicioProfesor;
    @EJB
    ServicioFacultad servicioFacutlad;
    
    /*PAra realizar la busqueda de un profesor*/
    private List<Profesor> busquedaProfesor;
    private int cedula;

    /*constructor*/
    public ProfesorBean() {
        facultad = new Facultad();//Es para guardar al crear profesor
        busquedaProfesor = new ArrayList<Profesor>();
    }

    /*Getter and Setters*/
    public List<Profesor> getListaProfesores() {
        listaProfesores = servicioProfesor.buscarTodos();
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
    
    
    /*Getters and Setters para lo de la busqueda*/
    public List<Profesor> getBusquedaProfesor() {
        return busquedaProfesor;
    }

    public void setBusquedaProfesor(List<Profesor> busquedaProfesor) {
        this.busquedaProfesor = busquedaProfesor;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /*Metodos para realizar el CRUD*/
    public String guardarDatos() {
        if (profesor.getCedulaProfesor() != null) {
            profesor.setIdFacultad(servicioFacutlad.buscarPorId(facultad.getIdFacultad()));
            servicioProfesor.actualizar(profesor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"AVISO","Se Registro"));
            System.out.println("Entro a editar profesor");
        } else {
            //profesor.setIdFacultad(servicioFacutlad.buscarPorId(facultad.getIdFacultad()));
            servicioProfesor.insertar(profesor);
            System.out.println("Entro a crear profesor");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"AVISO","ERROR"));
        }
        return "indice";
    }

    public String botonInsertar(Profesor profesor) {
        this.profesor = new Profesor();
        System.out.println("Entro a Insertar");
        return "regreso";
    }

    public String botonEliminar(Profesor profesor) {
        servicioProfesor.eliminar(profesor);
        return null;
    }

    public String botonModificar(Profesor profesor) {
        this.profesor = profesor;//va el this para modificar el campo elegido
        return "regreso";
    }
   
    public void botonModificarFilaEditable(Profesor profe) {
        servicioProfesor.actualizar(profe);//va el this para modificar el campo elegido
        
    }
    
    
    public String botonModificar2(Profesor profesor) {
        this.profesor = profesor;//va el this para modificar el campo elegido
        return "buscar";
    }

    public List<Profesor> botonBuscar() {
        busquedaProfesor = servicioProfesor.buscarProfesor(cedula);
        return busquedaProfesor;
    }
    /*public int getIdFacultad(String nombre) {
     int aux = servicioFacutlad.buscarFacutadId(nombre);
     return aux;
     }*/
}