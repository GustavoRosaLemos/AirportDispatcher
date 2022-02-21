/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PackageController;
import controller.PackageHistoryController;
import model.Package;
import model.PackageHistory;
import utils.PackageTools;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Dalescio
 */
public class HistoricoAcao extends javax.swing.JFrame {

    /**
     * Creates new form HistoricoAcao
     */
    public void init(int packageId) {
        initComponents(packageId);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(int packageId) {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VoltarHistorico = new javax.swing.JButton();
        StatusHistorico = new javax.swing.JButton();
        if(packageId == -1) {
            StatusHistorico.setVisible(false);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Histórico de Ações");

        Object [][] defaultData = new Object [][] {
        };

        Object [] defaultColumn = new String [] {
                "Autor", "Pacote", "Ação", "Data"
        };
        DefaultTableModel tableModel = new DefaultTableModel(defaultData, defaultColumn);
        if (packageId == -1) {
            List<PackageHistory> packageHistories = PackageHistoryController.getAllPackageHistories();
            Comparator<PackageHistory> comparator = controller.Comparator.builder().build();
            Collections.sort(packageHistories, comparator);
            for (PackageHistory packageHistory : packageHistories) {
                Package aPackage = PackageController.getPackageById(packageHistory.getPackageId());
                tableModel.addRow(new Object[] {
                        packageHistory.getAuthor(),
                        String.format("%s%s%s", PackageTools.getPackageTypeInitials(aPackage.getPackageType()), packageHistory.getPackageId(), PackageTools.getPackageCategoryInitials(aPackage.getPackageCategory())),
                        packageHistory.getAction(),
                        packageHistory.getCreatedAt()
                });
            }
        } else {
            List<PackageHistory> packageHistories = PackageHistoryController.getPackageHistoriesByPackageId(packageId);
            Comparator<PackageHistory> comparator = controller.Comparator.builder().build();
            Collections.sort(packageHistories, comparator);
            for (PackageHistory packageHistory : packageHistories) {
                Package aPackage = PackageController.getPackageById(packageHistory.getPackageId());
                tableModel.addRow(new Object[] {
                        packageHistory.getAuthor(),
                        String.format("%s%s%s", PackageTools.getPackageTypeInitials(aPackage.getPackageType()), packageHistory.getPackageId(), PackageTools.getPackageCategoryInitials(aPackage.getPackageCategory())),
                        packageHistory.getAction(),
                        packageHistory.getCreatedAt()
                });
            }
        }
        TabelaHistorico = new JTable(tableModel);
        jScrollPane1.setViewportView(TabelaHistorico);

        VoltarHistorico.setText("Voltar");
        VoltarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarHistoricoActionPerformed(evt);
            }
        });

        StatusHistorico.setText("Novo Status");
        StatusHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusHistoricoActionPerformed(evt, packageId);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(93, 93, 93))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VoltarHistorico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StatusHistorico)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarHistorico)
                    .addComponent(StatusHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StatusHistoricoActionPerformed(java.awt.event.ActionEvent evt, int packageId) {//GEN-FIRST:event_NomePacoteInformacaoActionPerformed
        setVisible(false);
        dispose();
        AdicionarHistorico.main(packageId);
    }//GEN-LAST:event_NomePacoteInformacaoActionPerformed

    private void VoltarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomePacoteInformacaoActionPerformed
        setVisible(false);
        dispose();
        Menu.main();
    }//GEN-LAST:event_NomePacoteInformacaoActionPerformed

    public static void main() {
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
            java.util.logging.Logger.getLogger(HistoricoAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HistoricoAcao historicoAcao = new HistoricoAcao();
                historicoAcao.init(-1);
                historicoAcao.setVisible(true);
            }
        });
    }

    public static void main(int packageIdReceived) {
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
            java.util.logging.Logger.getLogger(HistoricoAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HistoricoAcao historicoAcao = new HistoricoAcao();
                historicoAcao.init(packageIdReceived);
                historicoAcao.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StatusHistorico;
    private javax.swing.JTable TabelaHistorico;
    private javax.swing.JButton VoltarHistorico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
