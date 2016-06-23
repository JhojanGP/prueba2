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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
//or use /dispatcher-servlet.xml
public class CategoriaDaoTest {
    
    @Resource
    private CategoriaDao categoriaDao;
    
    Categoria categoria;
    List<Categoria> catOriginales;
    List<Categoria> categorias;
    
    //numero de categorias en la BD
    //private static final int categoriasBD = 20;
    
    @Before
    public void setUp(){
        
        categoria = new Categoria();
        categoria.setNombre("CategoriaPrueba");
    
    }
    /*
    @Test
    public void testBBDD() {
	categorias = categoriaDao.buscarCategorias();
	Assert.assertTrue("Comprobar que en la base de datos hay 3 libros",
				categorias.size() == categoriasBD);
    }*/
    
    @Test
    @Transactional
    @Rollback
    public void testInsert() throws Exception{
        
        catOriginales=categoriaDao.buscarCategorias();
        categoriaDao.saveCategoria(categoria);
        categorias= categoriaDao.buscarCategorias();
        System.out.println("nro categorias  " + categorias.size());
        
        Assert.assertTrue("Comprueba que hay una categoria mas", categorias.size()==catOriginales.size()+1);
        List<Categoria> catNombre=categoriaDao.buscarNombreCategoria(categoria);
            for (Categoria catNombre1 : catNombre) {
            
                categoria.setIdCategoria(catNombre1.getIdCategoria());
            }
            /*
        Categoria catAux=categorias.get(categoriaDao.buscarNombreCategoria(categoria));
        System.out.println("catAux " +catAux);*/

        Assert.assertTrue("comprueba que coincide id", 
                categoria.getIdCategoria()==categoria.getIdCategoria());
        Assert.assertTrue("Comprueba que coincide el nombre.",
		categoria.getNombre() == categoria.getNombre());
        
        
        categoriaDao.deleteCategoria(categoria.getIdCategoria());
    
	
    }
    
}
