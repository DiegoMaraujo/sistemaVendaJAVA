/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.ModelVendasCliente;
import conexao.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCliente;
import model.ModelVenda;

/**
 *
 * @author Marcio Araujo
 */
public class DAOVendasClientes extends ConexaoMySql{
        
  
    public ArrayList<ModelVendasCliente>getListaVendasCClientesDAO(){
       
        ArrayList<ModelVendasCliente> listamodelVendasclientes = new ArrayList();
        ModelVenda modelVendas = new ModelVenda();
        ModelCliente modelClientes = new ModelCliente();
        ModelVendasCliente modelVendasClientes  = new ModelVendasCliente();
        
        try {
            this.conectar();
            this.executarSQL(
                     "SELECT "
                             + "tbl_vendas.pk_id_vendas,"
                             + " tbl_vendas.fk_cliente, "
                             + "tbl_vendas.ven_date_venda, "
                             + "tbl_vendas.ven_valor_liquido, "
                             + "tbl_vendas.ven_valor_bruto, "
                             + "tbl_vendas.ven_valor_desconto, "
                             + "tbl_cliente.pk_id_cliente, "
                             + "tbl_cliente.cli_nome, "
                             + "tbl_cliente.cli_endereco, "
                             + "tbl_cliente.cli_bairro, "
                             + "tbl_cliente.cli_cidade, "
                             + "tbl_cliente.cli_uf, "
                             + "tbl_cliente.cli_cep, "
                             + "tbl_cliente.cli_telefone"                
                        + " FROM  "
                             + " tbl_vendas INNER JOIN tbl_cliente "
                                + "ON tbl_cliente.pk_id_cliente = tbl_vendas.fk_cliente; "
            
                + ";"
            );

            while(this.getResultSet().next()){
                
                modelVendas = new ModelVenda();
                modelClientes = new ModelCliente();
                modelVendasClientes = new ModelVendasCliente();
                
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVenDateVenda(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenValorDesconto(this.getResultSet().getDouble(6));
               
                //Clientes
                modelClientes.setIdCliente(this.getResultSet().getInt(7));
                modelClientes.setCliNome(this.getResultSet().getString(8));
                modelClientes.setCliEndereco(this.getResultSet().getString(9));
                modelClientes.setCliBairro(this.getResultSet().getString(10));
                modelClientes.setCliCidade(this.getResultSet().getString(11));
                modelClientes.setCliUf(this.getResultSet().getString(12));
                modelClientes.setCliCep(this.getResultSet().getString(13));
                modelClientes.setCliTelefone(this.getResultSet().getString(14));
               
                modelVendasClientes.setModelCliente(modelClientes);
                modelVendasClientes.setModelVenda(modelVendas);
               
                
                listamodelVendasclientes.add(modelVendasClientes);
            }
           
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasclientes;
    }
}
