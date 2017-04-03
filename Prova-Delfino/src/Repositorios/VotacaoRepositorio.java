/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Votacao;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Danilo Cardoso
 */
public class VotacaoRepositorio {
    public void inserir(Votacao votacao){
        Session sessao =  Hibernate.NewHibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(votacao);
        transacao.commit();
        sessao.close();
    }
    
}
