/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;


import com.restaurant.dao.ClienteDao;
import com.restaurant.modelo.Cliente;
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

@Repository ("clienteDao")
public class ClienteDaoImpl implements ClienteDao{
    
    protected final Log logger = LogFactory.getLog(ClienteDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        @SuppressWarnings("unchecked")
	public ArrayList<Cliente> buscarCliente(Cliente cliente){

        ArrayList<Cliente> resultado=null;
            
	try {           
            if(cliente.getNombre()!=null){
                resultado= (ArrayList<Cliente>) sessionFactory.getCurrentSession().createQuery("from Cliente c where upper(c.nombre) like upper(?) order by c.nombre asc ")
                    .setString(0,cliente.getNombre()+"%")
                    .list();
            }else{
                if(cliente.getDocumento()!=null){
                    resultado= (ArrayList<Cliente>) sessionFactory.getCurrentSession().createQuery("from Cliente c where upper(c.documento) like upper(?) order by c.nombre asc ")
                        .setString(0,cliente.getDocumento()+"%")
                        .list();
                }else{
                    resultado= (ArrayList<Cliente>) sessionFactory.getCurrentSession().createQuery("select c from Cliente as c  order by c.nombre asc ")
                    .list();  
                    }
            }
            }catch (Exception e) { logger.info("Mensage de Error en buscarCliente() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        public void saveCliente(Cliente cliente) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(cliente); }
            catch (Exception e) { logger.info("Mensage de Error en saveCliente() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")        
        public List<Cliente> listaClienteId(Cliente cliente) {
            
		return (List<Cliente>) sessionFactory.getCurrentSession().createCriteria(Cliente.class)
                        .add(Expression.eq("idCliente", cliente.getIdCliente())).list();
                
	}
        
        public void updateCliente(Cliente cliente){
	    try { sessionFactory.getCurrentSession().update(cliente); }
            catch (Exception e) { logger.info("Mensage de Error en updateCliente() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        public void deleteCliente(int id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();                
                session.delete((Cliente)session.get(Cliente.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteCliente() "+e.getMessage());   }
            finally{  session.close();   }
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<Cliente> listarClientes(){
        ArrayList<Cliente> resultado=null;
	try {           
            resultado= (ArrayList<Cliente>) sessionFactory.getCurrentSession().createQuery("select c from Cliente as c  order by c.nombre asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarClientes() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<Cliente> buscarClienteEspecifico(Cliente cliente){

        ArrayList<Cliente> resultado=null;
            
	try {           
                     resultado= (ArrayList<Cliente>) sessionFactory.getCurrentSession().createQuery("from Cliente c where upper(c.documento) like upper(?) order by c.nombre asc ")
                        .setString(0,cliente.getDocumento()+"%")
                        .list();

            }catch (Exception e) { logger.info("Mensage de Error en buscarClienteEspecifico() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
    
}
