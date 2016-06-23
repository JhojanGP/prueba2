/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.dao.CajaDao;
import com.restaurant.modelo.Caja;
import com.restaurant.service.CajaService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cajaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CajaServiceImpl implements CajaService{
    
    @Autowired
    private CajaDao cajaDao;

        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveRegistroCaja(Caja caja) {         
		cajaDao.saveRegistroCaja(caja);
	}
        
        public ArrayList<Caja> listarRegistrosCaja() {
		return cajaDao.listarRegistrosCaja();
	}

    
}
