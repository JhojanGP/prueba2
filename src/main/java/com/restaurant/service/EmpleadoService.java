/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.restaurant.service;

import com.restaurant.modelo.Empleado;
import java.util.ArrayList;
import java.util.List;


public interface  EmpleadoService {
        
    public List<Empleado> validarEmpleado(Empleado empleado);
    public void saveEmpleado(Empleado empleado);
    public void updateEmpleado(Empleado empleado) ;  
    public void deleteEmpleado(int id) ;
    public List<Empleado> listaEmpleadoId(Empleado empleado);
    public ArrayList<Empleado> buscarEmpleados(Empleado empleado) ;
}
