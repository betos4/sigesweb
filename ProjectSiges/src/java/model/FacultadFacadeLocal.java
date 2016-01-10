/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Facultad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DARIO
 */
@Local
public interface FacultadFacadeLocal {

    void create(Facultad facultad);

    void edit(Facultad facultad);

    void remove(Facultad facultad);

    Facultad find(Object id);

    List<Facultad> findAll();

    List<Facultad> findRange(int[] range);

    int count();
    
}
