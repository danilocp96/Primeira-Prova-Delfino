/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Entidades.Candidato;
import Entidades.Votacao;
import Repositorios.CandidatoRepositorio;
import Repositorios.ResultadoRepositorio;
import Repositorios.VotacaoRepositorio;
import java.util.List;
import java.util.Objects;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan
 */
public class Resultado extends javax.swing.JFrame {

    /**
     * Creates new form Resultado
     */
    public Resultado() {
        initComponents();
        carregarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCandidato = new javax.swing.JTable();
        lblNulo = new javax.swing.JLabel();
        lblBranco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbCandidato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Candidato", "Votos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCandidato);

        lblNulo.setText("jLabel1");

        lblBranco.setText("jLabel2");

        jLabel1.setText("Votos Brancos:");

        jLabel2.setText("Votos Nulos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(lblNulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblBranco)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNulo)
                    .addComponent(lblBranco)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ResultadoRepositorio resultadoRepositorio
                = new ResultadoRepositorio();

        List<Votacao> brancos = resultadoRepositorio.VotosTipo('B');
        Integer vBrancos = 0;
        for (Votacao branco : brancos) {
            vBrancos++;
        }
        lblBranco.setText(vBrancos.toString());

        List<Votacao> nulos = resultadoRepositorio.VotosTipo('N');
        Integer vNulos = 0;
        for (Votacao nulo : nulos) {
            vNulos++;
        }
        lblNulo.setText(vNulos.toString());
    }//GEN-LAST:event_formWindowActivated

    public void carregarTabela() {
        CandidatoRepositorio candidatoRepositorio = new CandidatoRepositorio();
        VotacaoRepositorio votacaoRepositorio = new VotacaoRepositorio();
        List<Candidato> candidatos = candidatoRepositorio.buscarTudoOrdenado();
        List<Votacao> votacaos = votacaoRepositorio.BuscarTudo();
        DefaultTableModel modeloTabela = (DefaultTableModel) tbCandidato.getModel();
        System.out.println("--------------------------------------------------");
        for (Candidato candidato : candidatos) {
            Integer voto = 0;
            for (Votacao votacao : votacaos) {
                if (votacao.getCandidato() != null) {
                    if (candidato.getCodigo() == votacao.getCandidato().getCodigo()) {
                        voto++;
                    }
                }
            }
            modeloTabela.addRow(new Object[]{candidato.getNome(), voto.toString()});
        }
        tbCandidato.setModel(modeloTabela);
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
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBranco;
    private javax.swing.JLabel lblNulo;
    private javax.swing.JTable tbCandidato;
    // End of variables declaration//GEN-END:variables
}
