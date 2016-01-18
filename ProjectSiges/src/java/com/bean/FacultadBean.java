/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.manager.ServicioFacultad;
import com.entity.Facultad;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
//import javax.faces.bean.ViewScoped;

/**
 *
 * @author Roberto
 */
@ManagedBean(name = "facultadBean")
@SessionScoped
public class FacultadBean {
    @EJB
    private ServicioFacultad EJBservicioFacultad;

    private Facultad facultad;
    private List<Facultad> listaFacultades;
    //@EJB
    //ServicioFacultad EJBservicioFacultad;
    private int selectedItemIndex;

    
    
    public FacultadBean() {
        //facultades = new ArrayList<Facultad>();
    }
    
    public Facultad getSelected() {
        if (facultad == null) {
            facultad = new Facultad();
            selectedItemIndex = -1;
        }
        return facultad;
    }


    /*Getters and setters*/
    public Facultad getFacultad() {
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

    //Metodos Buscar en Combobox
    public SelectItem[] getFacultadesDisponiblesSelecccionarUno() {
        return ServicioFacultad.getSeleccionarItems(EJBservicioFacultad.buscarTodos(), true);
        
        //return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }
    
    
    /*METODOS PARA EL CRUD DE FACULTAD*/
    public String botonGuardar() {
        if (facultad.getIdFacultad() != null) {
            EJBservicioFacultad.actualizar(facultad);
            System.out.println("Entro a editar facultad");
        } else {
            EJBservicioFacultad.insertar(facultad);
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
        EJBservicioFacultad.eliminar(facultad);
        return null;
    }
    
    public String botonModificar(Facultad facultad) {
        this.facultad = facultad;//va el this para modificar el campo elegido
        return "regreso";
    }
}
