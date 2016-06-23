/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao.impl;

import com.restaurant.dao.ProductoDao;
import com.restaurant.modelo.Categoria;
import com.restaurant.modelo.Producto;
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

@Repository ("productoDao")
public class ProductoDaoImpl implements ProductoDao{
    
     protected final Log logger = LogFactory.getLog(ProductoDaoImpl.class);  	
	
        @Autowired
        private SessionFactory sessionFactory;
        
        @SuppressWarnings("unchecked")
	public ArrayList<Producto> buscarNombreProducto(Producto producto){
        ArrayList<Producto> resultado=null;
	try {           
            resultado= (ArrayList<Producto>) sessionFactory.getCurrentSession().createQuery("from Producto p where upper(p.nombre) like upper(?) order by p.nombre asc ")
                    .setString(0,producto.getNombre()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreProducto() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}       
        
        
    
        public void saveProducto(Producto producto) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(producto); }
            catch (Exception e) { logger.info("Mensage de Error en saveProducto() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        
        @SuppressWarnings("unchecked")        
        public List<Producto> listaProductoId(Producto producto) {
            
		return (List<Producto>) sessionFactory.getCurrentSession().createCriteria(Producto.class)
                        .add(Expression.eq("idProducto", producto.getIdProducto())).list();
                
	}
        
        public void updateProducto(Producto producto){
	    try { sessionFactory.getCurrentSession().update(producto); }
            catch (Exception e) { logger.info("Mensage de Error en updateProducto(Producto producto) "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        public void deleteProducto(int id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();                
                session.delete((Producto)session.get(Producto.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteProducto() "+e.getMessage());   }
            finally{  session.close();   }
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<Producto> buscarProductoXCategoria(Categoria categoria){
        ArrayList<Producto> resultado=null;
        
	try {           
            resultado= (ArrayList<Producto>) sessionFactory.getCurrentSession().createQuery("from Producto p where p.idCategoria = :idCategoria order by p.nombre asc ")
                    .setInteger("idCategoria",categoria.getIdCategoria())
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarProductoXCategoria() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        
        
        @SuppressWarnings("unchecked")
	public ArrayList<Producto> listarProductos(){
        ArrayList<Producto> resultado=null;
	try {           
            resultado= (ArrayList<Producto>) sessionFactory.getCurrentSession().createQuery("select p from Producto as p  order by p.nombre asc ")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en listarProductos() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<Producto> buscarProducto(Producto producto){
        ArrayList<Producto> resultado=null;


	try {           
            resultado= (ArrayList<Producto>) sessionFactory.getCurrentSession().createQuery("from Producto p where p.idCategoria =:idCategoria and p.nombre =:nombre order by p.idProducto asc ")
                    .setInteger("idCategoria", producto.getIdCategoria().getIdCategoria())
                    .setString("nombre", producto.getNombre())
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarProducto() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        @SuppressWarnings("unchecked")
	public ArrayList<Producto> buscarProductoCAT(Categoria categoria){
        ArrayList<Producto> resultado=null;
	try {           
            resultado= (ArrayList<Producto>) sessionFactory.getCurrentSession().createQuery("from Producto p where p.idCategoria = :idCategoria order by p.idProducto asc ")
                    .setInteger("idCategoria", categoria.getIdCategoria())
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarProductos() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}

}
