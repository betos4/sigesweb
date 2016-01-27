/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Roberto
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByCodigoProfesor", query = "SELECT p FROM Profesor p WHERE p.codigoProfesor = :codigoProfesor"),
    @NamedQuery(name = "Profesor.findByCedulaProfesor", query = "SELECT p FROM Profesor p WHERE p.cedulaProfesor = :cedulaProfesor"),
    @NamedQuery(name = "Profesor.findByNombreProfesor", query = "SELECT p FROM Profesor p WHERE p.nombreProfesor = :nombreProfesor"),
    @NamedQuery(name = "Profesor.findByApellidopaternoProfesor", query = "SELECT p FROM Profesor p WHERE p.apellidopaternoProfesor = :apellidopaternoProfesor"),
    @NamedQuery(name = "Profesor.findByApellidomaternoProfesor", query = "SELECT p FROM Profesor p WHERE p.apellidomaternoProfesor = :apellidomaternoProfesor"),
    @NamedQuery(name = "Profesor.findByCorreoProfesor", query = "SELECT p FROM Profesor p WHERE p.correoProfesor = :correoProfesor"),
    @NamedQuery(name = "Profesor.findByTelefonoProfesor", query = "SELECT p FROM Profesor p WHERE p.telefonoProfesor = :telefonoProfesor"),
    @NamedQuery(name = "Profesor.findByCelularProfesor", query = "SELECT p FROM Profesor p WHERE p.celularProfesor = :celularProfesor"),
    @NamedQuery(name = "Profesor.findByFechanacimientoProfesor", query = "SELECT p FROM Profesor p WHERE p.fechanacimientoProfesor = :fechanacimientoProfesor"),
    @NamedQuery(name = "Profesor.findBySexoProfesor", query = "SELECT p FROM Profesor p WHERE p.sexoProfesor = :sexoProfesor")})
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_PROFESOR")
    private Integer codigoProfesor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA_PROFESOR")
    private long cedulaProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_PROFESOR")
    private String nombreProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDOPATERNO_PROFESOR")
    private String apellidopaternoProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDOMATERNO_PROFESOR")
    private String apellidomaternoProfesor;
    @Size(max = 100)
    @Column(name = "CORREO_PROFESOR")
    private String correoProfesor;
    @Column(name = "TELEFONO_PROFESOR")
    private Integer telefonoProfesor;
    @Column(name = "CELULAR_PROFESOR")
    private Integer celularProfesor;
    @Column(name = "FECHANACIMIENTO_PROFESOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimientoProfesor;
    @Size(max = 1)
    @Column(name = "SEXO_PROFESOR")
    private String sexoProfesor;
    @JoinColumn(name = "ID_FACULTAD", referencedColumnName = "ID_FACULTAD")
    @ManyToOne(optional = false)
    private Facultad idFacultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProfesor")
    private Collection<Familia> familiaCollection;

    public Profesor() {
    }

    public Profesor(Integer codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public Profesor(Integer codigoProfesor, long cedulaProfesor, String nombreProfesor, String apellidopaternoProfesor, String apellidomaternoProfesor) {
        this.codigoProfesor = codigoProfesor;
        this.cedulaProfesor = cedulaProfesor;
        this.nombreProfesor = nombreProfesor;
        this.apellidopaternoProfesor = apellidopaternoProfesor;
        this.apellidomaternoProfesor = apellidomaternoProfesor;
    }

    public Integer getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Integer codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public long getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(long cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidopaternoProfesor() {
        return apellidopaternoProfesor;
    }

    public void setApellidopaternoProfesor(String apellidopaternoProfesor) {
        this.apellidopaternoProfesor = apellidopaternoProfesor;
    }

    public String getApellidomaternoProfesor() {
        return apellidomaternoProfesor;
    }

    public void setApellidomaternoProfesor(String apellidomaternoProfesor) {
        this.apellidomaternoProfesor = apellidomaternoProfesor;
    }

    public String getCorreoProfesor() {
        return correoProfesor;
    }

    public void setCorreoProfesor(String correoProfesor) {
        this.correoProfesor = correoProfesor;
    }

    public Integer getTelefonoProfesor() {
        return telefonoProfesor;
    }

    public void setTelefonoProfesor(Integer telefonoProfesor) {
        this.telefonoProfesor = telefonoProfesor;
    }

    public Integer getCelularProfesor() {
        return celularProfesor;
    }

    public void setCelularProfesor(Integer celularProfesor) {
        this.celularProfesor = celularProfesor;
    }

    public Date getFechanacimientoProfesor() {
        return fechanacimientoProfesor;
    }

    public void setFechanacimientoProfesor(Date fechanacimientoProfesor) {
        this.fechanacimientoProfesor = fechanacimientoProfesor;
    }

    public String getSexoProfesor() {
        return sexoProfesor;
    }

    public void setSexoProfesor(String sexoProfesor) {
        this.sexoProfesor = sexoProfesor;
    }

    public Facultad getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultad idFacultad) {
        this.idFacultad = idFacultad;
    }

    @XmlTransient
    public Collection<Familia> getFamiliaCollection() {
        return familiaCollection;
    }

    public void setFamiliaCollection(Collection<Familia> familiaCollection) {
        this.familiaCollection = familiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProfesor != null ? codigoProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.codigoProfesor == null && other.codigoProfesor != null) || (this.codigoProfesor != null && !this.codigoProfesor.equals(other.codigoProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Profesor[ codigoProfesor=" + codigoProfesor + " ]";
    }
    
}
