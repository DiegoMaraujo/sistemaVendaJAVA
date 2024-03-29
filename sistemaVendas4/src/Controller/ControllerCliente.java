package controller;

import model.ModelCliente;
import DAO.DAOCliente;
import java.util.ArrayList;

/**
*
* @author Marcio Araujo
*/
public class ControllerCliente {

   private DAOCliente daoCliente = new DAOCliente();

    /**
    * grava Cliente
    * @param pModelCliente
    * return int
    */
    public int salvarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.salvarClienteDAO(pModelCliente);
    }
    
        /**
    * recupera Nome Cliente
    * @param pIdNomeCliente
    * return ModelCliente
    */
    public ModelCliente getClienteController(String pIdNomeCliente){
        return this.daoCliente.getClienteDAO(pIdNomeCliente);
    }

    /**
    * recupera Cliente
    * @param pIdCliente
    * return ModelCliente
    */
    public ModelCliente getClienteController(int pIdCliente){
        return this.daoCliente.getClienteDAO(pIdCliente);
    }

    /**
    * recupera uma lista deCliente
    * @param pIdCliente
    * return ArrayList
    */
    public ArrayList<ModelCliente> getListaClienteController(){
        return this.daoCliente.getListaClienteDAO();
    }

    /**
    * atualiza Cliente
    * @param pModelCliente
    * return boolean
    */
    public boolean atualizarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.atualizarClienteDAO(pModelCliente);
    }

    /**
    * exclui Cliente
    * @param pIdCliente
    * return boolean
    */
    public boolean excluirClienteController(int pIdCliente){
        return this.daoCliente.excluirClienteDAO(pIdCliente);
    }
}