/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.controller.profesor.ProfesorFacadeLocal;
import com.entity.Facultad;
import com.entity.Profesor;
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

    private List<Profesor> profesores;
    private Profesor profesor;
    //Clave foranea para llenar el comboBox
    private Facultad facultad;
    @EJB
    ProfesorFacadeLocal profesorControlador;

    /*constructor*/
    public ProfesorBean() {
        facultad = new Facultad();//Es para guardar al crear profesor
    }

    /*Getter and Setters*/
    public List<Profesor> getProfesores() {
        try {
            profesores = profesorControlador.findAll();
            return profesores;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
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
            profesorControlador.edit(profesor);
            System.out.println("Entro a editar profesor");
        } else {
            profesorControlador.create(profesor);
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
        profesorControlador.remove(profesor);
        return null;
    }
    /*public String botonBuscar() {
     profesores = profesorControlador.findRange(cedula);
     return null;
     }*/
}