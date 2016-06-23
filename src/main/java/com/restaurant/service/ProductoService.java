/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service;

import com.restaurant.modelo.Categoria;
import com.restaurant.modelo.Producto;
import java.util.ArrayList;
import java.util.List;


public interface ProductoService {
    
    public ArrayList<Producto> buscarNombreProducto(Producto producto) ;
    public void saveProducto(Producto producto);
    public List<Producto> listaProductoId(Producto producto);
    public void updateProducto(Producto producto) ;  
    public void deleteProducto(int id) ;
    public ArrayList<Producto> buscarProductoXCategoria(Categoria categoria);
    public ArrayList<Producto> listarProductos();
    public ArrayList<Producto> buscarProducto(Producto producto);
    public ArrayList<Producto> buscarProductoCAT(Categoria categoria);
    
}
