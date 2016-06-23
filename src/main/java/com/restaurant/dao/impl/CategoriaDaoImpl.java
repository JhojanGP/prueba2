/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.CategoriaDao;
import com.restaurant.modelo.Categoria;
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


@Repository ("categoriaDao")
public class CategoriaDaoImpl implements CategoriaDao{
    
     protected final Log logger = LogFactory.getLog(CategoriaDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        
        @SuppressWarnings("unchecked")
	public ArrayList<Categoria> buscarNombreCategoria(Categoria categoria){
        ArrayList<Categoria> resultado=null;
	try {           
            resultado= (ArrayList<Categoria>) sessionFactory.getCurrentSession().createQuery("from Categoria c where upper(c.nombre) like upper(?) order by c.nombre asc ")
                    .setString(0,categoria.getNombre()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreCategoria() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}     
        @SuppressWarnings("unchecked")
        public void saveCategoria(Categoria categoria) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(categoria); }
            catch (Exception e) { logger.info("Mensage de Error en saveCategoria() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<Categoria> buscarCategorias(){
        ArrayList<Categoria> resultado=null;
	try {           
            resultado= (ArrayList<Categoria>) sessionFactory.getCurrentSession().createQuery("select c from Categoria as c  order by c.nombre asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarCategorias() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        
        @SuppressWarnings("unchecked")        
        public List<Categoria> listaCategoriaId(Categoria categoria) {
            
		return (List<Categoria>) sessionFactory.getCurrentSession().createCriteria(Categoria.class)
                        .add(Expression.eq("idCategoria", categoria.getIdCategoria())).list();
                
	}
        
        public void updateCategoria(Categoria categoria){
	    try { sessionFactory.getCurrentSession().update(categoria); }
            catch (Exception e) { logger.info("Mensage de Error en updateCategoria() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        public void deleteCategoria(int id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();                
                session.delete((Categoria)session.get(Categoria.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteCategoria() "+e.getMessage());   }
            finally{  session.close();   }
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<Categoria> buscarCategoriasId(){
        ArrayList<Categoria> resultado=null;
	try {           
            resultado= (ArrayList<Categoria>) sessionFactory.getCurrentSession().createQuery("select c from Categoria as c  order by c.idCategoria asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarCategorias() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}

    
}
