/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoProdutos;
import Model.ModelProdutos;
import java.util.ArrayList;

/**
 *
 * @author Marcio Araujo
 */
public class ControllerProduto {
    private DaoProdutos daoProdutos = new DaoProdutos();
        
    public int salvarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }
    public boolean excluirProdutoController(int pCodigo){
        return this.daoProdutos.excluirProdutoDAO(pCodigo);
    }
    public boolean alterarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.alterarProdutoDAO(pModelProdutos);
        
    }
    
    public ModelProdutos retornarProdutoController(int pCodigo){
        return this.daoProdutos.retornarProdutoDAO(pCodigo);
    }
    
        
    public ModelProdutos retornarProdutoController(String pNomeProduto){
        return this.daoProdutos.retornarProdutoDAO(pNomeProduto);
    }
    
    public ArrayList<ModelProdutos>retornaListaProdutoCotroller(){
        return this.daoProdutos.retornarListaProdutosDAO();
    }
//alter lista produto no banco
    public boolean alterarEstoqueProdutoController(ArrayList<ModelProdutos> plistaModelProdutos) {
        return this.daoProdutos.alterarEstoqueProdutosDAO(plistaModelProdutos);
    }
}
