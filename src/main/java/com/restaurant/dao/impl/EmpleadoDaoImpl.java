/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.restaurant.dao.impl;

import com.restaurant.dao.EmpleadoDao;
import com.restaurant.modelo.Empleado;
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




@Repository ("empleadoDao")
public class EmpleadoDaoImpl implements EmpleadoDao{
    
    protected final Log logger = LogFactory.getLog(EmpleadoDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory; 
        
        @SuppressWarnings("unchecked")
	public List<Empleado> validarEmpleado(Empleado empleado){
        List<Empleado> resultado=null;   String user=empleado.getUsuario(); String password=empleado.getPassword();
	try {           
           resultado= (List<Empleado>) sessionFactory.getCurrentSession().createCriteria(Empleado.class)
                                                 .add(Expression.eq("usuario", user) )
                                                 .add(Expression.eq("password", password)).list();                      
          
            }catch (Exception e) { logger.info("Mensage de Error en validarEmpleado() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
       
        public void saveEmpleado(Empleado empleado) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(empleado); }
            catch (Exception e) { logger.info("Mensage de Error en saveEmpleado() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
       	
	public void deleteEmpleado(int id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();                
                session.delete((Empleado)session.get(Empleado.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteEmpleado() "+e.getMessage());   }
            finally{  session.close();   }
	}
        
        
        public void updateEmpleado(Empleado empleado){
	    try { sessionFactory.getCurrentSession().update(empleado); }
            catch (Exception e) { logger.info("Mensage de Error en updateEmpleado(Empleado empleado) "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
       
	
	@SuppressWarnings("unchecked")        
        public List<Empleado> listaEmpleadoId(Empleado empleado) {
            
		return (List<Empleado>) sessionFactory.getCurrentSession().createCriteria(Empleado.class)
                        .add(Expression.eq("idEmpleado", empleado.getIdEmpleado())).list();
                
	}

        
        @SuppressWarnings("unchecked")
	public ArrayList<Empleado> buscarEmpleados(Empleado empleado){
        ArrayList<Empleado> resultado=null;
	try {
            if(empleado.getApPaterno()!=null){
            resultado= (ArrayList<Empleado>) sessionFactory.getCurrentSession().createQuery("from Empleado e where upper(e.apPaterno) like upper(?) order by e.apPaterno asc ")
                    .setString(0,empleado.getApPaterno()+"%")
                    .list();
            }else{
                    if(empleado.getIdEmpleado()!=null){
                        resultado= (ArrayList<Empleado>) sessionFactory.getCurrentSession().createQuery("from Empleado e where e.idEmpleado = :idEmpleado order by e.idEmpleado asc ")
                        .setInteger("idEmpleado",empleado.getIdEmpleado())
                        .list();
                        
                    }
                }
            }catch (Exception e) { logger.info("Mensage de Error en buscarEmpleados() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}   
        
        
        
        
    
}
