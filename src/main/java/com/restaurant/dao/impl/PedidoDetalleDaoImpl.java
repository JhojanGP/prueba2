/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.PedidoDetalleDao;
import com.restaurant.modelo.Pedido;
import com.restaurant.modelo.PedidoDetalle;
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


@Repository ("pedidoDetalleDao")
public class PedidoDetalleDaoImpl implements PedidoDetalleDao{
    
    protected final Log logger = LogFactory.getLog(PedidoDetalleDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        @SuppressWarnings("unchecked")
	public ArrayList<PedidoDetalle> pedidoDetalle(){
        ArrayList<PedidoDetalle> resultado=null;
	try {           
            resultado= (ArrayList<PedidoDetalle>) sessionFactory.getCurrentSession().createQuery("select pd from PedidoDetalle as pd group by pd.idPedido")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en pedidoDetalle() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        public void savePedidoDetalle(PedidoDetalle pedDet) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(pedDet); }
            catch (Exception e) { logger.info("Mensage de Error en savePedidoDetalle() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<PedidoDetalle> Cuenta(Pedido pd){
        ArrayList<PedidoDetalle> resultado=null;
        
	try {           
            resultado= (ArrayList<PedidoDetalle>) sessionFactory.getCurrentSession().createQuery("select new map(pd.idPedido as idPedido,pd.idProducto as idProducto, pd.cantidadProducto as cantidadProducto, sum(pd.idProducto.precio*pd.cantidadProducto) as total) from PedidoDetalle as pd join pd.idPedido as p where upper (p.idPedido) like upper(?) group by pd.idPedido")
                    .setString(0,pd.getIdPedido().toString()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarPedidoDetalle() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<PedidoDetalle> buscarPedidoDetalle(Pedido pedido){
        ArrayList<PedidoDetalle> resultado=null;
        
	try {           
            resultado= (ArrayList<PedidoDetalle>) sessionFactory.getCurrentSession().createQuery("from PedidoDetalle pd where pd.idPedido = :idPedido order by pd.idPedido asc ")
                    .setInteger("idPedido",pedido.getIdPedido())
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarPedidoDetalle() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}

        
        @SuppressWarnings("unchecked")        
        public List<PedidoDetalle> listaPedidoDetalleId(PedidoDetalle pd) {
            
		return (List<PedidoDetalle>) sessionFactory.getCurrentSession().createCriteria(PedidoDetalle.class)
                        .add(Expression.eq("idPedidoDetalle", pd.getIdPedidoDetalle())).list();
                
	}
        
        public void updatePD(PedidoDetalle pd){
	    try { sessionFactory.getCurrentSession().update(pd); }
            catch (Exception e) { logger.info("Mensage de Error en updatePD "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        public void deletePD(int id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();                
                session.delete((PedidoDetalle)session.get(PedidoDetalle.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deletePD() "+e.getMessage());   }
            finally{  session.close();   }
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<PedidoDetalle> buscarProductoRepetido(PedidoDetalle pd){
        ArrayList<PedidoDetalle> resultado=null;

        
	try {           
            resultado= (ArrayList<PedidoDetalle>) sessionFactory.getCurrentSession().createQuery("from PedidoDetalle pd where pd.idPedido =:idPedido and pd.idProducto =:idProducto order by pd.idPedidoDetalle asc ")
                    .setInteger("idPedido", pd.getIdPedido().getIdPedido())
                    .setInteger("idProducto", pd.getIdProducto().getIdProducto())
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarProductoRepetido() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
 
}
