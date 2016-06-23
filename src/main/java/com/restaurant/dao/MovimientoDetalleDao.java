/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao;

import com.restaurant.modelo.MovimientoDetalle;
import java.util.ArrayList;


public interface MovimientoDetalleDao {
    
    public ArrayList<MovimientoDetalle> listarMovimientos();
    
}
