/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOVendasClientes;
import java.util.ArrayList;
import model.ModelCliente;
import model.ModelVendasCliente;

/**
 *
 * @author Marcio Araujo
 */
public class ControllerVendaCliente {

        
    private DAO.DAOVendasClientes dAOVendasClientes= new DAOVendasClientes();
    
   
    public ArrayList<ModelVendasCliente> getListaVendasClientesController() {
        return this.dAOVendasClientes.getListaVendasCClientesDAO();
    }
}
