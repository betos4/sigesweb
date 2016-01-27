/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Roberto
 */
public abstract class ServicioGenerico<T> {

    @PersistenceContext
    protected EntityManager em;
    private Class<T> tipoBean;
    @SuppressWarnings("unused")
    private Class<?> tipoServicio;

    // CONSTRUCTOR
    public ServicioGenerico(Class<T> tipoBean, Class<?> tipoServicio) {
        this.tipoBean = tipoBean;
        this.tipoServicio = tipoServicio;
    }

    // METODOS
    public boolean insertar(T entidad) {
        boolean flag;
        try {
            System.out.println("El valor creado es el siguiente: " + entidad.toString());
            em.persist(entidad);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean actualizar(T entidad) {
        boolean flag;
        try {
            System.out.println("El valor actualizado es el siguiente: " + entidad.toString());
            em.merge(entidad);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean eliminar(T entidad) {
        boolean flag;
        try {
            System.out.println("El valor eliminado es el siguiente: " + entidad.toString());
            em.remove(em.merge(entidad));
            flag = true;
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        return flag;
    }

    public void eliminar2(T entidad) {
        em.remove(entidad);
    }

    public T buscarPorId(Integer id) {
        return em.find(tipoBean, id);
    }

    public T buscarPorId(Short id) {
        return em.find(tipoBean, id);
    }

    public void flushBase() {
        em.flush();
    }

    public static SelectItem[] getSeleccionarItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> buscarTodos() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(tipoBean));
        return em.createQuery(cq).getResultList();
    }
}
