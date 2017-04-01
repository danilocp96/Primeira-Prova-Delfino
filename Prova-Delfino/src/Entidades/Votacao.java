/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Alan
 */
@Entity
public class Votacao {
    @Id
    @GeneratedValue
    private Integer codigo;
    @ManyToOne
    @JoinColumn
    private Candidato candidato;
    @OneToOne
    @JoinColumn
    private Usuario usuario;
}
