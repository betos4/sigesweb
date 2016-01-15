/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entity.Profesor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Roberto
 */
@Stateless
public class ServicioProfesor extends ServicioGenerico<Profesor> {
    
    public ServicioProfesor() {
        super(Profesor.class, ServicioProfesor.class);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Profesor> buscarTodos() {
        Query q = em
                .createQuery("SELECT p FROM Profesor p Order by p.nombreProfesor asc");
        return q.getResultList();
    }
    
    public List<Profesor> buscarProfesor(int cedula) {
        Query q = em
                .createNamedQuery("Profesor.findByCedulaProfesor");
        q.setParameter("cedulaProfesor", cedula);
        return q.getResultList();
    }
}
