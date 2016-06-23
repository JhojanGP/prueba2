/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.restaurant.service.impl;

import com.restaurant.dao.EmpleadoDao;
import com.restaurant.modelo.Empleado;
import com.restaurant.service.EmpleadoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("empleadoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmpleadoServiceImpl implements EmpleadoService {
    
    @Autowired
    private EmpleadoDao empleadoDao;
    
        
        public List<Empleado> validarEmpleado(Empleado empleado){
        return empleadoDao.validarEmpleado(empleado);
        }
	 
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateEmpleado(Empleado empleado) {         
		empleadoDao.updateEmpleado(empleado);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteEmpleado(int id) {         
		empleadoDao.deleteEmpleado(id);
	}

         @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveEmpleado(Empleado empleado) {         
		empleadoDao.saveEmpleado(empleado);
	}

        public List<Empleado> listaEmpleadoId(Empleado empleado) {
		return empleadoDao.listaEmpleadoId(empleado);
	}
        
        public ArrayList<Empleado> buscarEmpleados(Empleado empleado) {
		return empleadoDao.buscarEmpleados(empleado);
	}
        
        

}