/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Votacao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Alan
 */
public class ResultadoRepositorio {
    public List<Votacao> VotosTipo(Character tipo){
    Session sessao = Hibernate.NewHibernateUtil.getSessionFactory().openSession();
    
    Criteria criterio = sessao.createCriteria(Votacao.class);
    
    criterio.add(Restrictions.eq("tipo", tipo));
    //criterio.add(Restrictions.like("%"+"nome"+"%", nome));
    
    criterio.addOrder(Order.asc("tipo"));
    
    List<Votacao> votos = criterio.list();
    sessao.close();  
    return votos; 
    }
}
