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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Keima
 */
@Entity
@Table(name = "pedido_extra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoExtra.findAll", query = "SELECT p FROM PedidoExtra p"),
    @NamedQuery(name = "PedidoExtra.findByIdPedidoExtra", query = "SELECT p FROM PedidoExtra p WHERE p.idPedidoExtra = :idPedidoExtra")})
public class PedidoExtra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido_extra")
    private Integer idPedidoExtra;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Pedido idPedido;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public PedidoExtra() {
    }

    public PedidoExtra(Integer idPedidoExtra) {
        this.idPedidoExtra = idPedidoExtra;
    }

    public Integer getIdPedidoExtra() {
        return idPedidoExtra;
    }

    public void setIdPedidoExtra(Integer idPedidoExtra) {
        this.idPedidoExtra = idPedidoExtra;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoExtra != null ? idPedidoExtra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoExtra)) {
            return false;
        }
        PedidoExtra other = (PedidoExtra) object;
        if ((this.idPedidoExtra == null && other.idPedidoExtra != null) || (this.idPedidoExtra != null && !this.idPedidoExtra.equals(other.idPedidoExtra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.restaurant.modelo.PedidoExtra[ idPedidoExtra=" + idPedidoExtra + " ]";
    }
    
}
