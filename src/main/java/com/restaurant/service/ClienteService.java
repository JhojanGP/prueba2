/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service;

import com.restaurant.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;


public interface ClienteService {
    
    public ArrayList<Cliente> buscarCliente(Cliente cliente) ;
    public void saveCliente(Cliente cliente);
    public List<Cliente> listaClienteId(Cliente cliente);
    public void updateCliente(Cliente cliente);
    public void deleteCliente(int id);
    public ArrayList<Cliente> listarClientes();
    public ArrayList<Cliente> buscarClienteEspecifico(Cliente cliente);
}
