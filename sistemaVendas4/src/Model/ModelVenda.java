package model;

import java.sql.Date;

/**
*
* @author Marcio Araujo
*/
public class ModelVenda {

    private int idVenda;
    private int cliente;
    private Date venDateVenda;
    private double venValorLiquido;
    private double venValorBruto;
    private double venValorDesconto;

    /**
    * Construtor
    */
    public ModelVenda(){}

    /**
    * seta o valor de idVenda
    * @param pIdVenda
    */
    public void setIdVenda(int pIdVenda){
        this.idVenda = pIdVenda;
    }
    /**
    * return pk_idVenda
    */
    public int getIdVenda(){
        return this.idVenda;
    }

    /**
    * seta o valor de cliente
    * @param pCliente
    */
    public void setCliente(int pCliente){
        this.cliente = pCliente;
    }
    /**
    * return fk_cliente
    */
    public int getCliente(){
        return this.cliente;
    }

    /**
    * seta o valor de venDateVenda
    * @param pVenDateVenda
    */
    public void setVenDateVenda(Date pVenDateVenda){
        this.venDateVenda = pVenDateVenda;
    }
    /**
    * return venDateVenda
    */
    public Date getVenDateVenda(){
        return this.venDateVenda;
    }

    /**
    * seta o valor de venValorLiquido
    * @param pVenValorLiquido
    */
    public void setVenValorLiquido(double pVenValorLiquido){
        this.venValorLiquido = pVenValorLiquido;
    }
    /**
    * return venValorLiquido
    */
    public double getVenValorLiquido(){
        return this.venValorLiquido;
    }

    /**
    * seta o valor de venValorBruto
    * @param pVenValorBruto
    */
    public void setVenValorBruto(double pVenValorBruto){
        this.venValorBruto = pVenValorBruto;
    }
    /**
    * return venValorBruto
    */
    public double getVenValorBruto(){
        return this.venValorBruto;
    }

    /**
    * seta o valor de venValorDesconto
    * @param pVenValorDesconto
    */
    public void setVenValorDesconto(double pVenValorDesconto){
        this.venValorDesconto = pVenValorDesconto;
    }
    /**
    * return venValorDesconto
    */
    public double getVenValorDesconto(){
        return this.venValorDesconto;
    }

    @Override
    public String toString(){
        return "ModelVenda {" + "::idVenda = " + this.idVenda + "::cliente = " + this.cliente + "::venDateVenda = " + this.venDateVenda + "::venValorLiquido = " + this.venValorLiquido + "::venValorBruto = " + this.venValorBruto + "::venValorDesconto = " + this.venValorDesconto +  "}";
    }
}