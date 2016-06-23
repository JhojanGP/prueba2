/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao;

import com.restaurant.modelo.Categoria;
import java.util.ArrayList;
import java.util.List;

public interface CategoriaDao {
    
    public void saveCategoria(Categoria categoria);
    public ArrayList<Categoria> buscarCategorias();
    public List<Categoria> listaCategoriaId(Categoria categoria);
    public ArrayList<Categoria> buscarNombreCategoria(Categoria categoria);
    public void updateCategoria(Categoria categoria);
    public void deleteCategoria(int id);
    public ArrayList<Categoria> buscarCategoriasId();

}
