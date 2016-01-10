package controller;

import model.FacultadFacadeLocal;
import model.ProfesorFacadeLocal;
import entity.Facultad;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "listarFacultadIngresoController")
@SessionScoped
public class listarFacultadIngresoController implements Serializable{
 
    @EJB
    private FacultadFacadeLocal facultadEJB;
           
    @EJB
    private ProfesorFacadeLocal profesorEJB;
    
    public List<Facultad> findall2(){
        
        
        return this.facultadEJB.findAll();
    }
}
