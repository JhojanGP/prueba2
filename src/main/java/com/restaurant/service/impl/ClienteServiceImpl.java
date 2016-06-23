/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.dao.ClienteDao;
import com.restaurant.modelo.Cliente;
import com.restaurant.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("clienteService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteDao clienteDao;
    
        public ArrayList<Cliente> buscarCliente(Cliente cliente) {
		return clienteDao.buscarCliente(cliente);
	}
        
        public ArrayList<Cliente> buscarClienteEspecifico(Cliente cliente) {
		return clienteDao.buscarClienteEspecifico(cliente);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveCliente(Cliente cliente) {         
		clienteDao.saveCliente(cliente);
	}
        
        public List<Cliente> listaClienteId(Cliente cliente) {
		return clienteDao.listaClienteId(cliente);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateCliente(Cliente cliente) {         
		clienteDao.updateCliente(cliente);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCliente(int id) {         
		clienteDao.deleteCliente(id);
	}
        
        public ArrayList<Cliente> listarClientes() {
		return clienteDao.listarClientes();
	}
    
    
    
}
