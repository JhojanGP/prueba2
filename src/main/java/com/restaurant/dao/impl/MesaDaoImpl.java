/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.MesaDao;
import com.restaurant.modelo.Mesa;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository ("mesaDao")
public class MesaDaoImpl implements MesaDao{
    
    protected final Log logger = LogFactory.getLog(MesaDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
    
        @SuppressWarnings("unchecked")
	public ArrayList<Mesa> Mesas(){
        ArrayList<Mesa> resultado=null;
	try {           
            resultado= (ArrayList<Mesa>) sessionFactory.getCurrentSession().createQuery("select m from Mesa as m  order by m.idMesa asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en Mesas() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        public void updateMesa(Mesa mesa){
	    try { sessionFactory.getCurrentSession().update(mesa); }
            catch (Exception e) { logger.info("Mensage de Error en updateMesa(Mesa mesa) "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        
    
}
