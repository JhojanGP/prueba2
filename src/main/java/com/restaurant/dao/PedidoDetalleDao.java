/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao;

import com.restaurant.modelo.Pedido;
import com.restaurant.modelo.PedidoDetalle;
import java.util.ArrayList;
import java.util.List;

public interface PedidoDetalleDao {
    
   
    public ArrayList<PedidoDetalle> pedidoDetalle();
    public void savePedidoDetalle(PedidoDetalle pedDet);
    public ArrayList<PedidoDetalle> Cuenta(Pedido pd);
    public ArrayList<PedidoDetalle> buscarPedidoDetalle(Pedido pedido);
    public List<PedidoDetalle> listaPedidoDetalleId(PedidoDetalle pd);
    public void updatePD(PedidoDetalle pd);
    public void deletePD(int id);
    public ArrayList<PedidoDetalle> buscarProductoRepetido(PedidoDetalle pd);
   
   
    
}
