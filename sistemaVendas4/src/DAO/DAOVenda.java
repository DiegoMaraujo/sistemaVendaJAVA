package DAO;

import model.ModelVenda;
import conexao.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Marcio Araujo
*/
public class DAOVenda extends ConexaoMySql {

    /**
    * grava Venda
    * @param pModelVenda
    * return int
    */
    public int salvarVendaDAO(ModelVenda pModelVenda){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_vendas ("
                  
                    + "fk_cliente,"
                    + "ven_date_venda,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_valor_desconto"
                + ") VALUES ("
                  
                    + "'" + pModelVenda.getCliente() + "',"
                    + "'" + pModelVenda.getVenDateVenda() + "',"
                    + "'" + pModelVenda.getVenValorLiquido() + "',"
                    + "'" + pModelVenda.getVenValorBruto() + "',"
                    + "'" + pModelVenda.getVenValorDesconto() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Venda
    * @param pIdVenda
    * return ModelVenda
    */
    public ModelVenda getVendaDAO(int pIdVenda){
        ModelVenda modelVenda = new ModelVenda();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_venda,"
                    + "fk_cliente,"
                    + "ven_date_venda,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_valor_desconto"
                 + " FROM"
                     + " tbl_vendas"
                 + " WHERE"
                     + " pk_id_venda = '" + pIdVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVenda.setIdVenda(this.getResultSet().getInt(1));
                modelVenda.setCliente(this.getResultSet().getInt(2));
                modelVenda.setVenDateVenda(this.getResultSet().getDate(3));
                modelVenda.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVenda.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVenda.setVenValorDesconto(this.getResultSet().getDouble(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVenda;
    }

    /**
    * recupera uma lista de Venda
        * return ArrayList
    */
    public ArrayList<ModelVenda> getListaVendaDAO(){
        ArrayList<ModelVenda> listamodelVenda = new ArrayList();
        ModelVenda modelVenda = new ModelVenda();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_venda,"
                    + "fk_cliente,"
                    + "ven_date_venda,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_valor_desconto"
                 + " FROM"
                     + " tbl_vendas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVenda = new ModelVenda();
                modelVenda.setIdVenda(this.getResultSet().getInt(1));
                modelVenda.setCliente(this.getResultSet().getInt(2));
                modelVenda.setVenDateVenda(this.getResultSet().getDate(3));
                modelVenda.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVenda.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVenda.setVenValorDesconto(this.getResultSet().getDouble(6));
                listamodelVenda.add(modelVenda);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVenda;
    }

    /**
    * atualiza Venda
    * @param pModelVenda
    * return boolean
    */
    public boolean atualizarVendaDAO(ModelVenda pModelVenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_vendas SET "
                    + "pk_id_vendas = '" + pModelVenda.getIdVenda() + "',"
                    + "fk_cliente = '" + pModelVenda.getCliente() + "',"
                    + "ven_date_venda = '" + pModelVenda.getVenDateVenda() + "',"
                    + "ven_valor_liquido = '" + pModelVenda.getVenValorLiquido() + "',"
                    + "ven_valor_bruto = '" + pModelVenda.getVenValorBruto() + "',"
                    + "ven_valor_desconto = '" + pModelVenda.getVenValorDesconto() + "'"
                + " WHERE "
                    + "pk_id_vendas = '" + pModelVenda.getIdVenda() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Venda
    * @param pIdVenda
    * return boolean
    */
    public boolean excluirVendaDAO(int pIdVenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_vendas "
                + " WHERE "
                    + "pk_id_vendas = '" + pIdVenda + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}