/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.manager.ServicioFacultad;
import com.entity.Facultad;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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

    private Facultad facultad;
    private List<Facultad> listaFacultades;
    @EJB
    ServicioFacultad servicioFacultad;

    public FacultadBean() {
        //facultades = new ArrayList<Facultad>();
    }
    


    /*Getters and setters*/
    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Facultad> getListaFacultades() {
        listaFacultades = servicioFacultad.buscarTodos();
        return listaFacultades;
    }

    public void setListaFacultades(List<Facultad> listaFacultades) {
        this.listaFacultades = listaFacultades;
    }

    /*METODOS PARA EL CRUD DE FACULTAD*/
    public String botonGuardar() {
        if (facultad.getIdFacultad() != null) {
            servicioFacultad.actualizar(facultad);
            System.out.println("Entro a editar facultad");
        } else {
            servicioFacultad.insertar(facultad);
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
        servicioFacultad.eliminar(facultad);
        return null;
    }
    
    public String botonModificar(Facultad facultad) {
        this.facultad = facultad;//va el this para modificar el campo elegido
        return "regreso";
    }
}
