/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controller;


import com.restaurant.modelo.Categoria;
import com.restaurant.modelo.Producto;
import com.restaurant.service.CategoriaService;
import com.restaurant.service.ProductoService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductoController {
    
    protected final Log logger = LogFactory.getLog(ProductoController.class);
    
	
        @Autowired
	private ProductoService productoService;
        @Autowired
	private CategoriaService categoriaService;
        
        @RequestMapping(value = "validar/mainProducto", method = RequestMethod.GET)
        public ModelAndView mainProducto(HttpServletRequest request, HttpServletResponse response){
        
        
        Map<String, Object> model = new HashMap<String, Object>();
        Producto producto=new Producto();

        if(request.getParameter("categoria")!=null){
            
            int cat=Integer.parseInt(request.getParameter("categoria"));
            Categoria categoria=new Categoria();
            categoria.setIdCategoria(cat);

            
            model.put("productosXcategoria", productoService.buscarProductoXCategoria(categoria));
            
        }
        
        if(request.getParameter("categoria")==null&&request.getParameter("opc")!=null){
            Categoria catB=new Categoria();
            catB.setIdCategoria(Integer.parseInt(request.getParameter("opc")));
                    
            
            producto.setNombre(request.getParameter("productoNombre"));
            producto.setIdCategoria(catB);
            
            System.out.println("1");
            model.put("resultadoBProducto", productoService.buscarProducto(producto));
        }
        
        if(request.getParameter("categoria")==null&&request.getParameter("opc")==null){
            System.out.println("2");
            producto.setNombre(request.getParameter("productoNombre"));
            
            model.put("resultadoBProducto", productoService.buscarNombreProducto(producto));
        }
        
        
        
        

        model.put("categorias", categoriaService.buscarCategorias());
        
        
        return new ModelAndView("modulos/productos/mainProducto", model);
        } 
    
       @RequestMapping(value = "validar/formProductoAdd", method = RequestMethod.POST)
        public ModelAndView formProducto(@ModelAttribute("productoInsertar") Producto  producto, BindingResult result){      

        Map<String, Object> model = new HashMap<String, Object>(); 

        model.put("categorias", categoriaService.buscarCategorias());
        return new ModelAndView("modulos/productos/formProductoAdd", model);
        }

        @RequestMapping(value = "validar/saveProducto", method = RequestMethod.POST)
        public ModelAndView saveProducto(@ModelAttribute("productoInsertar") Producto  producto, BindingResult result) { 
        
        productoService.saveProducto(producto); 
        return new ModelAndView("redirect:mainProducto.html?productoNombre");
        }

        
        @RequestMapping(value = "validar/formProductoEdit", method = RequestMethod.POST)
        public ModelAndView productoEdit(HttpServletRequest request, HttpServletResponse response){
        Producto producto=new Producto();
        producto.setIdProducto(Integer.parseInt(request.getParameter("idProducto"))); 
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("producto",  productoService.listaProductoId(producto));
        model.put("categorias", categoriaService.buscarCategorias());
    
        return new ModelAndView("modulos/productos/formProductoEdit", model); 
        }
        
        @RequestMapping(value = "validar/updateProducto", method = RequestMethod.POST)
        public ModelAndView updateProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {                     
            
            Producto producto=new Producto();
            producto.setIdProducto(Integer.parseInt(request.getParameter("idProducto")));
            producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
            Categoria categoria=new Categoria();
            categoria.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
            
            
            producto.setNombre(request.getParameter("nombre"));
            producto.setIdCategoria(categoria);
             
            productoService.updateProducto(producto);
            
        
            return new ModelAndView("redirect:mainProducto.html?productoNombre");
        }
    
        @RequestMapping(value = "validar/deleteProducto", method = RequestMethod.GET)
        public ModelAndView deleteProducto(HttpServletRequest request, HttpServletResponse response) {
            int id=Integer.parseInt( request.getParameter("idProducto"));
                productoService.deleteProducto(id); 
                return new ModelAndView("redirect:mainProducto.html?productoNombre");
        }
        
        
        
         
    
}
