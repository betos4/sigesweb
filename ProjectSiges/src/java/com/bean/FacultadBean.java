/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.controller.facultad.FacultadFacadeLocal;
import com.entity.Facultad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ViewScoped;

/**
 *
 * @author Roberto
 */
@ManagedBean(name = "facultadBean")
@SessionScoped
public class FacultadBean {

    private List<Facultad> facultades;
    private Facultad facultad;
    @EJB
    FacultadFacadeLocal facultadControlador;

    public FacultadBean() {
        //facultades = new ArrayList<Facultad>();
    }

    /*Getters and setters*/
    public List<Facultad> getFacultades() {
        // try {
        facultades = facultadControlador.findAll();
        return facultades;

        /*} catch (Exception e) {
         e.printStackTrace();
         return null;
         }*/
    }

    public void setFacultades(List<Facultad> facultades) {
        this.facultades = facultades;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    /*METODOS PARA EL CRUD DE FACULTAD*/
    public String guardarDatos() {
        if (facultad.getIdFacultad() != null) {
            facultadControlador.edit(facultad);
            System.out.println("Entro a editar facultad");
        } else {
            facultadControlador.create(facultad);
            System.out.println("Entro a crear facultad");
        }
        return "indice";
    }

    public String botonInsertar(Facultad facultad) {
        this.facultad = new Facultad();
        System.out.println("Entro a Insertar");
        return "regreso";
    }

    public String botonEliminar(Facultad facultad) {
        facultadControlador.remove(facultad);
        return null;
    }
}
