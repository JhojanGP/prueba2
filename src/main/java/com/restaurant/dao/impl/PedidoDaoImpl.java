/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.PedidoDao;
import com.restaurant.modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository ("pedidoDao")
public class PedidoDaoImpl implements PedidoDao{
    
    protected final Log logger = LogFactory.getLog(PedidoDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        
        @SuppressWarnings("unchecked")
	public ArrayList<Pedido> PedidosGcocina(){
        ArrayList<Pedido> resultado=null;
	try {           
            resultado= (ArrayList<Pedido>) sessionFactory.getCurrentSession().createQuery("select p from Pedido as p  order by p.idPedido asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en PedidosGcocina() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
       
        
        public void updatePedido(Pedido pedido){
	    try { sessionFactory.getCurrentSession().update(pedido); }
            catch (Exception e) { logger.info("Mensage de Error en updatePedido() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        @SuppressWarnings("unchecked")
	public ArrayList<Pedido> PedidosG(){
        ArrayList<Pedido> resultado=null;
	try {           
            resultado= (ArrayList<Pedido>) sessionFactory.getCurrentSession().createQuery("select p from Pedido as p  order by p.idPedido asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en PedidosG() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        @SuppressWarnings("unchecked")        
        public List<Pedido> buscarPedido(Pedido ped) {
            
		return (List<Pedido>) sessionFactory.getCurrentSession().createCriteria(Pedido.class)
                        .add(Expression.eq("idPedido", ped.getIdPedido())).list();
                
	}
        
       
        
        @SuppressWarnings("unchecked")
	public ArrayList<Pedido> buscarPedidoXMesa(Pedido pedido){
        ArrayList<Pedido> resultado=null;
        
	try {           
            resultado= (ArrayList<Pedido>) sessionFactory.getCurrentSession().createQuery("from Pedido p where upper(p.idMesa) like upper(?) order by p.idPedido asc ")
                    .setString(0,pedido.getIdMesa().getIdMesa().toString()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarPedido() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        public void savePedido(Pedido pedido) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(pedido); }
            catch (Exception e) { logger.info("Mensage de Error en savePedido() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        public void deletePedido(int id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();                
                session.delete((Pedido)session.get(Pedido.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deletePedido() "+e.getMessage());   }
            finally{  session.close();   }
	}
        
        
    
}
