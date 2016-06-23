/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controller;

import com.restaurant.modelo.Categoria;
import com.restaurant.modelo.Empleado;
import com.restaurant.modelo.Mesa;
import com.restaurant.modelo.Pedido;
import com.restaurant.modelo.PedidoDetalle;
import com.restaurant.modelo.Producto;
import com.restaurant.service.CategoriaService;
import com.restaurant.service.MesaService;
import com.restaurant.service.PedidoDetalleService;
import com.restaurant.service.PedidoService;
import com.restaurant.service.ProductoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PedidoController {
    
    protected final Log logger = LogFactory.getLog(PedidoController.class);
    
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PedidoDetalleService pedidoDetalleService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private MesaService mesaService;
    @Autowired
    private ProductoService productoService;
        
        @RequestMapping(value = "validar/mainPedidoGuardado", method = RequestMethod.GET)
        public ModelAndView mainPedidoGuardado(HttpServletRequest request, HttpServletResponse response){
     
        Pedido ped=new Pedido();
        ped.setIdPedido(Integer.parseInt(request.getParameter("idPedido")));
        
        ArrayList<PedidoDetalle> pd=pedidoDetalleService.buscarPedidoDetalle(ped);
        
        
            
        Map<String, Object> model = new HashMap<String, Object>();
        
        
        model.put("pedido_detalle", pd);
        return new ModelAndView("modulos/cocina/mainPedidoGuardado", model);
        }
        
        @RequestMapping(value = "validar/saveOrden", method = RequestMethod.POST)
        public ModelAndView saveOrden(  HttpServletRequest request, HttpServletResponse response ) {
            
            Empleado emp=new Empleado();
            emp.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpl")));
            Mesa mesa=new Mesa();
            mesa.setIdMesa(Integer.parseInt(request.getParameter("idMesa")));
            
            Pedido ped=new Pedido();
            ped.setIdPedido(Integer.parseInt(request.getParameter("idPed")));
            ped.setIdEmpleado(emp);
            ped.setIdMesa(mesa);
            ped.setEstado(request.getParameter("estado"));
            
            pedidoService.updatePedido(ped);

            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView("redirect:mainMesaPedidoC.html", model);
            
        }
        
        @RequestMapping(value = "validar/mainPedido", method = RequestMethod.GET)
        public ModelAndView mainPedido(HttpServletRequest request, HttpServletResponse response){
        Mesa mesa=new Mesa();
        mesa.setIdMesa(Integer.parseInt(request.getParameter("idMesa")));
   
        Empleado emp=new Empleado();
        emp.setIdEmpleado(Integer.parseInt(request.getParameter("usuario")));
        
        mesa.setNumero(Integer.parseInt(request.getParameter("numero")));
        mesa.setEstado("0");
        
        Pedido pedido=new Pedido();
        pedido.setIdMesa(mesa);
        pedido.setIdEmpleado(emp);
        
        
        
        
        pedido.setEstado("0");
           
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

        mesaService.updateMesa(mesa);
        pedidoService.savePedido(pedido);
        
        Map<String, Object> model = new HashMap<String, Object>();
        
        model.put("numeroMesa", mesa.getNumero());
        model.put("nroCol", N);
        model.put("pedido", pedidoService.buscarPedidoXMesa(pedido));
        model.put("categorias", categoriaService.buscarCategoriasId());

        return new ModelAndView("modulos/pedidos/mainPedido", model);
        } 
        
        @RequestMapping(value = "validar/formMenu", method = RequestMethod.POST)
        public ModelAndView formMenu( @ModelAttribute("pedidoInsertar")PedidoDetalle  pd,HttpServletRequest request, HttpServletResponse response){      
        
        Categoria categoria=new Categoria();
        categoria.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
        

        String m=request.getParameter("idmes");
        String u=request.getParameter("user");
        
        
        String ped=request.getParameter("idpedido2");
        
        Map<String, Object> model = new HashMap<String, Object>(); 
        
        
        
        model.put("m", m);
        model.put("u", u);
        model.put("ped", ped);
        model.put("productos", productoService.buscarProductoCAT(categoria));
        return new ModelAndView("modulos/pedidos/formMenu", model);
        }
    
        @RequestMapping(value = "validar/savePedido", method = RequestMethod.GET)
        public ModelAndView savePedido(  HttpServletRequest request, HttpServletResponse response ) {  
             Map<String, Object> model = new HashMap<String, Object>();
            
            String u=request.getParameter("usuario");
            
            Mesa mesa=new Mesa();
            mesa.setIdMesa(Integer.parseInt(request.getParameter("idMesa")));
            Pedido pedido=new Pedido();
            pedido.setIdMesa(mesa);
            
            ArrayList <Pedido> pedidoB=pedidoService.buscarPedidoXMesa(pedido);
            
            int id=0;
            
            for (Pedido pedidoB1 : pedidoB) {
                
                id=pedidoB1.getIdPedido();
                
            }
            
            pedido.setIdPedido(id);
            Producto producto=new Producto();
            producto.setIdProducto(Integer.parseInt(request.getParameter("idProducto")));
            
            int cantidad=1;
            
            PedidoDetalle pedDet=new PedidoDetalle();
            pedDet.setIdPedido(pedido);
            pedDet.setIdProducto(producto);
            pedDet.setCantidadProducto(cantidad);
            
            
            /*
            if(pedidoService.Cuenta(pedido)!=null){
                
            }*/
            String productoR="";
            String categoriaR="";
            ArrayList<PedidoDetalle> pd5=pedidoDetalleService.buscarProductoRepetido(pedDet);
            
            if(pd5.isEmpty()){
                pedidoDetalleService.savePedidoDetalle(pedDet);
            }else{
                for (PedidoDetalle pd51 : pd5) {
                    
                    productoR=pd51.getIdProducto().getNombre();
                    categoriaR=pd51.getIdProducto().getIdCategoria().getNombre();
                    
                }
                String alerta="Ya se ha agreagado el producto: "+categoriaR+" "+productoR;
                model.put("alerta", alerta);
            }

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
          
            model.put("usuario", u);
            model.put("nroCol", N);
            model.put("pedido_detalle", pedidoDetalleService.buscarPedidoDetalle(pedido));
            model.put("categorias", categoriaService.buscarCategoriasId());
            return new ModelAndView("modulos/pedidos/mainPedido", model);
        }
}
