/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controller;

import com.restaurant.modelo.Pedido;
import com.restaurant.modelo.PedidoDetalle;
import com.restaurant.modelo.Mesa;
import com.restaurant.service.CajaService;
import com.restaurant.service.MesaService;
import com.restaurant.service.MovimientoDetalleService;
import com.restaurant.service.PedidoDetalleService;
import java.util.ArrayList;
import java.util.HashMap;
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
public class CajaController {
    
    protected final Log logger = LogFactory.getLog(CajaController.class);
    
    @Autowired
    private CajaService cajaService;
    @Autowired
    private PedidoDetalleService pedidoDetalleService;
    @Autowired
    private MesaService mesaService;
    @Autowired
    private MovimientoDetalleService movimientoDetalleService;
    
    @RequestMapping(value = "validar/mainMesaPedido", method = RequestMethod.GET)
        public ModelAndView mainMesaPedido(HttpServletRequest request, HttpServletResponse response){
     
        
            
        Map<String, Object> model = new HashMap<String, Object>();

        int[] Nmesa=new int[6];
        
        int contador;
        ArrayList <Mesa> mesa3=mesaService.Mesas();
        
        
        contador=mesa3.size();
        
        for (int i = 0; i <= contador/4; i++) {
            
            Nmesa[i]=i;
           
        }
        
        

        model.put("resultadoBPedido", pedidoDetalleService.pedidoDetalle());
        model.put("Nmesa", Nmesa);
        return new ModelAndView("modulos/cobros/mainMesaPedido", model);
    }
        
        @RequestMapping(value = "validar/mainPedidoDetalle", method = RequestMethod.GET)
        public ModelAndView mainPedidoDetalle(HttpServletRequest request, HttpServletResponse response){
        
        
        Pedido ped=new Pedido();
        ped.setIdPedido(Integer.parseInt(request.getParameter("idPedido")));
        
        ArrayList<PedidoDetalle> pd=pedidoDetalleService.buscarPedidoDetalle(ped);
        ArrayList<PedidoDetalle> pdX=pedidoDetalleService.Cuenta(ped);
        
            
        Map<String, Object> model = new HashMap<String, Object>();
        
        model.put("pedidoX", pdX);
        model.put("pedido_detalle", pd);
        model.put("idPedido", ped.getIdPedido());
        return new ModelAndView("modulos/cobros/mainPedidoDetalle", model);
    }

        @RequestMapping(value = "validar/mainResumenCaja", method = RequestMethod.GET)
        public ModelAndView mainResumenCaja(HttpServletRequest request, HttpServletResponse response){
     

        Map<String, Object> model = new HashMap<String, Object>();
        
        
        model.put("movimientos", movimientoDetalleService.listarMovimientos() );
        model.put("registrosCaja", cajaService.listarRegistrosCaja());
        return new ModelAndView("modulos/reportes/mainResumenCaja", model);
    }
        
    
}
