/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Partido;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 *
 * @author Danilo Cardoso
 */
public class PartidoRepositorio {
    public void inserir(Partido partido){
        Session sessao =  Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(partido);
        transacao.commit();
        sessao.close();
    }
    
    public void excluir(Partido partido){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.delete(partido);
        transacao.commit();
        sessao.close();
    }
    public void editar(Partido partido){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();        
        Transaction transacao = sessao.beginTransaction();
        sessao.update(partido);
        transacao.commit();
        sessao.close();
    }

    public List<Partido> buscarTudoOrdenado(){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();
    
        Criteria criterio = sessao.createCriteria(Partido.class);
    
        criterio.addOrder(Order.asc("sigla"));
    
        List<Partido> partidos = criterio.list();
        sessao.close();    
        return partidos;
    }
    
    public Partido buscarPorNome(String nome){
        Session sessao =  Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("from Partido where nome = :nome");
        query.setParameter("nome", nome);
        List list = query.list();
        
        Partido par = (Partido) list.get(0);
        sessao.close();
        return par;
    }
}
