/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controller;

import com.restaurant.modelo.Cliente;
import com.restaurant.service.ClienteService;
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
public class ClienteController {
    
    protected final Log logger = LogFactory.getLog(ClienteController.class);
    
        @Autowired
        private ClienteService clienteService;
    
        @RequestMapping(value = "validar/mainCliente", method = RequestMethod.GET)
        public ModelAndView mainCliente(HttpServletRequest request, HttpServletResponse response){
        
        Cliente cliente=new Cliente();
        
        Map<String, Object> model = new HashMap<String, Object>();
        
        //1 Nombre o Razon Social
        //2 Documento

        if(request.getParameter("variable")!=null&&Integer.parseInt(request.getParameter("variable"))==1){
            cliente.setNombre(request.getParameter("dato"));
        }
        
        if(request.getParameter("variable")!=null&&Integer.parseInt(request.getParameter("variable"))==2){
            
            cliente.setDocumento(request.getParameter("dato"));
        }
        
        model.put("clientes", clienteService.buscarCliente(cliente));
        
        
        return new ModelAndView("modulos/personas/mainCliente", model);
    } 
        
        @RequestMapping(value = "validar/formClienteAdd", method = RequestMethod.POST)
        public ModelAndView formClienteAdd(@ModelAttribute("clienteInsertar") Cliente  cliente, BindingResult result){      

        Map<String, Object> model = new HashMap<String, Object>(); 

        return new ModelAndView("modulos/personas/formClienteAdd", model);
        }
        
        @RequestMapping(value = "validar/saveCliente", method = RequestMethod.POST)
        public ModelAndView saveCliente(@ModelAttribute("clienteInsertar") Cliente  cliente, BindingResult result) {           
        clienteService.saveCliente(cliente); 
        return new ModelAndView("redirect:mainCliente.html?clienteNombre");
        }
        
        @RequestMapping(value = "validar/formClienteEdit", method = RequestMethod.POST)
        public ModelAndView clienteEdit(HttpServletRequest request, HttpServletResponse response){
            Cliente cliente=new Cliente();
            cliente.setIdCliente(Integer.parseInt(request.getParameter("idCliente"))); 
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("cliente",  clienteService.listaClienteId(cliente));
    
        return new ModelAndView("modulos/personas/formClienteEdit", model); 
        }
        
        @RequestMapping(value = "validar/updateCliente", method = RequestMethod.POST)
        public ModelAndView updateCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {                     
            
            Cliente cliente=new Cliente();
            cliente.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
            cliente.setNombre(request.getParameter("nombre"));
            cliente.setDocumento(request.getParameter("documento"));
            cliente.setDireccion(request.getParameter("direccion"));
            cliente.setTelefonos(request.getParameter("telefono"));


             
            clienteService.updateCliente(cliente);
            
        
            return new ModelAndView("redirect:mainCliente.html");
        }
        
        @RequestMapping(value = "validar/deleteCliente", method = RequestMethod.GET)
        public ModelAndView deleteCliente(HttpServletRequest request, HttpServletResponse response) {
            int id=Integer.parseInt( request.getParameter("idCliente"));
                clienteService.deleteCliente(id); 
                return new ModelAndView("redirect:mainCliente.html");
        }
    
}
