/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.dao.CierreCajaDao;
import com.restaurant.modelo.CierreCaja;
import com.restaurant.service.CierreCajaService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service("cierreCajaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CierreCajaServiceImpl implements CierreCajaService{
    
    
    @Autowired
    private CierreCajaDao cierreCajaDao;
    
        public ArrayList<CierreCaja> buscarCierreCaja() {
		return cierreCajaDao.buscarCierreCaja();
	}
    
    
    
}
