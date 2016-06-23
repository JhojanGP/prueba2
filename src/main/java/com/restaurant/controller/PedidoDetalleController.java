/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controller;

import com.restaurant.modelo.Categoria;
import com.restaurant.modelo.Pedido;
import com.restaurant.modelo.PedidoDetalle;
import com.restaurant.service.CategoriaService;
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
public class PedidoDetalleController {
    
    protected final Log logger = LogFactory.getLog(PedidoDetalleController.class);
    
    @Autowired
    private PedidoDetalleService pedidoDetalleService;
    @Autowired
    private CategoriaService categoriaService;

        
        @RequestMapping(value = "validar/addEdit", method = RequestMethod.GET)
        public ModelAndView addEdit(  HttpServletRequest request, HttpServletResponse response ) {  
             Map<String, Object> model = new HashMap<String, Object>();
          
             PedidoDetalle pdS=new PedidoDetalle();
             pdS.setIdPedidoDetalle(Integer.parseInt(request.getParameter("idPedidoDetalle")));
             
             List<PedidoDetalle> pd=pedidoDetalleService.listaPedidoDetalleId(pdS);
             
             for (PedidoDetalle pd1 : pd) {
                 
                 pdS.setIdPedidoDetalle(pd1.getIdPedidoDetalle());
                 pdS.setIdProducto(pd1.getIdProducto());
                 pdS.setIdPedido(pd1.getIdPedido());
                 pdS.setCantidadProducto(pd1.getCantidadProducto()+1);
                
            }
             
             
             pedidoDetalleService.updatePD(pdS);
             
             Pedido pedido=new Pedido();
             pedido.setIdPedido(pdS.getIdPedido().getIdPedido());
             
             
             int contador=0;
        int indice=0;
        
        ArrayList<Categoria> cat=categoriaService.buscarCategoriasId();
        int[] N=new int[cat.size()/4+1];
        for (Categoria cat1 : cat) {
            
            contador++;
            
            if(contador==4){
                
                int idCategoria=cat1.getIdCategoria();
                N[indice]=idCategoria;
                indice++;
                contador=0;
            }else{
                int idCatExtra=cat1.getIdCategoria();
                N[indice]=idCatExtra;
            }
            
        }
             
             model.put("pedidoX", pedidoDetalleService.Cuenta(pedido));
             model.put("pedido_detalle", pedidoDetalleService.buscarPedidoDetalle(pedido));
             model.put("nroCol", N);
             model.put("categorias", categoriaService.buscarCategoriasId());
             
             
        return new ModelAndView("modulos/pedidos/mainPedido", model);
        }
        
        @RequestMapping(value = "validar/substractEdit", method = RequestMethod.GET)
        public ModelAndView substractEdit(  HttpServletRequest request, HttpServletResponse response ) {  
             Map<String, Object> model = new HashMap<String, Object>();
          
             PedidoDetalle pdS=new PedidoDetalle();
             pdS.setIdPedidoDetalle(Integer.parseInt(request.getParameter("idPedidoDetalle")));
             
             List<PedidoDetalle> pd=pedidoDetalleService.listaPedidoDetalleId(pdS);
             
             for (PedidoDetalle pd1 : pd) {
                 
                 pdS.setIdPedidoDetalle(pd1.getIdPedidoDetalle());
                 pdS.setIdProducto(pd1.getIdProducto());
                 pdS.setIdPedido(pd1.getIdPedido());
                 if(pd1.getCantidadProducto()>1){
                 pdS.setCantidadProducto(pd1.getCantidadProducto()-1);
                }
            }
             
             pedidoDetalleService.updatePD(pdS);
             
             Pedido pedido=new Pedido();
             pedido.setIdPedido(pdS.getIdPedido().getIdPedido());
             
            int contador=0;
            int indice=0;
        
            ArrayList<Categoria> cat=categoriaService.buscarCategoriasId();
            int[] N=new int[cat.size()/4+1];
                for (Categoria cat1 : cat) {
            
                    contador++;
            
                        if(contador==4){
                
                            int idCategoria=cat1.getIdCategoria();
                            N[indice]=idCategoria;
                            indice++;
                            contador=0;
                        }else{
                            int idCatExtra=cat1.getIdCategoria();
                            N[indice]=idCatExtra;
                        }
            
                }
             
             model.put("pedidoX", pedidoDetalleService.Cuenta(pedido));
             model.put("pedido_detalle", pedidoDetalleService.buscarPedidoDetalle(pedido));
             model.put("categorias", categoriaService.buscarCategoriasId());
             model.put("nroCol", N);
             
             
        return new ModelAndView("modulos/pedidos/mainPedido", model);
        }
        
        @RequestMapping(value = "validar/deletePD", method = RequestMethod.GET)
        public ModelAndView deletePD(HttpServletRequest request, HttpServletResponse response) {
            Map<String, Object> model = new HashMap<String, Object>();
            int id=Integer.parseInt( request.getParameter("idPedidoDetalle"));
                PedidoDetalle pdS=new PedidoDetalle();
                pdS.setIdPedidoDetalle(id);
                
                List<PedidoDetalle> pd=pedidoDetalleService.listaPedidoDetalleId(pdS);
                
                for (PedidoDetalle pd1 : pd) {
                 
                 pdS.setIdPedidoDetalle(pd1.getIdPedidoDetalle());
                 pdS.setIdProducto(pd1.getIdProducto());
                 pdS.setIdPedido(pd1.getIdPedido());
                 pdS.setCantidadProducto(pd1.getCantidadProducto());

                }
                Pedido pedido=new Pedido();
                pedido.setIdPedido(pdS.getIdPedido().getIdPedido());
                pedido.setIdMesa(pdS.getIdPedido().getIdMesa());
                pedido.setIdEmpleado(pdS.getIdPedido().getIdEmpleado());
                
                pedidoDetalleService.deletePD(id); 
                

                
                int contador=0;
                int indice=0;
        
                ArrayList<Categoria> cat=categoriaService.buscarCategoriasId();
                int[] N=new int[cat.size()/4+1];
                for (Categoria cat1 : cat) {
            
                    contador++;
            
                        if(contador==4){
                
                            int idCategoria=cat1.getIdCategoria();
                            N[indice]=idCategoria;
                            indice++;
                            contador=0;
                        }else{
                            int idCatExtra=cat1.getIdCategoria();
                            N[indice]=idCatExtra;
                        }
            
                }
                model.put("pedidoX", pedidoDetalleService.Cuenta(pedido));
                model.put("pedido_detalle", pedidoDetalleService.buscarPedidoDetalle(pedido));
                model.put("categorias", categoriaService.buscarCategoriasId());
                model.put("m", pedido.getIdMesa().getIdMesa());
                model.put("u", pedido.getIdEmpleado());
                model.put("ped", pedido.getIdPedido());
                model.put("numeroMesa", pedido.getIdMesa().getNumero());
                model.put("nroCol", N);
                
                return new ModelAndView("modulos/pedidos/mainPedido", model);
        }
        
        
 }
