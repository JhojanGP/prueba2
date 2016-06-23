/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.dao.MesaDao;
import com.restaurant.modelo.Mesa;
import com.restaurant.service.MesaService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("mesaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MesaServiceImpl implements MesaService{
    
    @Autowired
    private MesaDao mesaDao;
    
        public ArrayList<Mesa> Mesas() {
		return mesaDao.Mesas();
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateMesa(Mesa mesa) {         
		mesaDao.updateMesa(mesa);
	}
    
}
