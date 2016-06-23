package com.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Controller
public class IndexController {
    protected final Log logger = LogFactory.getLog(IndexController.class);
   

        @RequestMapping(value = "index", method = RequestMethod.GET)
        public ModelAndView inicio(){      
        return new ModelAndView("index");
        }
      
    
        @RequestMapping(value = "login/add", method = RequestMethod.POST)
        public ModelAndView redirecLogin(){
        return new ModelAndView("admin/fm_wlogin"); 
        }
    
    
        @RequestMapping(value = "validar/frame_Admin", method = RequestMethod.GET)
        public ModelAndView loginFrameAdmin(){      
        return new ModelAndView("admin/index_Frame_Admin");
        }

        @RequestMapping(value = "validar/frame_Mesero", method = RequestMethod.GET)
        public ModelAndView loginFrameMesero(){      
        return new ModelAndView("admin/index_Frame_Mesero");
        }
        
        @RequestMapping(value = "validar/frame_Cajero", method = RequestMethod.GET)
        public ModelAndView loginFrameCajero(){      
        return new ModelAndView("admin/index_Frame_Cajero");
        }
        
        @RequestMapping(value = "validar/frame_Cocinero", method = RequestMethod.GET)
        public ModelAndView loginFrameCocinero(){      
        return new ModelAndView("admin/index_Frame_Cocinero");
        }
    
        @RequestMapping(value = "validar/menu_Admin", method = RequestMethod.GET)
        public ModelAndView loginMenuAdmin(){ 
        return new ModelAndView("admin/menu_Admin");
        }
    
        @RequestMapping(value = "validar/menu_Usuario", method = RequestMethod.GET)
        public ModelAndView loginMenuUsuario(){  
        return new ModelAndView("admin/menu_Usuario");
        }
   
        @RequestMapping(value = "validar/home", method = RequestMethod.GET)
        public ModelAndView loginHome(){      
        return new ModelAndView("admin/home");
        } 
    
        @RequestMapping(value = "validar/logout", method = RequestMethod.GET)
        public ModelAndView loginExit(){      
        return new ModelAndView("admin/detroyxexion");
        }
   
}
