/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service;

import com.restaurant.modelo.Mesa;
import java.util.ArrayList;

public interface MesaService {
    
    public ArrayList<Mesa> Mesas() ;
    public void updateMesa(Mesa mesa);
    
}
