/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controller;

import com.restaurant.modelo.Mesa;
import com.restaurant.modelo.Pedido;
import com.restaurant.modelo.PedidoDetalle;
import com.restaurant.service.MesaService;
import com.restaurant.service.PedidoDetalleService;
import com.restaurant.service.PedidoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MesaController {
    
    protected final Log logger = LogFactory.getLog(MesaController.class);
    
        @Autowired
        private PedidoService pedidoService;
        @Autowired
        private PedidoDetalleService pedidoDetalleService;
        @Autowired
        private MesaService mesaService;
    
        @RequestMapping(value = "validar/mainMesa", method = RequestMethod.GET)
        public ModelAndView mainMesa(HttpServletRequest request, HttpServletResponse response){
 
            
        if(request.getParameter("idMesaU")!=null){
            
            Mesa mesaU=new Mesa();
            mesaU.setIdMesa(Integer.parseInt(request.getParameter("idMesaU")));
            mesaU.setNumero(Integer.parseInt(request.getParameter("numero")));
            mesaU.setEstado("1");

            
            mesaService.updateMesa(mesaU);
        }
        
        if(request.getParameter("idMes")!=null&&request.getParameter("idPed")!=null){
            
            Mesa mesaX=new Mesa();
            Pedido pedX=new Pedido();
            mesaX.setIdMesa(Integer.parseInt(request.getParameter("idMes")));
            pedX.setIdMesa(mesaX);
            pedX.setIdPedido(Integer.parseInt(request.getParameter("idPed")));

            
            List<Pedido> pedX2=pedidoService.buscarPedido(pedX);
            
            for (Pedido pedX21 : pedX2) {
                
                mesaX.setNumero(pedX21.getIdMesa().getNumero());
                mesaX.setEstado("1");
                mesaService.updateMesa(mesaX);
                pedidoService.deletePedido(pedX21.getIdPedido());
                
            }
     
        }
            
        Map<String, Object> model = new HashMap<String, Object>();

        int[] Nmesa=new int[6];
        
        int contador;
        ArrayList <Mesa> mesa3=mesaService.Mesas();
        
        
        contador=mesa3.size();
        
        for (int i = 0; i <= contador/4; i++) {
            
            Nmesa[i]=i;
           
        }

        model.put("resultadoBMesa", mesaService.Mesas());
        model.put("Nmesa", Nmesa);
        return new ModelAndView("modulos/pedidos/mainMesa", model);
        }
    
        @RequestMapping(value = "validar/mainMesaPedidoC", method = RequestMethod.GET)
        public ModelAndView mainMesaPedidoC(HttpServletRequest request, HttpServletResponse response){
     
        
            
        Map<String, Object> model = new HashMap<String, Object>();

        int[] Nmesa=new int[4];
        
        int contador;
        ArrayList <Pedido> pd=pedidoService.PedidosGcocina();
        
        
        contador=pd.size();
        
        for (int i = 0; i <= contador/4; i++) {
            
            Nmesa[i]=i;
           
        }
        
        ArrayList<PedidoDetalle> p=pedidoDetalleService.pedidoDetalle();
        System.out.println("holaaaaaaa"+ p);
        

        model.put("resultadoBPedido", p);
        model.put("Nmesa", Nmesa);
        return new ModelAndView("modulos/cocina/mainMesaPedidoC", model);
        }
    
}
