/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.modelo;

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
 * @author Keima
 */
@Entity
@Table(name = "movimiento_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimientoDetalle.findAll", query = "SELECT m FROM MovimientoDetalle m"),
    @NamedQuery(name = "MovimientoDetalle.findByIdMovimientoDetalle", query = "SELECT m FROM MovimientoDetalle m WHERE m.idMovimientoDetalle = :idMovimientoDetalle"),
    @NamedQuery(name = "MovimientoDetalle.findByConcepto", query = "SELECT m FROM MovimientoDetalle m WHERE m.concepto = :concepto"),
    @NamedQuery(name = "MovimientoDetalle.findByMonto", query = "SELECT m FROM MovimientoDetalle m WHERE m.monto = :monto"),
    @NamedQuery(name = "MovimientoDetalle.findByDescripcion", query = "SELECT m FROM MovimientoDetalle m WHERE m.descripcion = :descripcion")})
public class MovimientoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimiento_detalle")
    private Integer idMovimientoDetalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "concepto")
    private String concepto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private float monto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_cierre_caja", referencedColumnName = "id_cierre_caja")
    @ManyToOne(optional = false)
    private CierreCaja idCierreCaja;
    @JoinColumn(name = "id_tipo_movimiento", referencedColumnName = "id_tipo_movimiento")
    @ManyToOne(optional = false)
    private TipoMovimiento idTipoMovimiento;

    public MovimientoDetalle() {
    }

    public MovimientoDetalle(Integer idMovimientoDetalle) {
        this.idMovimientoDetalle = idMovimientoDetalle;
    }

    public MovimientoDetalle(Integer idMovimientoDetalle, String concepto, float monto, String descripcion) {
        this.idMovimientoDetalle = idMovimientoDetalle;
        this.concepto = concepto;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Integer getIdMovimientoDetalle() {
        return idMovimientoDetalle;
    }

    public void setIdMovimientoDetalle(Integer idMovimientoDetalle) {
        this.idMovimientoDetalle = idMovimientoDetalle;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CierreCaja getIdCierreCaja() {
        return idCierreCaja;
    }

    public void setIdCierreCaja(CierreCaja idCierreCaja) {
        this.idCierreCaja = idCierreCaja;
    }

    public TipoMovimiento getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(TipoMovimiento idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimientoDetalle != null ? idMovimientoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoDetalle)) {
            return false;
        }
        MovimientoDetalle other = (MovimientoDetalle) object;
        if ((this.idMovimientoDetalle == null && other.idMovimientoDetalle != null) || (this.idMovimientoDetalle != null && !this.idMovimientoDetalle.equals(other.idMovimientoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.restaurant.modelo.MovimientoDetalle[ idMovimientoDetalle=" + idMovimientoDetalle + " ]";
    }
    
}
