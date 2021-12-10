/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.*;
import model.Flight;
import model.Package;
import model.Plane;
import model.TransportData;
import utils.PackageTools;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dalescio
 */
public class AcompanharPacotes extends javax.swing.JFrame {

    /**
     * Creates new form AcompanharPacotes
     */
    public AcompanharPacotes() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VoltarAcompanhar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Acompanhar Pacotes");

        Object [][] defaultData = new Object [][] {
        };

        Object [] defaultColumn = new String [] {
                "Pacote", "Voo", "Parida", "Destino"
        };
        DefaultTableModel tableModel = new DefaultTableModel(defaultData, defaultColumn);

        for (Package aPackage : PackageController.getAllPackages()) {
            TransportData transportData = TransportDataController.getTransportDataPackageId(aPackage.getId());
            Flight flight = FlightController.getFlightById(transportData.getFlightId());
            Plane plane = PlaneController.getPlaneByCallSign(flight.getPlaneCallsign());
            tableModel.addRow(new Object[] {
                    String.format("%s%s%s", PackageTools.getPackageTypeInitials(aPackage.getPackageType()), aPackage.getId(), PackageTools.getPackageCategoryInitials(aPackage.getPackageCategory())),
                    String.format("%s - %s - %s", flight.getPlaneCallsign(), plane.getModel(), plane.getCompany()),
                    flight.getDeparture(),
                    flight.getArrival()
            });
        }
        TabelaAcompanhar = new JTable(tableModel);
        jScrollPane1.setViewportView(TabelaAcompanhar);

        VoltarAcompanhar.setText("Voltar");
        VoltarAcompanhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarAcompanharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(VoltarAcompanhar)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(VoltarAcompanhar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarAcompanharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarAcompanharActionPerformed
        setVisible(false);
        dispose();
        Menu.main();
    }//GEN-LAST:event_VoltarAcompanharActionPerformed

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
            java.util.logging.Logger.getLogger(AcompanharPacotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcompanharPacotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcompanharPacotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcompanharPacotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcompanharPacotes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaAcompanhar;
    private javax.swing.JButton VoltarAcompanhar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
