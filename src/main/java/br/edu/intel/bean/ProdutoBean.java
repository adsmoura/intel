/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.intel.bean;

import br.edu.intel.Produto;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import java.util.List;
import br.edu.intel.dao.ProdutoDAO;
import javax.annotation.PostConstruct;

/**
 *
 * @author Andre
 */
@ManagedBean
public class ProdutoBean {
    
    private Produto p = new Produto();
    
    private List<Produto> produto = new ArrayList<>();
    
    private final ProdutoDAO pDao = new ProdutoDAO();
    
    public void salvarProduto(Produto p){
        pDao.salvar(p);
        p = new Produto();
        carregaLista();
    }
    
    public void excluirProduto(Produto p){
        pDao.excluir(p);
        carregaLista();
    }
    
    @PostConstruct
    public void carregaLista(){
        produto = pDao.consultarLista();
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
    
    
}
