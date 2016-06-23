/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.CajaDao;
import com.restaurant.modelo.Caja;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository ("cajaDao")
public class CajaDaoImpl implements CajaDao{
    
    protected final Log logger = LogFactory.getLog(CajaDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        public void saveRegistroCaja(Caja registro) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(registro); }
            catch (Exception e) { logger.info("Mensage de Error en saveRegistroCaja() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<Caja> listarRegistrosCaja(){
        ArrayList<Caja> resultado=null;
	try {           
            resultado= (ArrayList<Caja>) sessionFactory.getCurrentSession().createQuery("select c from Caja as c  order by c.idCaja asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en listarRegistrosCaja() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}  
        
        

        
    
}
