/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.CierreCajaDao;
import com.restaurant.modelo.CierreCaja;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository ("cierreCajaDao")
public class CierreCajaDaoImpl implements CierreCajaDao{
    
    protected final Log logger = LogFactory.getLog(CierreCajaDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        @SuppressWarnings("unchecked")
	public ArrayList<CierreCaja> buscarCierreCaja(){
        ArrayList<CierreCaja> resultado=null;
	try {           
            resultado= (ArrayList<CierreCaja>) sessionFactory.getCurrentSession().createQuery("select c from CierreCaja as c  order by c.idCierreCaja asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarCierreCajas() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
    
}
