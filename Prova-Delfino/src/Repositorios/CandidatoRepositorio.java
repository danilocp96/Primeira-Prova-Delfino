/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Candidato;
import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
    public Candidato buscarPorNome(String nome){
        Session sessao =  Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("from Candidato where nome = :nome");
        query.setParameter("nome", nome);
        List list = query.list();
        
        Candidato can = (Candidato) list.get(0);
        sessao.close();
        return can;
    }
    
    public Candidato buscarPorCodigo(Integer codigo){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        
        Candidato resultado = (Candidato) sessao.get(Candidato.class, codigo);
        sessao.close();
        return resultado;
        
    }
}
