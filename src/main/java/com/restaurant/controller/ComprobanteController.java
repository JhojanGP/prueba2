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
import com.restaurant.util.n2t;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
public class ComprobanteController {
    
    protected final Log logger = LogFactory.getLog(ComprobanteController.class);
    
        @Autowired
        ComprobanteService comprobanteService;
        @Autowired
        ClienteService clienteService;
        @Autowired
        EmpleadoService empleadoService;
        @Autowired
        PedidoDetalleService pedidoDetalleService;
        @Autowired
        CierreCajaService cierreCajaService;
        @Autowired
        CajaService cajaService;
    
        @RequestMapping(value = "validar/mainComprobante", method = RequestMethod.POST)
        public ModelAndView mainComprobante(@ModelAttribute("cajaRegistroInsertar") Caja  registro, BindingResult result, HttpServletRequest request, HttpServletResponse response) {           
            Map<String, Object> model = new HashMap<String, Object>();
            
            Empleado empleado=new Empleado();
            empleado.setIdEmpleado(Integer.parseInt(request.getParameter("usuario")));
            
            model.put("empleado", empleadoService.buscarEmpleados(empleado));
            Cliente cliente=new Cliente();
            cliente.setNombre(request.getParameter("nombreCliente"));
            cliente.setDocumento(request.getParameter("documento"));
            cliente.setDireccion(request.getParameter("direccion"));
            
            
            String nom=cliente.getNombre();
            String doc=cliente.getDocumento();
            String dir=cliente.getDireccion();
            
            //SAVE
            if(clienteService.buscarClienteEspecifico(cliente)==null){
                clienteService.saveCliente(cliente);
            }
            
            
            Pedido pedidoC=new Pedido();
            pedidoC.setIdPedido(Integer.parseInt(request.getParameter("idPd")));
            
            Comprobante tp=new Comprobante();
            tp.setIdComprobante(Integer.parseInt(request.getParameter("idComprobante.idComprobante")));
            
            float total=0;
            ArrayList<PedidoDetalle> pd=pedidoDetalleService.buscarPedidoDetalle(pedidoC);
            
            for (PedidoDetalle pd1 : pd) {
                
                float totalP=pd1.getCantidadProducto()*pd1.getIdProducto().getPrecio();
                total=total+totalP;
             
            }
            
            Date dates = new Date();
            long fechaSis = dates.getTime();
            Timestamp fecha = new Timestamp(fechaSis);
            
            CierreCaja cc=new CierreCaja();
            ArrayList<CierreCaja> ccB=cierreCajaService.buscarCierreCaja();
            
            for (CierreCaja ccB1 : ccB) {
                
                cc.setIdCierreCaja(ccB1.getIdCierreCaja());
             
            }
            
            
            registro.setIdPedido(pedidoC);
            registro.setIdComprobante(tp);
            registro.setTotal(total);
            registro.setIdCierreCaja(cc);
            
            
            
            
            ArrayList<PedidoDetalle> pd3=pedidoDetalleService.buscarPedidoDetalle(pedidoC);
            
            for (PedidoDetalle pdA : pd3) {
                
                int id=pdA.getIdPedidoDetalle();
                pedidoDetalleService.deletePD(id);
             
            }
            
            
            
            int tipo_comprobante=Integer.parseInt(request.getParameter("idComprobante.idComprobante"));

            Comprobante comp=new Comprobante();

            //1: Factura
            //2: Boleta
            
            if(tipo_comprobante==1){
                 ArrayList<Cliente> clienteF=clienteService.buscarCliente(cliente);
                 for (Cliente clienteF1 : clienteF) {
                 
                     cliente.setIdCliente(clienteF1.getIdCliente());
                 }
                 registro.setIdCliente(cliente);
                 comp.setIdComprobante(tipo_comprobante);
                 comp.setIgv(Float.parseFloat(request.getParameter("igv")));
                 comp.setNro(Integer.parseInt(request.getParameter("nroC1"))+1);
                 comp.setRuc(request.getParameter("ruc"));
                 comp.setTipo("Factura");
                 
                 
                 comprobanteService.updateComprobante(comp);
                 int digitosNF=comp.getNro();
                 String numeroF=String.format("%07d", digitosNF);
                 
                 model.put("Factura", pd);
                 
                 model.put("igv", comp.getIgv());
                 model.put("ruc", comp.getRuc());
                 model.put("nroC", numeroF);
                
            }
            if(tipo_comprobante==2){
                
                 comp.setIdComprobante(tipo_comprobante);
                 
                 comp.setNro(Integer.parseInt(request.getParameter("nroC2"))+1);
                 comp.setRuc(request.getParameter("ruc"));
                 comp.setTipo("Boleta");
                 
                 comprobanteService.updateComprobante(comp);
                 
                 int digitosNB=comp.getNro();
                 String numeroB=String.format("%07d", digitosNB);
                 model.put("Boleta", pd);
                 model.put("ruc", comp.getRuc());
                 model.put("nroC", numeroB);
                 
                 
                 
            }
            if(tipo_comprobante==3){
                
                comp.setIdComprobante(tipo_comprobante);
                
                comp.setRuc(request.getParameter("ruc"));
                comp.setTipo("Ticket");
                
                comprobanteService.updateComprobante(comp);
                
                model.put("Ticket", pd);
                model.put("ruc", comp.getRuc());
                
            }
            
            //Guarda en caja 
            
            cajaService.saveRegistroCaja(registro);
            
            double totalX=registro.getTotal();
            double totalX2=Math.round(totalX*100)/100.00;
            int nT=(int) totalX2;
            double n1=totalX2*100;
            int nT2=(int) n1;
            int nT3=nT2-nT*100;
            double nT4=Math.round(nT3*0.1);
            double redondeo=Math.round((nT4-(nT3*0.1))*10)/100.00;
            int nT5=(int) nT4*10;
            
            
            
            n2t nxt;
            n2t nxt2;

            String Soles;
            String Centimos;

            nxt = new n2t();
            nxt2 = new n2t();
            Soles = nxt.convertirLetras(nT);
            Centimos = nxt2.convertirLetras(nT5);
        
            
            SimpleDateFormat formatDia = new SimpleDateFormat("dd");
            SimpleDateFormat formatMes = new SimpleDateFormat("MMMM", new Locale("es", "ES"));
            SimpleDateFormat formatAño = new SimpleDateFormat("yyyy");
                      
            
            Date fechaDate = new Date();
            String dia=formatDia.format(fechaDate);
            String mesa=formatMes.format(fechaDate);
            String año=formatAño.format(fechaDate);
            
            double efectivo=Float.parseFloat(request.getParameter("efectivo"));
            model.put("efectivo", efectivo);
        //fecha para la boleta   
        model.put("fecha", fecha);

        //fecha para la factura
        //model.put("fechaSys", fechaSys);
        model.put("dia", dia);
        model.put("mes", mesa);
        model.put("año", año);
                
        model.put("soles", Soles);        
        model.put("centimos", Centimos);
        model.put("redondeo", redondeo);
        model.put("nom", nom);
        model.put("doc", doc);
        model.put("dir", dir);
        
        return new ModelAndView("modulos/cobros/mainComprobante", model);
        }
    
}
