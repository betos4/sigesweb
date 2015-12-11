/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.profesor;

import com.entity.Profesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Roberto
 */
@Local
public interface ProfesorFacadeLocal {

    void create(Profesor profesor);

    void remove(Profesor profesor);

    void edit(Profesor profesor);

    Profesor find(Object id);

    List<Profesor> findAll();

    List<Profesor> findRange(int[] range);

    int count();
}