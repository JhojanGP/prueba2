/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Keima
 */
@Entity
@Table(name = "cierre_caja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CierreCaja.findAll", query = "SELECT c FROM CierreCaja c"),
    @NamedQuery(name = "CierreCaja.findByIdCierreCaja", query = "SELECT c FROM CierreCaja c WHERE c.idCierreCaja = :idCierreCaja"),
    @NamedQuery(name = "CierreCaja.findByFecha", query = "SELECT c FROM CierreCaja c WHERE c.fecha = :fecha")})
public class CierreCaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cierre_caja")
    private Integer idCierreCaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCierreCaja")
    private Collection<MovimientoDetalle> movimientoDetalleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCierreCaja")
    private Collection<Caja> cajaCollection;

    public CierreCaja() {
    }

    public CierreCaja(Integer idCierreCaja) {
        this.idCierreCaja = idCierreCaja;
    }

    public CierreCaja(Integer idCierreCaja, Date fecha) {
        this.idCierreCaja = idCierreCaja;
        this.fecha = fecha;
    }

    public Integer getIdCierreCaja() {
        return idCierreCaja;
    }

    public void setIdCierreCaja(Integer idCierreCaja) {
        this.idCierreCaja = idCierreCaja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<MovimientoDetalle> getMovimientoDetalleCollection() {
        return movimientoDetalleCollection;
    }

    public void setMovimientoDetalleCollection(Collection<MovimientoDetalle> movimientoDetalleCollection) {
        this.movimientoDetalleCollection = movimientoDetalleCollection;
    }

    @XmlTransient
    public Collection<Caja> getCajaCollection() {
        return cajaCollection;
    }

    public void setCajaCollection(Collection<Caja> cajaCollection) {
        this.cajaCollection = cajaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCierreCaja != null ? idCierreCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CierreCaja)) {
            return false;
        }
        CierreCaja other = (CierreCaja) object;
        if ((this.idCierreCaja == null && other.idCierreCaja != null) || (this.idCierreCaja != null && !this.idCierreCaja.equals(other.idCierreCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.restaurant.modelo.CierreCaja[ idCierreCaja=" + idCierreCaja + " ]";
    }
    
}
