/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.SoftwarePR.AgendaDeTarefas.Interface;

import br.com.SoftwarePR.AgendaDeTarefas.Banco.conexaoBanco;
import br.com.SoftwarePR.AgendaDeTarefas.Construtor.construtorCriarTarefa;
import br.com.SoftwarePR.AgendaDeTarefas.InterfaceAlteracao.interfaceAlterarDadosDaTarefa;
import java.awt.Color;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Paulo
 */
public final class interfaceEditarTarefa extends javax.swing.JFrame {

    /**
     * Creates new form interfaceEditarTarefa
     */
    
    interfaceAlterarDadosDaTarefa alterar;
    
    public interfaceEditarTarefa() {
        initComponents();
        setLocationRelativeTo( null );//Centralizando a Tela
        aumentandoColunaTabela();
        getContentPane().setBackground(new Color(26,30,36));
        PainelTitulo.setBackground(new Color(26,30,36));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PainelTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PainelTitulo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EDITAR TAREFA");
        PainelTitulo.add(jLabel1);

        btnPesquisar.setBackground(new java.awt.Color(0, 102, 102));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/SoftwarePR/AgendaDeTarefas/Icones/Pesquisar.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnMenu.setBackground(new java.awt.Color(0, 102, 102));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/SoftwarePR/AgendaDeTarefas/Icones/Home.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "DESCRICAO", "DATA", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TabelaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PainelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar)
                        .addGap(41, 41, 41)
                        .addComponent(btnMenu)
                        .addGap(125, 125, 125))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar)
                    .addComponent(btnMenu)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
       try{
           interfaceMenuTarefa menu = new interfaceMenuTarefa();
           menu.setVisible(true);
           dispose();
       }catch(Exception e){
           JOptionPane.showConfirmDialog(null,"Error: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        carregarTarefasBusca();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void TabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseReleased
        if(evt.getClickCount() == 2){
            DefaultTableModel dados = (DefaultTableModel) Tabela.getModel();
            
            int numeroLinha = Tabela.getSelectedRow();
            
            if(alterar==null){
                alterar = new interfaceAlterarDadosDaTarefa();
                alterar.setVisible(true);
                try {
                    alterar.receberDados(dados.getValueAt(numeroLinha,0).toString(),
                            dados.getValueAt(numeroLinha,1).toString(),
                            dados.getValueAt(numeroLinha,2).toString(),
                            dados.getValueAt(numeroLinha,3).toString(),
                            dados.getValueAt(numeroLinha,4).toString());
                } catch (ParseException ex) {
                    Logger.getLogger(interfaceEditarTarefa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                alterar.setState(interfaceAlterarDadosDaTarefa.NORMAL);
                alterar = new interfaceAlterarDadosDaTarefa();
                alterar.setVisible(true);
                try {
                    alterar.receberDados(dados.getValueAt(numeroLinha,0).toString(),
                            dados.getValueAt(numeroLinha,1).toString(),
                            dados.getValueAt(numeroLinha,2).toString(),
                            dados.getValueAt(numeroLinha,3).toString(),
                            dados.getValueAt(numeroLinha,4).toString());
                } catch (ParseException ex) {
                    Logger.getLogger(interfaceEditarTarefa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          
        }else{
            
        }
    }//GEN-LAST:event_TabelaMouseReleased

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
            java.util.logging.Logger.getLogger(interfaceEditarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaceEditarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaceEditarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaceEditarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaceEditarTarefa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelTitulo;
    private javax.swing.JTable Tabela;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
    public void carregarTarefasBusca(){       
        try{
            String busca = txtPesquisa.getText();
            conexaoBanco Banco = new conexaoBanco();

            List<construtorCriarTarefa> lista = Banco.ListarTarefasBuscar(busca);

            DefaultTableModel dados = (DefaultTableModel) Tabela.getModel();

            dados.setNumRows(0);

            for(construtorCriarTarefa linha : lista){
                dados.addRow(new Object[]{
                    linha.getId(),
                    linha.getNome(),
                    linha.getDescricao(),
                    linha.getData(),
                    linha.getStatus()
                });

            }
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
        
    public void aumentandoColunaTabela(){
        
        TableColumn colunaNome = Tabela.getColumnModel().getColumn(1);
        TableColumn colunaDescricao = Tabela.getColumnModel().getColumn(2);
        TableColumn colunaData = Tabela.getColumnModel().getColumn(3);
        TableColumn colunaStatus = Tabela.getColumnModel().getColumn(3);
        colunaNome.setPreferredWidth(300);
        colunaDescricao.setPreferredWidth(500);
        colunaData.setPreferredWidth(200);
        colunaStatus.setPreferredWidth(200);
    }
        
        
}
    
    




