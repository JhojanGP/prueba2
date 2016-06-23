/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controller;

import com.restaurant.modelo.Caja;
import com.restaurant.modelo.CierreCaja;
import com.restaurant.modelo.Cliente;
import com.restaurant.modelo.Comprobante;
import com.restaurant.modelo.Empleado;
import com.restaurant.modelo.Pedido;
import com.restaurant.modelo.PedidoDetalle;
import com.restaurant.service.CajaService;
import com.restaurant.service.CierreCajaService;
import com.restaurant.service.ClienteService;
import com.restaurant.service.ComprobanteService;
import com.restaurant.service.EmpleadoService;
import com.restaurant.service.PedidoDetalleService;
import com.restaurant.service.PedidoService;
import com.restaurant.util.n2t;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
public class TipoComprobanteController {
    
    protected final Log logger = LogFactory.getLog(TipoComprobanteController.class);
    
        @Autowired
        PedidoService pedidoService;
        @Autowired
        ComprobanteService comprobanteService;
        @Autowired
        ClienteService clienteService;
    
    
        @RequestMapping(value = "validar/mainTipoComp", method = RequestMethod.POST)
        public ModelAndView mainTipoComp(@ModelAttribute("cajaRegistroInsertar") Caja  registro, BindingResult result, HttpServletRequest request, HttpServletResponse response){
     
        
        Pedido ped=new Pedido();
        ped.setIdPedido(Integer.parseInt(request.getParameter("idPed")));
        
        List<Pedido> pe=pedidoService.buscarPedido(ped);

        Map<String, Object> model = new HashMap<String, Object>();
        
        model.put("pedido", pe);
        model.put("comprobantes", comprobanteService.TipoComprobante());
        model.put("clientes", clienteService.listarClientes());
        return new ModelAndView("modulos/cobros/mainTipoComp", model);
        }
        
        

}
