/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Usuario;
import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 *
 * @author Danilo Cardoso
 */
public class UsuarioRepositorio {
    public void inserir(Usuario usuario){
        Session sessao =  Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(usuario);
        transacao.commit();
        sessao.close();
    }
    
    public void excluir(Usuario usuario){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.delete(usuario);
        transacao.commit();
        sessao.close();
    }
    public void editar(Usuario usuario){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();        
        Transaction transacao = sessao.beginTransaction();
        sessao.update(usuario);
        transacao.commit();
        sessao.close();
    }

    public List<Usuario> buscarTudoOrdenado(){
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();
    
        Criteria criterio = sessao.createCriteria(Usuario.class);
    
        criterio.addOrder(Order.asc("nome"));
    
        List<Usuario> usuarios = criterio.list();
        sessao.close();    
        return usuarios;
    }
    
    public Usuario buscarPorCPF(String CPF) {
        Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();

        Usuario resultado = (Usuario) sessao.get(Usuario.class, CPF);

        sessao.close();

        return resultado;
    }
}
