package controller;

import model.ProfesorFacadeLocal;
import entity.Profesor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
//import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "listarProfesorIngresoController")
@SessionScoped
public class listarProfesorIngresoController implements Serializable{
    @EJB
    private ProfesorFacadeLocal profesorEJB;
    
    
    public List <Profesor> findall2(){
        return this.profesorEJB.findAll();
    }
    
    /*private List<Profesor> listaProfesor;
    

    public List<Profesor> getListaProfesor() {
        return listaProfesor;
    }

    public void setListaProfesor(List<Profesor> listaProfesor) {
        this.listaProfesor = listaProfesor;
    }*/
   /* public List <Profesor> findAll2(){
        return this.profesorEJB.findAll();
    
    }*/
    
    
    
    
    /**
     *
     */
    /*@PostConstruct
    public void init(){
    
        listaProfesor = profesorEJB.findAll();
    }*/
    
}
