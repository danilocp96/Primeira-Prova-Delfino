/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Entidades.Candidato;
import Repositorios.CandidatoRepositorio;
import Repositorios.VotacaoRepositorio;
import Entidades.Votacao;
import Entidades.Usuario;
import static Telas.Votação.usuario;
import java.util.List;

/**
 *
 * @author Jeferson
 */
public class Votação extends javax.swing.JFrame {
    public static Usuario user;
    /**
     * Creates new form Votação
     */
    public Votação(Usuario usuario) {
        initComponents();
        user = usuario;
        
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        btnVotar = new javax.swing.JButton();
        btnBranco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Voatação");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Digite o numero do candidato ");

        txtNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumKeyReleased(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setText("Nome do Candidato");

        btnVotar.setText("Votar");
        btnVotar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVotarMousePressed(evt);
            }
        });

        btnBranco.setText("Branco");
        btnBranco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBrancoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVotar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBranco))
                            .addComponent(jLabel2))
                        .addGap(65, 65, 65))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBranco)
                    .addComponent(btnVotar))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static Usuario usuario; 
    
    private void btnVotarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVotarMousePressed
        Votacao votacao = new Votacao();
        VotacaoRepositorio votacaoRepositorio = new VotacaoRepositorio();
        CandidatoRepositorio candidatoRepositorio = new CandidatoRepositorio();
        Candidato candidato = candidatoRepositorio.buscarPorCodigo(Integer.parseInt(txtNum.getText()));
        
        if(candidato != null){
         votacao.setTipo('V');
         votacao.setCandidato(candidato);
         votacao.setUsuario(usuario);
        }else{
            votacao.setTipo('N');
        }
           
        votacaoRepositorio.inserir(votacao);
            
            
           
        
        
    }//GEN-LAST:event_btnVotarMousePressed

    private void btnBrancoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrancoMousePressed
        Votacao votacao = new Votacao();
        VotacaoRepositorio votacaoRepositorio = new VotacaoRepositorio();
        
        votacao.setTipo('B');
        
        votacaoRepositorio.inserir(votacao);
        
    }//GEN-LAST:event_btnBrancoMousePressed

    private void txtNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumKeyReleased
        CandidatoRepositorio candidatoRepositorio = new CandidatoRepositorio();
        Candidato candidato = candidatoRepositorio.buscarPorCodigo(Integer.parseInt(txtNum.getText()));
        if(candidato != null){
         lblNome.setText(candidato.getNome());
        }else{
            lblNome.setText("");
        }
        
        
    }//GEN-LAST:event_txtNumKeyReleased
    
    private void limparCampos() {
        txtNum.setText("");
        lblNome.setText("Nome do Candidato");
        txtNum.requestFocus();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Votação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Votação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Votação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Votação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Votação(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBranco;
    private javax.swing.JButton btnVotar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
