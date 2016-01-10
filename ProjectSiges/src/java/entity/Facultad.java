/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DARIO
 */
@Entity
@Table(name = "facultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f"),
    //@NamedQuery(name = "Facultad.findByCodigoFacultad", query = "SELECT f FROM Facultad f WHERE f.codigoFacultad = :codigoFacultad"),
    @NamedQuery(name = "Facultad.findByTipoFacultad", query = "SELECT f FROM Facultad f WHERE f.tipoFacultad = :tipoFacultad")})
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
     @Basic(optional = false)
     @Column(name = "codigo_Facultad")
     private Integer codigoFacultad;*/
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codigo_Profesor", nullable = false)
    private Profesor codigoProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "tipoFacultad")
    private String tipoFacultad;

    public Facultad() {
    }

    public String getTipoFacultad() {
        return tipoFacultad;
    }

    public void setTipoFacultad(String tipoFacultad) {
        this.tipoFacultad = tipoFacultad;
    }

    public Profesor getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Profesor codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }
    /*
     @Override
     public int hashCode() {
     int hash = 0;
     hash += (codigoFacultad != null ? codigoFacultad.hashCode() : 0);
     return hash;
     }

     @Override
     public boolean equals(Object object) {
     // TODO: Warning - this method won't work in the case the id fields are not set
     if (!(object instanceof Facultad)) {
     return false;
     }
     Facultad other = (Facultad) object;
     if ((this.codigoFacultad == null && other.codigoFacultad != null) || (this.codigoFacultad != null && !this.codigoFacultad.equals(other.codigoFacultad))) {
     return false;
     }
     return true;
     }

     @Override
     public String toString() {
     return "com.entity.Facultad[ codigoFacultad=" + codigoFacultad + " ]";
     }*/

    public void setCodigoProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
