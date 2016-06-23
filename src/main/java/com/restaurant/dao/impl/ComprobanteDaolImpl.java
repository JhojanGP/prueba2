/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.ComprobanteDao;
import com.restaurant.modelo.Comprobante;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository ("comprobanteDao")
public class ComprobanteDaolImpl implements ComprobanteDao{
    
    protected final Log logger = LogFactory.getLog(ComprobanteDaolImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        public void updateComprobante(Comprobante comprobante){
            
	    try { sessionFactory.getCurrentSession().update(comprobante); }
            catch (Exception e) { logger.info("Mensage de Error en updateComprobante() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        @SuppressWarnings("unchecked")
	public ArrayList<Comprobante> TipoComprobante(){
        ArrayList<Comprobante> resultado=null;
	try {           
            resultado= (ArrayList<Comprobante>) sessionFactory.getCurrentSession().createQuery("select tc from Comprobante as tc  order by tc.idComprobante asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en TipoComprobante() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
    
}
