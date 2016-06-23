/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;


import com.restaurant.modelo.Producto;
import com.restaurant.dao.ProductoDao;
import com.restaurant.modelo.Categoria;
import com.restaurant.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("productoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDao productoDao;
    
    public ArrayList<Producto> buscarNombreProducto(Producto producto) {
		return productoDao.buscarNombreProducto(producto);
	}
    
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveProducto(Producto producto) {         
		productoDao.saveProducto(producto);
	}
 
        
        public List<Producto> listaProductoId(Producto producto) {
		return productoDao.listaProductoId(producto);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateProducto(Producto producto) {         
		productoDao.updateProducto(producto);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteProducto(int id) {         
		productoDao.deleteProducto(id);
	}
        
        public ArrayList<Producto> buscarProductoXCategoria(Categoria categoria) {
		return productoDao.buscarProductoXCategoria(categoria);
	}
        
        public ArrayList<Producto> listarProductos() {
		return productoDao.listarProductos();
	}
        
        public ArrayList<Producto> buscarProducto(Producto producto) {
		return productoDao.buscarProducto(producto);
	}
        
        public ArrayList<Producto> buscarProductoCAT(Categoria categoria) {
		return productoDao.buscarProductoCAT(categoria);
	}
}
