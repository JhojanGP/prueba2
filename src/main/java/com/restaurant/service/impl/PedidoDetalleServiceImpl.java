/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.dao.PedidoDetalleDao;
import com.restaurant.modelo.Pedido;
import com.restaurant.modelo.PedidoDetalle;
import com.restaurant.service.PedidoDetalleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("pedidoDetalleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PedidoDetalleServiceImpl implements PedidoDetalleService{
    
    @Autowired
    private PedidoDetalleDao pedidoDetalleDao;

        
        public ArrayList<PedidoDetalle> pedidoDetalle() {
		return pedidoDetalleDao.pedidoDetalle();
	}

        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void savePedidoDetalle(PedidoDetalle pedDet) {         
		pedidoDetalleDao.savePedidoDetalle(pedDet);
	}
        
        public ArrayList<PedidoDetalle> Cuenta(Pedido pd) {
		return pedidoDetalleDao.Cuenta(pd);
	}
        
        public ArrayList<PedidoDetalle> buscarPedidoDetalle(Pedido pedido) {
		return pedidoDetalleDao.buscarPedidoDetalle(pedido);
	}
        
        public List<PedidoDetalle> listaPedidoDetalleId(PedidoDetalle pd) {
		return pedidoDetalleDao.listaPedidoDetalleId(pd);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updatePD(PedidoDetalle pd) {         
		pedidoDetalleDao.updatePD(pd);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePD(int id) {         
		pedidoDetalleDao.deletePD(id);
	}
        
         public ArrayList<PedidoDetalle> buscarProductoRepetido(PedidoDetalle pd) {
		return pedidoDetalleDao.buscarProductoRepetido(pd);
	}
         
        
        
    
}
