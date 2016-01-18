/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Roberto
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByCedulaProfesor", query = "SELECT p FROM Profesor p WHERE p.cedulaProfesor = :cedulaProfesor"),
    @NamedQuery(name = "Profesor.findByNombreProfesor", query = "SELECT p FROM Profesor p WHERE p.nombreProfesor = :nombreProfesor"),
    @NamedQuery(name = "Profesor.findByApellidoProfesor", query = "SELECT p FROM Profesor p WHERE p.apellidoProfesor = :apellidoProfesor"),
    @NamedQuery(name = "Profesor.findByTelefonoProfesor", query = "SELECT p FROM Profesor p WHERE p.telefonoProfesor = :telefonoProfesor"),
    @NamedQuery(name = "Profesor.findByCelularProfesor", query = "SELECT p FROM Profesor p WHERE p.celularProfesor = :celularProfesor"),
    @NamedQuery(name = "Profesor.findByCorreoProfesor", query = "SELECT p FROM Profesor p WHERE p.correoProfesor = :correoProfesor")})
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
    private Long cedulaProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_PROFESOR")
    private String nombreProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDO_PROFESOR")
    private String apellidoProfesor;
    @Column(name = "TELEFONO_PROFESOR")
    private Integer telefonoProfesor;
    @Column(name = "CELULAR_PROFESOR")
    private Integer celularProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO_PROFESOR")
    private String correoProfesor;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    
    @JoinColumn(name = "ID_FACULTAD", referencedColumnName = "ID_FACULTAD")
    @ManyToOne(optional = false,cascade = CascadeType.PERSIST)
    private Facultad idFacultad;

    public Profesor() {
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
    public Profesor(Long cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    public Integer getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Integer codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    
    public Profesor(Integer codigoProfesor, Long cedulaProfesor, String nombreProfesor, String apellidoProfesor, String correoProfesor, String sexo, Date fechaNacimiento) {
        this.codigoProfesor=codigoProfesor;
        this.cedulaProfesor = cedulaProfesor;
        this.nombreProfesor = nombreProfesor;
        this.apellidoProfesor = apellidoProfesor;
        this.correoProfesor = correoProfesor;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(Long cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
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

    public String getCorreoProfesor() {
        return correoProfesor;
    }

    public void setCorreoProfesor(String correoProfesor) {
        this.correoProfesor = correoProfesor;
    }

    public Facultad getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultad idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaProfesor != null ? cedulaProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.cedulaProfesor == null && other.cedulaProfesor != null) || (this.cedulaProfesor != null && !this.cedulaProfesor.equals(other.cedulaProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Profesor[ cedulaProfesor=" + cedulaProfesor + " ]";
    }
}
