/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.facultad;

import com.entity.Facultad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Roberto
 */
@Local
public interface FacultadFacadeLocal {

    void create(Facultad facultad);

    void remove(Facultad facultad);

    void edit(Facultad facultad);

    Facultad find(Object id);

    List<Facultad> findAll();

    List<Facultad> findRange(int[] range);

    int count();
}
