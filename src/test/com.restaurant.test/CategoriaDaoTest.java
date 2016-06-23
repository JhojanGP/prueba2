/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.test;

import com.restaurant.dao.CategoriaDao;
import com.restaurant.modelo.Categoria;
import java.util.List;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/WEB-INF/contextConfigLocation"})
public class CategoriaDaoTest {
    
    @Resource
    private CategoriaDao categoriaDao;
    Categoria categoria;
    List<Categoria> categorias;
    
    @Before
    public void setUo(){
        
        categoria = new Categoria();
        categoria.setIdCategoria(99);
        categoria.setNombre("CategoriaPrueba");
    
    }
    
    @Test
    public void testInsert(){
    
        categoriaDao.saveCategoria(categoria);
        categorias= categoriaDao.buscarNombreCategoria(categoria);
        Assert.assertTrue("Comprueba que hay una categoria mas", categorias.size()==categoriaDao.buscarCategorias().size()+1);
        Categoria catAux=categorias.get(categoriaDao.buscarCategorias().size());
        
        Assert.assertTrue("comprueba que coincide id", 
                categoria.getIdCategoria()==catAux.getIdCategoria());
        Assert.assertTrue("Comprueba que coincide el nombre.",
		categoria.getNombre() == catAux.getNombre());
        
        
        categoriaDao.deleteCategoria(catAux.getIdCategoria());
    
	
    }
    
}
