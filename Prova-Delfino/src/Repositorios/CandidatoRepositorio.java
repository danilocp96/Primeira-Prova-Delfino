/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Candidato;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**Classe repositorio para as tarefas da entidade candidato
 *
 * @author Danilo Cardoso
 */
public class CandidatoRepositorio {
    public void inserir(Candidato candidato){
        Session sessao =  Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(candidato);
        transacao.commit();
        sessao.close();
    }
    
    public void excluir(Candidato candidato){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.delete(candidato);
        transacao.commit();
        sessao.close();
    }
    public void editar(Candidato candidato){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();        
        Transaction transacao = sessao.beginTransaction();
        sessao.update(candidato);
        transacao.commit();
        sessao.close();
    }

    public List<Candidato> buscarTudoOrdenado(){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();
    
        Criteria criterio = sessao.createCriteria(Candidato.class);
    
        criterio.addOrder(Order.asc("nome"));
    
        List<Candidato> candidatos = criterio.list();
        sessao.close();    
        return candidatos;
    }
    
    
}