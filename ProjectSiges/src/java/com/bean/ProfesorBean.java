/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entity.Facultad;
import com.entity.Profesor;
import com.manager.ServicioProfesor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.faces.bean.SessionScoped;

/**
 *
 * @author Roberto
 */
@ManagedBean(name = "profesorBean")
@SessionScoped
public class ProfesorBean {

    private List<Profesor> listaProfesores;
    private Profesor profesor;
    //Clave foranea para llenar el comboBox
    private Facultad facultad;
    @EJB
    ServicioProfesor servicioProfesor;

    /*constructor*/
    public ProfesorBean() {
        facultad = new Facultad();//Es para guardar al crear profesor
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

    /*Metodos para realizar el CRUD*/
    public String guardarDatos() {
        if (profesor.getCedulaProfesor() != null) {
            servicioProfesor.actualizar(profesor);
            System.out.println("Entro a editar profesor");
            System.out.println(profesor.getApellidoProfesor());
            //System.out.println(profesor.getIdFacultad());
        } else {
            servicioProfesor.insertar(profesor);
            System.out.println("Entro a crear profesor");
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
    /*public String botonBuscar() {
     profesores = profesorControlador.findRange(cedula);
     return null;
     }*/
}