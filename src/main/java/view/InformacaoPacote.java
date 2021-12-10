/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Dalescio
 */
public class InformacaoPacote extends javax.swing.JFrame {

    /**
     * Creates new form InformacaoPacote
     */
    public InformacaoPacote() {
        initComponents();
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
        jTextPane1 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        PortaoTransporteInformacao = new javax.swing.JTextField();
        VooInformacao = new javax.swing.JTextField();
        HistoricoInformacao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VoltarInformacao = new javax.swing.JButton();
        NomePacoteInfo = new javax.swing.JLabel();
        TipoPacoteInformacao = new javax.swing.JComboBox<>();
        CategoriaPacoteInformacao = new javax.swing.JComboBox<>();
        DestinoPacoteInformacao = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        PoraoInfo = new javax.swing.JComboBox<>();
        VooInfo = new javax.swing.JComboBox<>();
        HistoricoInfo = new javax.swing.JButton();
        NomePacoteInformacao = new javax.swing.JTextField();
        PesoRegistro = new javax.swing.JTextField();
        KgInfo = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(jTextPane1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Dados do Transporte");

        PortaoTransporteInformacao.setText("jTextField1");
        PortaoTransporteInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PortaoTransporteInformacaoActionPerformed(evt);
            }
        });

        VooInformacao.setText("jTextField1");
        VooInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VooInformacaoActionPerformed(evt);
            }
        });

        HistoricoInformacao.setText("Histórico");
        HistoricoInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoInformacaoActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Informações do Pacote");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Dados do Transporte");

        VoltarInformacao.setText("Voltar");
        VoltarInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarInformacaoActionPerformed(evt);
            }
        });

        NomePacoteInfo.setText("jLabel4");

        TipoPacoteInformacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TipoPacoteInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoPacoteInformacaoActionPerformed(evt);
            }
        });

        CategoriaPacoteInformacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CategoriaPacoteInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaPacoteInformacaoActionPerformed(evt);
            }
        });

        DestinoPacoteInformacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DestinoPacoteInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinoPacoteInformacaoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Dados do Pacote");

        PoraoInfo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PoraoInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoraoInfoActionPerformed(evt);
            }
        });

        VooInfo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        VooInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VooInfoActionPerformed(evt);
            }
        });

        HistoricoInfo.setText("Histórico");
        HistoricoInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoInfoActionPerformed(evt);
            }
        });

        NomePacoteInformacao.setText("Nome do responsável");
        NomePacoteInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomePacoteInformacaoActionPerformed(evt);
            }
        });

        PesoRegistro.setText("Peso");
        PesoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesoRegistroActionPerformed(evt);
            }
        });

        KgInfo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        KgInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KgInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(HistoricoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(NomePacoteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VoltarInformacao)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PoraoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(VooInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TipoPacoteInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CategoriaPacoteInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NomePacoteInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PesoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DestinoPacoteInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KgInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(VoltarInformacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomePacoteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoPacoteInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategoriaPacoteInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DestinoPacoteInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomePacoteInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KgInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PoraoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VooInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(HistoricoInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PortaoTransporteInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PortaoTransporteInformacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PortaoTransporteInformacaoActionPerformed

    private void VoltarInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarInformacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VoltarInformacaoActionPerformed

    private void VooInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VooInformacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VooInformacaoActionPerformed

    private void HistoricoInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoInformacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HistoricoInformacaoActionPerformed

    private void PoraoInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoraoInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PoraoInfoActionPerformed

    private void VooInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VooInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VooInfoActionPerformed

    private void TipoPacoteInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoPacoteInformacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoPacoteInformacaoActionPerformed

    private void DestinoPacoteInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinoPacoteInformacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DestinoPacoteInformacaoActionPerformed

    private void CategoriaPacoteInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaPacoteInformacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriaPacoteInformacaoActionPerformed

    private void HistoricoInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HistoricoInfoActionPerformed

    private void NomePacoteInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomePacoteInformacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomePacoteInformacaoActionPerformed

    private void PesoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesoRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PesoRegistroActionPerformed

    private void KgInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KgInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KgInfoActionPerformed

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
            java.util.logging.Logger.getLogger(InformacaoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacaoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacaoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacaoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacaoPacote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CategoriaPacoteInformacao;
    private javax.swing.JComboBox<String> DestinoPacoteInformacao;
    private javax.swing.JButton HistoricoInfo;
    private javax.swing.JButton HistoricoInformacao;
    private javax.swing.JComboBox<String> KgInfo;
    private javax.swing.JLabel NomePacoteInfo;
    private javax.swing.JTextField NomePacoteInformacao;
    private javax.swing.JTextField PesoRegistro;
    private javax.swing.JComboBox<String> PoraoInfo;
    private javax.swing.JTextField PortaoTransporteInformacao;
    private javax.swing.JComboBox<String> TipoPacoteInformacao;
    private javax.swing.JButton VoltarInformacao;
    private javax.swing.JComboBox<String> VooInfo;
    private javax.swing.JTextField VooInformacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
