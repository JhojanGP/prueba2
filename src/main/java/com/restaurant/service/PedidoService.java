/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service;

import com.restaurant.modelo.Pedido;
import java.util.ArrayList;
import java.util.List;

public interface PedidoService {
    
    public ArrayList<Pedido> PedidosG() ;
    public List<Pedido> buscarPedido(Pedido ped) ;
    public ArrayList<Pedido> PedidosGcocina() ;
    public void updatePedido(Pedido pedido) ;
    public void savePedido(Pedido pedido);
    public ArrayList<Pedido> buscarPedidoXMesa(Pedido pedido) ;
    public void deletePedido(int id) ;
    
}
