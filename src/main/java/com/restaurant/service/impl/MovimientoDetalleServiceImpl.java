/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.dao.MovimientoDetalleDao;
import com.restaurant.modelo.MovimientoDetalle;
import com.restaurant.service.MovimientoDetalleService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("movimientoDetalleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MovimientoDetalleServiceImpl implements MovimientoDetalleService{
    
    @Autowired
    MovimientoDetalleDao movimientoDetalleDao;
    
        public ArrayList<MovimientoDetalle> listarMovimientos() {
		return movimientoDetalleDao.listarMovimientos();
	}
    
    
    
}
