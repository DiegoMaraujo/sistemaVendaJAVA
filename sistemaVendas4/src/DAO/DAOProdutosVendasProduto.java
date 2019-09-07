/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModelProdutos;
import Model.ModelVendasProdutos;
import Model.ModelVendasProdutosVenda;
import conexao.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Marcio Araujo
 */
// Lista que vai percorer as tabelas vendasProdutos e produtos 
public class DAOProdutosVendasProduto extends ConexaoMySql{
    public ArrayList<ModelVendasProdutosVenda> getListaProdutosVendasProdutosDAO(int pCodigoVenda){
        ArrayList<ModelVendasProdutosVenda> listaModelProdutosVendaProdutos = new ArrayList<>();
        ModelVendasProdutosVenda modelVendasProdutosVenda = new ModelVendasProdutosVenda();
        ModelProdutos modelProdutos = new ModelProdutos();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
            try {
                this.conectar();
                this.executarSQL("SELECT tbl_produto.pk_id_produto, "                   
                        
                           + "tbl_produto.pro_nome,"
                           + "tbl_produto.pro_valor,"
                           + "tbl_produto.pro_estoque,"
                           + "tbl_vendas_produtos.fk_produto,"
                           + "tbl_vendas_produtos.fk_vendas,"
                           + "tbl_vendas_produtos.pk_id_venda_produto,"
                           
                           + "tbl_vendas_produtos.ven_pro_valor,"
                           + "tbl_vendas_produtos.ven_pro_quantidade"
                           + " FROM tbl_vendas_produtos "
                           + "INNER JOIN tbl_produto on tbl_produto.pk_id_produto = tbl_vendas_produtos.fk_produto  "
                           + "WHERE tbl_vendas_produtos.fk_vendas = '"+pCodigoVenda+"';");
                    
                while(this.getResultSet().next()){
                        modelVendasProdutosVenda = new ModelVendasProdutosVenda();
                        modelProdutos = new ModelProdutos();
                        modelVendasProdutos = new ModelVendasProdutos();
                        // tabela Produto
                        modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                        modelProdutos.setProNome(this.getResultSet().getString(2));
                        modelProdutos.setProValor(this.getResultSet().getDouble(3));
                        modelProdutos.setProEstoque(this.getResultSet().getInt(4));
                        
                        
                        // tabela venda produto
                        modelVendasProdutos.setProduto(this.getResultSet().getInt(5));
                        modelVendasProdutos.setVendas(this.getResultSet().getInt(6));
                        modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(7));
                        modelVendasProdutos.setVenProValor(this.getResultSet().getDouble(8));
                        modelVendasProdutos.setVenProQuantidade(this.getResultSet().getInt(9));
                        
                        modelVendasProdutosVenda.setModelProdutos(modelProdutos);
                        modelVendasProdutosVenda.setModelVendasProdutos(modelVendasProdutos);
                        
                        listaModelProdutosVendaProdutos.add(modelVendasProdutosVenda);
                    
                    }    
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
                fecharConexao();
        }
        return listaModelProdutosVendaProdutos;
    }
}
