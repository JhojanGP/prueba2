/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.dao.RolDao;
import com.restaurant.modelo.Rol;
import com.restaurant.service.RolService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("rolService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class RolServiceImpl implements RolService{
    
    @Autowired
    private RolDao rolDao;
    
        public ArrayList<Rol> buscarRoles() {
		return rolDao.buscarRoles();
	}
    
}
