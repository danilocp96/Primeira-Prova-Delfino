/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Entidades.Partido;
import Entidades.Usuario;
import Repositorios.PartidoRepositorio;
import Repositorios.UsuarioRepositorio;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilo Cardoso
 */

public class Usuarios extends javax.swing.JFrame {

    /**
     * Creates new form Usuarios
     */
     
    public Usuarios() {
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
        tbUsuarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnAlterar = new javax.swing.JToggleButton();
        btnExcluir = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        jButton1.setText("Novo Usuario");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnAlterar.setText("Habilitar Alterações");
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });

        btnExcluir.setText("Habilitar Exclusão");
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterar)
                .addGap(108, 108, 108)
                .addComponent(btnExcluir)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private boolean excluir = false;
private boolean alterar = false;
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
          // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbUsuarios.getModel();
        UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
        Usuario usuario = new Usuario();
        String nome = JOptionPane.showInputDialog("Insira o Nome:");
        usuario.setNome(nome);
        String senha = JOptionPane.showInputDialog("Insira a Senha:");
        usuario.setSenha(senha);
        String cpf = JOptionPane.showInputDialog("Insira o CPF:");
        usuario.setCpf(cpf);
        String tipo =JOptionPane.showInputDialog("Insira o tipo de usuario,"
                + " 'A' para Adm e 'E' para Eleitor:");
        char tipos = tipo.charAt(0);
        usuario.setTipo(tipos);
        usuarioRepositorio.inserir(usuario);
        carregarTabela();
    }//GEN-LAST:event_jButton1MouseClicked

    public void testExcluir(){
        UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
        Integer row = tbUsuarios.getSelectedRow();
        String CPF = (String) tbUsuarios.getValueAt(row, 1);
        Usuario usuario = usuarioRepositorio.buscarPorCPF(CPF);
        usuarioRepositorio.excluir(usuario);
        carregarTabela();
        JOptionPane.showMessageDialog(null, "Excluido Com Sucesso.");
        btnExcluir.setText("Excluir");
        excluir = false;
        btnExcluir.setSelected(false);
    }
    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
        // TODO add your handling code here:
         if(alterar == true){
            test();
        }
        else if(excluir == true){
            testExcluir();
        }
    
    }//GEN-LAST:event_tbUsuariosMouseClicked
public void test(){
    UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
        Integer row = tbUsuarios.getSelectedRow();
        Integer col = tbUsuarios.getSelectedColumn();
        String title = (String) tbUsuarios.getColumnName(col);
        String CPF = (String) tbUsuarios.getValueAt(row, 1);
        Usuario usuario = usuarioRepositorio.buscarPorCPF(CPF);
        
        switch (title) {
            case "Nome":
                String n = JOptionPane.showInputDialog("Digite o novo valor:");
                if(n == null){
                    break;
                }
               usuario.setNome(n);
                break;
            case "CPF":
                String cpf = JOptionPane.showInputDialog("Digite o novo valor:");
                if(cpf == null){
                    break;
                }
               usuario.setCpf(cpf);
                break;
            case "Senha":
              String senha = JOptionPane.showInputDialog("Insira a senha:");
                if(senha == null){
                    break;
                }
                usuario.setSenha(senha);
               break;
            case "Tipo":
                String tipo = JOptionPane.showInputDialog("Insira o tipo: 'A' para administrador e 'E' para eleitor");
                if(tipo == null){
                    break;
                }else 
                while(!tipo.equals("A") || !tipo.equals("E")){
                 tipo = JOptionPane.showInputDialog("Insira o tipo: 'A' para administrador e 'E' para eleitor");   
                }
                char tipos = tipo.charAt(0);
                usuario.setTipo(tipos);
        }
        
        usuarioRepositorio.editar(usuario);
        carregarTabela();
}

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        // TODO add your handling code here:
         if(btnAlterar.isSelected() == true){
            JOptionPane.showMessageDialog(null, "Clique no campo que deseja alterar.");
            btnAlterar.setText("Desabilitar Alterações");
            alterar = true;
        }else{
            btnAlterar.setText("Habilitar Alterações");
            alterar = false;
        }
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void btnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseClicked
        // TODO add your handling code here:
         if(btnExcluir.isSelected() == true){
            JOptionPane.showMessageDialog(null, "Clique no usuario que deseja excluir.");
            btnExcluir.setText("Cancelar Exclusão");
            excluir = true;
        }else{
            btnExcluir.setText("Habilitar Exclusão");
            excluir = false;
        }
    }//GEN-LAST:event_btnExcluirMouseClicked
public  void carregarTabela(){
        UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
        List<Usuario> usuarios = usuarioRepositorio.buscarTudoOrdenado();

        String[] colunasTabela = new String []{"Nome", "CPF", "Senha", "Tipo"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela){};
        tbUsuarios.setModel(modeloTabela);
       
        for (Usuario usuario : usuarios) {
            modeloTabela.addRow(new Object[]{usuario.getNome(),usuario.getCpf(),usuario.getSenha(),
            usuario.getTipo()});   
            }
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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAlterar;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
