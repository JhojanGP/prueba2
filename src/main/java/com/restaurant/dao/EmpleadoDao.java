/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.restaurant.dao;

import com.restaurant.modelo.Empleado;
import java.util.ArrayList;
import java.util.List;


public interface  EmpleadoDao {
    
    public List<Empleado> validarEmpleado(Empleado usuario);
    public void saveEmpleado(Empleado usuario);
    public void deleteEmpleado(int id);
    public void updateEmpleado(Empleado usuario);
    public List<Empleado> listaEmpleadoId(Empleado persona);
    public ArrayList<Empleado> buscarEmpleados(Empleado empleado);
    
 
 
}
