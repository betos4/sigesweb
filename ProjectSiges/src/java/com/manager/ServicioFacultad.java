/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entity.Facultad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Roberto
 */
@Stateless
public class ServicioFacultad extends ServicioGenerico<Facultad> {

    public ServicioFacultad() {
        super(Facultad.class, ServicioFacultad.class);
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Facultad> buscarTodos() {
        Query q = em
                .createQuery("SELECT f FROM Facultad f Order by f.nombreFacultad asc");
        return q.getResultList();
    }
    
    
    /*public int buscarFacutadId(String nombre) {
        Query q = em
                .createQuery("SELECT f.idFacultad FROM Facultad f where f.nombreFacultad="+nombre);
        return q.getFirstResult();
    }*/
}
