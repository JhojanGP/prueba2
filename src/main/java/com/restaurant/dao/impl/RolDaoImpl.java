/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.RolDao;
import com.restaurant.modelo.Rol;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("rolDao")
public class RolDaoImpl implements RolDao{
    
    protected final Log logger = LogFactory.getLog(RolDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        @SuppressWarnings("unchecked")
	public ArrayList<Rol> buscarRoles(){
        ArrayList<Rol> resultado=null;
	try {           
            resultado= (ArrayList<Rol>) sessionFactory.getCurrentSession().createQuery("select r from Rol as r  order by r.idRol asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarRoles() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
    
}
