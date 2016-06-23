/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.dao.ComprobanteDao;
import com.restaurant.modelo.Comprobante;
import com.restaurant.service.ComprobanteService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("comprobanteService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ComprobanteServiceImpl implements ComprobanteService{
    
    @Autowired
    private ComprobanteDao comprobanteDao;
    
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateComprobante(Comprobante comprobante) {         
		comprobanteDao.updateComprobante(comprobante);
	}
        
        public ArrayList<Comprobante> TipoComprobante() {
		return comprobanteDao.TipoComprobante();
	}
    
}
