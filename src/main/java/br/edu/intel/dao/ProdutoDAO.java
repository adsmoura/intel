/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.intel.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.intel.Produto;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andre
 */
public class ProdutoDAO {

    //Criando Unidade de Persistencia
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("bd_intel.jsf");
    final EntityManager em = factory.createEntityManager();
    
    public void salvar(Produto p) {
        em.getTransaction();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public Produto consultarProduto(int codigo) {
        Produto p = em.find(Produto.class, codigo);
        return p;
        
    }
    
    public List<Produto> consultarLista() {
        TypedQuery<Produto> query = em.createQuery("select p from Produto p", Produto.class);
        List<Produto> produto = query.getResultList();
        return produto;
    }
    
    public void excluir(Produto p) {
        em.getTransaction().begin();
        p = em.merge(p);
        em.remove(p);
        em.getTransaction().commit();
    }
    
}
