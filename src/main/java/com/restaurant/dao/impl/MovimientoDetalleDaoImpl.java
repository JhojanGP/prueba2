/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.MovimientoDetalleDao;
import com.restaurant.modelo.MovimientoDetalle;
import java.util.ArrayList;
import org.apache.commons.logging.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository ("movimientoDetalleDao")
public class MovimientoDetalleDaoImpl implements MovimientoDetalleDao{
    
    protected final Log logger = LogFactory.getLog(MovimientoDetalleDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        @SuppressWarnings("unchecked")
	public ArrayList<MovimientoDetalle> listarMovimientos(){
        ArrayList<MovimientoDetalle> resultado=null;
	try {           
            resultado= (ArrayList<MovimientoDetalle>) sessionFactory.getCurrentSession().createQuery("select m from MovimientoDetalle as m  order by m.idMovimientoDetalle asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en listarMovimientos() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
    
}
