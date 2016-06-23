/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controller;


import com.restaurant.modelo.Categoria;
import com.restaurant.service.CategoriaService;
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
public class CategoriaController {
    
    protected final Log logger = LogFactory.getLog(CategoriaController.class);

        @Autowired
	private CategoriaService categoriaService;
        
        @RequestMapping(value = "validar/mainCategoria", method = RequestMethod.GET)
        public ModelAndView mainCategoria(HttpServletRequest request, HttpServletResponse response){
        
        Categoria categoria=new Categoria();
        categoria.setNombre(request.getParameter("categoriaNombre"));
        Map<String, Object> model = new HashMap<String, Object>();

        model.put("categorias", categoriaService.buscarNombreCategoria(categoria));
        
        
        return new ModelAndView("modulos/productos/mainCategoria", model);
    } 
        
        @RequestMapping(value = "validar/formCategoriaAdd", method = RequestMethod.POST)
        public ModelAndView formCategoria(@ModelAttribute("categoriaInsertar") Categoria  categoria, BindingResult result){      

        Map<String, Object> model = new HashMap<String, Object>(); 

        return new ModelAndView("modulos/productos/formCategoriaAdd", model);
        }

        
        @RequestMapping(value = "validar/saveCategoria", method = RequestMethod.POST)
        public ModelAndView saveCategoria(@ModelAttribute("categoriaInsertar") Categoria  categoria, BindingResult result) {           
        categoriaService.saveCategoria(categoria); 
        return new ModelAndView("redirect:mainCategoria.html?categoriaNombre");
        }
        
        @RequestMapping(value = "validar/formCategoriaEdit", method = RequestMethod.POST)
        public ModelAndView categoriaEdit(HttpServletRequest request, HttpServletResponse response){
            Categoria categoria=new Categoria();
            categoria.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria"))); 
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("categoria",  categoriaService.listaCategoriaId(categoria));
            //model.put("categorias", categoriaService.buscarCategorias());
    
        return new ModelAndView("modulos/productos/formCategoriaEdit", model); 
        }
        
        @RequestMapping(value = "validar/updateCategoria", method = RequestMethod.POST)
        public ModelAndView updateCategoria(HttpServletRequest request, HttpServletResponse response) throws Exception {                     
            
            Categoria categoria=new Categoria();
            categoria.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
            categoria.setNombre(request.getParameter("nombre"));


             
            categoriaService.updateCategoria(categoria);
            
        
            return new ModelAndView("redirect:mainCategoria.html?categoriaNombre");
        }
        
        @RequestMapping(value = "validar/deleteCategoria", method = RequestMethod.GET)
        public ModelAndView deleteCategoria(HttpServletRequest request, HttpServletResponse response) {
            int id=Integer.parseInt( request.getParameter("idCategoria"));
                categoriaService.deleteCategoria(id); 
                return new ModelAndView("redirect:mainCategoria.html?categoriaNombre");
        }
    
        
         
    
}
