/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.restaurant.controller;

import com.restaurant.service.EmpleadoService;
import com.restaurant.modelo.Empleado;
import com.restaurant.modelo.Rol;
import com.restaurant.service.RolService;
import com.restaurant.util.STRCrypto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class EmpleadoController {
    
    protected final Log logger = LogFactory.getLog(EmpleadoController.class);

        
        @Autowired
        private EmpleadoService empleadoService;
        @Autowired
        private RolService rolService;

        
        @RequestMapping(value = "validar/login", method = RequestMethod.POST)
        public ModelAndView loginRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map model = new HashMap();
        String result="";
        
        Empleado empleado=new Empleado();
        
        empleado.setUsuario(request.getParameter("username"));
        empleado.setPassword(request.getParameter("password"));
        STRCrypto crypt=new STRCrypto();
        String pass=crypt.encrypt(empleado.getPassword());
        empleado.setPassword(pass);

        List list= empleadoService.validarEmpleado(empleado);
               Iterator iterator = list.iterator();
               if(iterator.hasNext()){
                    Empleado to=(Empleado)iterator.next();                              
                    if(to.getEstado().equals("1") && to.getIdRol().getNombreRol().equals("Admin")){
                        
                        request.getSession().setAttribute("empleadoId", to.getIdEmpleado());
                        request.getSession().setAttribute("empleadoRol", to.getIdRol().getNombreRol());

                        
                        result="5|Exito|validar/frame_Admin.html";                
                    }else{
                        if(to.getEstado().equals("1") && to.getIdRol().getNombreRol().equals("Mesero")){
                            
                                request.getSession().setAttribute("empleadoId", to.getIdEmpleado());
                                request.getSession().setAttribute("empleadoRol", to.getIdRol().getNombreRol());

                                
                                result="5|Exito|validar/frame_Mesero.html";                
                        }else{
                            
                            if(to.getEstado().equals("1") && to.getIdRol().getNombreRol().equals("Cocinero")){
                                
                                    request.getSession().setAttribute("empleadoId", to.getIdEmpleado());
                                    request.getSession().setAttribute("empleadoRol", to.getIdRol().getNombreRol());

                                
                                    result="5|Exito|validar/frame_Cocinero.html";                
                            
                            
                            }else{
                                
                                if(to.getEstado().equals("1") && to.getIdRol().getNombreRol().equals("Cajero")){
                                    
                                        request.getSession().setAttribute("empleadoId", to.getIdEmpleado());
                                        request.getSession().setAttribute("empleadoRol", to.getIdRol().getNombreRol());

                                
                                        result="5|Exito|validar/frame_Cajero.html";
                                
                                
                                }else{
                                    
                            
                            
                                    result="|Usted. Esta desactivado y No es Administrador";
                                    }
                                  }
                             }               
                        }               
               }else{

               if(iterator.hasNext()){ result="0|Error de password...!";}else{result="1|Empleado no registrado";}               
               }     
               
        model.put("rsEmpleado", result);
        
        
        return new ModelAndView("admin/validaxion",model);
        }
        


    
        @RequestMapping(value = "validar/formEmpleadoEdit", method = RequestMethod.POST)
         public ModelAndView formEmpleadoEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
         Empleado empleado=new Empleado();
         empleado.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpleado"))); 
         
        String[] estado=new String[2];
        estado[0]="1";
        estado[1]="0";
        /*
        String[] rol=new String[4];
        rol[0]="1";
        rol[1]="2";
        rol[2]="3";
        rol[3]="4";*/
        
        STRCrypto crypt=new STRCrypto();
        
        String pass="";
        
        List <Empleado> trab=empleadoService.listaEmpleadoId(empleado);
            for (Empleado trab1 : trab) {
                
                pass=crypt.decrypt(trab1.getPassword());
                
                
            }

        Map<String, Object> model = new HashMap<String, Object>();
         
        model.put("pass", pass);
        model.put("empleado",  trab);
        model.put("rol", rolService.buscarRoles());
        model.put("estado", estado);
    
        return new ModelAndView("modulos/empleados/formEmpleadoEdit", model); 
        }
     

        @RequestMapping(value = "validar/updateEmpleado", method = RequestMethod.POST)
        public ModelAndView updateEmpleado(HttpServletRequest request, HttpServletResponse response) throws Exception {                     
            
            Empleado empleado=new Empleado();
            empleado.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpleado")));
            empleado.setNombre(request.getParameter("nombre"));
            empleado.setApPaterno(request.getParameter("apPaterno"));
            empleado.setApMaterno(request.getParameter("apMaterno"));
            empleado.setDni(request.getParameter("dni"));
            empleado.setUsuario(request.getParameter("usuario"));
            empleado.setPassword(request.getParameter("password"));
            empleado.setEstado(request.getParameter("estado"));
            empleado.setCelular(request.getParameter("celular"));
            
            Rol rol=new Rol();
            rol.setIdRol(Integer.parseInt(request.getParameter("idRol")));
            empleado.setIdRol(rol);
            
             STRCrypto crypt=new STRCrypto();
             String pass=crypt.encrypt(empleado.getPassword());
             empleado.setPassword(pass);

            empleadoService.updateEmpleado(empleado);
        
            return new ModelAndView("redirect:mainEmpleado.html?empleadoApellido");
        }
    
        @RequestMapping(value = "validar/mainEmpleado", method = RequestMethod.GET)
        public ModelAndView mainEmpleado(HttpServletRequest request, HttpServletResponse response){
       
        Map<String, Object> model = new HashMap<String, Object>();
        Empleado empleado=new Empleado();
        empleado.setApPaterno(request.getParameter("empleadoApellido"));
    
    
        model.put("resultadoBEmpleado", empleadoService.buscarEmpleados(empleado));
        return new ModelAndView("modulos/empleados/mainEmpleado", model);
        } 

    
        @RequestMapping(value = "validar/formEmpleadoAdd", method = RequestMethod.POST)
        public ModelAndView formEmpleado(@ModelAttribute("empleadoInsertar") Empleado  empleado, BindingResult result){      
        Map<String, Object> model = new HashMap<String, Object>();
    
        model.put("roles", rolService.buscarRoles());
        return new ModelAndView("modulos/empleados/formEmpleadoAdd", model);
        }
    

    
        @RequestMapping(value = "validar/saveEmpleado", method = RequestMethod.POST)
        public ModelAndView saveEmpleado(@ModelAttribute("empleadoInsertar") Empleado  empleado, BindingResult result) throws Exception {           
            STRCrypto crypt=new STRCrypto();
            String password=crypt.encrypt(empleado.getPassword());
            empleado.setPassword(password);
            
            empleadoService.saveEmpleado(empleado); 
            return new ModelAndView("redirect:mainEmpleado.html?empleadoApellido");
        }
    
        @RequestMapping(value = "validar/deleteEmpleado", method = RequestMethod.GET)
        public ModelAndView deleteEmpleado(HttpServletRequest request, HttpServletResponse response) {
            int id=Integer.parseInt( request.getParameter("idEmpleado"));
            empleadoService.deleteEmpleado(id); 
            return new ModelAndView("redirect:mainEmpleado.html?empleadoApellido");
        }
        
}
