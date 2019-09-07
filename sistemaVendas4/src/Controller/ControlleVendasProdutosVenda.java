
package Controller;

import DAO.DAOProdutosVendasProduto;
import Model.ModelVendasProdutosVenda;
import java.util.ArrayList;

/**
 *
 * @author Marcio Araujo
 */
public class ControlleVendasProdutosVenda {
    private DAOProdutosVendasProduto dAOProdutosVendasProdutos = new DAOProdutosVendasProduto();
        public ArrayList<ModelVendasProdutosVenda>getListaProdutosVendasProdutosController(int pCodeigoVenda){
            return this.dAOProdutosVendasProdutos.getListaProdutosVendasProdutosDAO(pCodeigoVenda);
        
        }
}
