/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;


import com.restaurant.dao.CategoriaDao;
import com.restaurant.modelo.Categoria;
import com.restaurant.service.CategoriaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("categoriaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaDao categoriaDao;
    

        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveCategoria(Categoria categoria) {         
		categoriaDao.saveCategoria(categoria);
	}
    
        public ArrayList<Categoria> buscarCategorias() {
		return categoriaDao.buscarCategorias();
	}
        
        public List<Categoria> listaCategoriaId(Categoria categoria) {
		return categoriaDao.listaCategoriaId(categoria);
	}
        
        public ArrayList<Categoria> buscarNombreCategoria(Categoria categoria) {
		return categoriaDao.buscarNombreCategoria(categoria);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateCategoria(Categoria categoria) {         
		categoriaDao.updateCategoria(categoria);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCategoria(int id) {         
		categoriaDao.deleteCategoria(id);
	}
        
         public ArrayList<Categoria> buscarCategoriasId() {
		return categoriaDao.buscarCategoriasId();
	}
        

}
