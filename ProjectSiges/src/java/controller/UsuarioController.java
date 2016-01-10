package controller;

import model.FacultadFacadeLocal;
import model.UsuarioFacadeLocal;
import entity.Facultad;
import entity.Profesor;
import entity.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable{
     @EJB
    private UsuarioFacadeLocal usuarioEJB;
     @EJB
    private FacultadFacadeLocal facultadEJB;
    
    private Usuario usuario;
    private Profesor profesor;
    private Facultad facultad;

    @PostConstruct
    public void init() {
        usuario  = new Usuario();
        profesor  = new Profesor();
        facultad  = new Facultad();
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

   
    
    public void registar(){
    
    
        try {
            //this.usuario.set;
            this.usuario.setCodigoProfesor(profesor);
            usuarioEJB.create(usuario);
            this.facultad.setCodigoProfesor(profesor);
            facultadEJB.create(facultad);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"AVISO","Se Registro"));
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"AVISO","ERROR"));
        
        
            System.out.print("RuntimeException: ");
            System.out.println(e.getMessage());
        }
    }
}
