/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.dao.PedidoDao;
import com.restaurant.modelo.Pedido;
import com.restaurant.service.PedidoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("pedidoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PedidoServiceImpl implements PedidoService{
    
    @Autowired
    private PedidoDao pedidoDao;
    
        public ArrayList<Pedido> PedidosGcocina() {
		return pedidoDao.PedidosGcocina();
	}
        
         @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updatePedido(Pedido pedido) {         
		pedidoDao.updatePedido(pedido);
	}
        
        public ArrayList<Pedido> PedidosG() {
		return pedidoDao.PedidosG();
	}
        
        public List<Pedido> buscarPedido(Pedido ped) {
		return pedidoDao.buscarPedido(ped);
	}
        
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void savePedido(Pedido pedido) {         
		pedidoDao.savePedido(pedido);
	}
        
        public ArrayList<Pedido> buscarPedidoXMesa(Pedido pedido) {
		return pedidoDao.buscarPedidoXMesa(pedido);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePedido(int id) {         
		pedidoDao.deletePedido(id);
	}
    
}
