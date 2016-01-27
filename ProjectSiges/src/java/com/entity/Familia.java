/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Roberto
 */
@Entity
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f"),
    @NamedQuery(name = "Familia.findByIdFamilia", query = "SELECT f FROM Familia f WHERE f.idFamilia = :idFamilia"),
    @NamedQuery(name = "Familia.findByNombreFamilia", query = "SELECT f FROM Familia f WHERE f.nombreFamilia = :nombreFamilia"),
    @NamedQuery(name = "Familia.findByApellidoFamilia", query = "SELECT f FROM Familia f WHERE f.apellidoFamilia = :apellidoFamilia"),
    @NamedQuery(name = "Familia.findByTipoFamilia", query = "SELECT f FROM Familia f WHERE f.tipoFamilia = :tipoFamilia")})
public class Familia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FAMILIA")
    private Integer idFamilia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_FAMILIA")
    private String nombreFamilia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDO_FAMILIA")
    private String apellidoFamilia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO_FAMILIA")
    private String tipoFamilia;
    @JoinColumn(name = "CODIGO_PROFESOR", referencedColumnName = "CODIGO_PROFESOR")
    @ManyToOne(optional = false)
    private Profesor codigoProfesor;

    public Familia() {
    }

    public Familia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Familia(Integer idFamilia, String nombreFamilia, String apellidoFamilia, String tipoFamilia) {
        this.idFamilia = idFamilia;
        this.nombreFamilia = nombreFamilia;
        this.apellidoFamilia = apellidoFamilia;
        this.tipoFamilia = tipoFamilia;
    }

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public String getApellidoFamilia() {
        return apellidoFamilia;
    }

    public void setApellidoFamilia(String apellidoFamilia) {
        this.apellidoFamilia = apellidoFamilia;
    }

    public String getTipoFamilia() {
        return tipoFamilia;
    }

    public void setTipoFamilia(String tipoFamilia) {
        this.tipoFamilia = tipoFamilia;
    }

    public Profesor getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Profesor codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilia != null ? idFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.idFamilia == null && other.idFamilia != null) || (this.idFamilia != null && !this.idFamilia.equals(other.idFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Familia[ idFamilia=" + idFamilia + " ]";
    }
    
}
