/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.gui.ageing;

import cz.fidentis.ageing.AgeingComputation;
import cz.fidentis.controller.Ageing;
import cz.fidentis.controller.Gender;
import cz.fidentis.featurepoints.FacialPoint;
import cz.fidentis.featurepoints.results.FpResultsBatch;
import cz.fidentis.gui.GUIController;
import cz.fidentis.gui.ProjectTopComponent;
import cz.fidentis.featurepoints.FpModel;
import cz.fidentis.gui.actions.newprojectwizard.ModelFileFilter;
import cz.fidentis.model.Model;
import cz.fidentis.model.ModelExporter;
import cz.fidentis.model.ModelLoader;
import cz.fidentis.processing.exportProcessing.FPImportExport;
import cz.fidentis.processing.featurePoints.FpProcessing;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import org.openide.util.Cancellable;

/**
 *
 * @author Marek Zuzi
 */
public class AgeingConfiguration extends javax.swing.JPanel {

    /**
     * Creates new form AgeingConfiguration
     */
    public AgeingConfiguration() {
        initComponents();
    }
    
    public void setConfiguration() {
        Ageing ageing = GUIController.getSelectedProjectTopComponent().getProject().getSelectedAgeing();
        if (ageing == null) {
            this.originAgeSpinner.setValue(0f);
            this.targetAgeSpinner.setValue(0f);
            this.genderSelect.setSelectedItem(Gender.MALE);
            loadModelButton.setEnabled(true);
            computePointsButton.setEnabled(false);
            loadPointsButton.setEnabled(false);
            computeButton.setEnabled(false);
            exportButton.setEnabled(false);
        } else {
            this.originAgeSpinner.setValue(ageing.getOriginAge());
            this.targetAgeSpinner.setValue(ageing.getTargetAge());
            this.genderSelect.setSelectedItem(ageing.getGender());
            loadModelButton.setEnabled(true);
            loadPointsButton.setEnabled(ageing.getOriginModel() != null);
            computeButton.setEnabled(ageing.getOriginFacialPoints() != null);
            computePointsButton.setEnabled(ageing.getOriginModel() != null);
            exportButton.setEnabled(ageing.getTargetModel() != null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroller = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        loadPointsButton = new javax.swing.JButton();
        computePointsButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        fpAddButton = new javax.swing.JButton();
        fpRemoveButton = new javax.swing.JButton();
        fpEditButton = new javax.swing.JToggleButton();
        fpValidateButton = new javax.swing.JButton();
        fpInfoCheck = new javax.swing.JCheckBox();
        exportPointsButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        loadModelButton = new javax.swing.JButton();
        genderSelect = new JComboBox<Gender>(Gender.values());
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        originAgeSpinner = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        targetAgeSpinner = new javax.swing.JSpinner();
        computeButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        exportButton = new javax.swing.JButton();

        jPanel2.setPreferredSize(new java.awt.Dimension(260, 500));

        org.openide.awt.Mnemonics.setLocalizedText(loadPointsButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.loadPointsButton.text")); // NOI18N
        loadPointsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadPointsButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(computePointsButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.computePointsButton.text")); // NOI18N
        computePointsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computePointsButtonActionPerformed(evt);
            }
        });

        jPanel3.setLayout(new java.awt.GridLayout(2, 2));

        org.openide.awt.Mnemonics.setLocalizedText(fpAddButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.fpAddButton.text")); // NOI18N
        fpAddButton.setEnabled(false);
        jPanel3.add(fpAddButton);

        org.openide.awt.Mnemonics.setLocalizedText(fpRemoveButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.fpRemoveButton.text")); // NOI18N
        fpRemoveButton.setEnabled(false);
        jPanel3.add(fpRemoveButton);

        org.openide.awt.Mnemonics.setLocalizedText(fpEditButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.fpEditButton.text")); // NOI18N
        fpEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fpEditButtonActionPerformed(evt);
            }
        });
        jPanel3.add(fpEditButton);

        org.openide.awt.Mnemonics.setLocalizedText(fpValidateButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.fpValidateButton.text")); // NOI18N
        fpValidateButton.setEnabled(false);
        jPanel3.add(fpValidateButton);

        org.openide.awt.Mnemonics.setLocalizedText(fpInfoCheck, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.fpInfoCheck.text")); // NOI18N
        fpInfoCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fpInfoCheckActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(exportPointsButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.exportPointsButton.text")); // NOI18N
        exportPointsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPointsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadPointsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(computePointsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fpInfoCheck)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(exportPointsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadPointsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(computePointsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportPointsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fpInfoCheck))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(loadModelButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.loadModelButton.text")); // NOI18N
        loadModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadModelButtonActionPerformed(evt);
            }
        });

        genderSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderSelectActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.jLabel4.text")); // NOI18N
        jLabel4.setToolTipText(org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.jLabel4.toolTipText")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.jLabel1.text")); // NOI18N

        originAgeSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 0.5f));
        originAgeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                originAgeSpinnerStateChanged(evt);
            }
        });

        targetAgeSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 0.5f));
        targetAgeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                targetAgeSpinnerStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(computeButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.computeButton.text")); // NOI18N
        computeButton.setEnabled(false);
        computeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computeButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(exportButton, org.openide.util.NbBundle.getMessage(AgeingConfiguration.class, "AgeingConfiguration.exportButton.text")); // NOI18N
        exportButton.setEnabled(false);
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(computeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(targetAgeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(targetAgeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(computeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exportButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadModelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(originAgeSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(genderSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(originAgeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(genderSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loadModelButton)
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scroller.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroller)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroller)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void computeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computeButtonActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        final Ageing ageing = tc.getProject().getSelectedAgeing();
        if(ageing.getOriginModel() == null || ageing.getOriginFacialPoints() == null) {
            return;
        }
        
        AgeingComputation comp = new AgeingComputation(ageing.getOriginModel(), ageing.getOriginFacialPoints(), ageing.getGender(), ageing.getOriginAge());
        comp.computeToAge(ageing.getTargetAge());

        ageing.setTargetModel(comp.getTargetModel());
        ageing.setTargetPoints(comp.getTargetPoints());
        tc.getAgeingViewerPanel().getListenerTarget().setModels(ageing.getTargetModel());
        tc.getAgeingViewerPanel().getListenerTarget().setFacialPoints(ageing.getTargetPoints());
        tc.getAgeingViewerPanel().getTargetCanvas().setVisible(true);
        tc.getAgeingViewerPanel().resizeSplitPane();
        exportButton.setEnabled(true);
    }//GEN-LAST:event_computeButtonActionPerformed

    private void loadModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadModelButtonActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        final Ageing ageing = tc.getProject().getSelectedAgeing();

        tc.triggerAddModel(true);
        if(ageing.getOriginModel() != null) {
            computePointsButton.setEnabled(true);
            loadPointsButton.setEnabled(true);
        }
    }//GEN-LAST:event_loadModelButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        ModelExporter exp = new ModelExporter(GUIController.getSelectedProjectTopComponent().getProject().getSelectedAgeing().getTargetModel());
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new ModelFileFilter(new String[]{"obj"}, "OBJ files"));
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            exp.exportModelToObj(chooser.getSelectedFile(), Boolean.TRUE);
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    private void computePointsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computePointsButtonActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        final Ageing ageing = tc.getProject().getSelectedAgeing();
        if(ageing.getOriginModel() == null) {
            return;
        }

        Runnable r = new Runnable() {
            @Override
            public void run() {
                Cancellable cancelTask = new Cancellable() {
                    @Override
                    public boolean cancel() {
                        Thread.currentThread().interrupt();
                        return true;
                    }
                };
                ArrayList<File> models = new ArrayList<>(1);
                models.add(ageing.getOriginModel().getFile());
                
                //TODO: add new landmark detection
//                FpResultsBatch result = FpProcessing.instance().calculatePointsBatch(cancelTask, models);
//                Model registered = ModelLoader.instance().loadModel(ageing.getOriginModel().getFile(), Boolean.TRUE, Boolean.TRUE);
//
//                List<FacialPoint> pts = result.getFps().get(ageing.getOriginModel().getName());
//                tc.getAgeingViewerPanel().getListenerOrigin().setModels(registered);
//                tc.getAgeingViewerPanel().getListenerOrigin().setFacialPoints(pts);
//                ageing.setOriginFacialPoints(pts);
//                ageing.setOriginModel(registered);
                computeButton.setEnabled(true);
            }
        };
        Thread t = new Thread(r);
        t.start();
    }//GEN-LAST:event_computePointsButtonActionPerformed

    private void loadPointsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPointsButtonActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        final Ageing ageing = tc.getProject().getSelectedAgeing();
        if(ageing.getOriginModel() == null) {
            return;
        }

        List<FpModel> loaded = FPImportExport.instance().importPoints(tc, true);
        if(loaded != null && !loaded.isEmpty()) {
            List<FacialPoint> fps = loaded.get(0).getFacialPoints();
            ageing.setOriginFacialPoints(fps);
            tc.getAgeingViewerPanel().getListenerOrigin().setFacialPoints(fps);
            computeButton.setEnabled(true);
        }
    }//GEN-LAST:event_loadPointsButtonActionPerformed

    private void fpInfoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fpInfoCheckActionPerformed
        GUIController.getSelectedProjectTopComponent().getAgeingViewerPanel().showInfo(fpInfoCheck.isSelected());
    }//GEN-LAST:event_fpInfoCheckActionPerformed

    private void fpEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fpEditButtonActionPerformed
        GUIController.getSelectedProjectTopComponent().getAgeingViewerPanel().setEditablePoints(fpEditButton.isSelected());
    }//GEN-LAST:event_fpEditButtonActionPerformed

    private void exportPointsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPointsButtonActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        FPImportExport.instance().exportBatch(tc, tc.getProject().getSelectedBatchComparison());
        //FPImportExport.instance().
    }//GEN-LAST:event_exportPointsButtonActionPerformed

    private void targetAgeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_targetAgeSpinnerStateChanged
        GUIController.getSelectedProjectTopComponent().getProject().getSelectedAgeing().setTargetAge((float)targetAgeSpinner.getValue());
    }//GEN-LAST:event_targetAgeSpinnerStateChanged

    private void originAgeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_originAgeSpinnerStateChanged
        GUIController.getSelectedProjectTopComponent().getProject().getSelectedAgeing().setOriginAge((float)originAgeSpinner.getValue());
    }//GEN-LAST:event_originAgeSpinnerStateChanged

    private void genderSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderSelectActionPerformed
        GUIController.getSelectedProjectTopComponent().getProject().getSelectedAgeing().setGender(genderSelect.getItemAt(genderSelect.getSelectedIndex()));
    }//GEN-LAST:event_genderSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton computeButton;
    private javax.swing.JButton computePointsButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton exportPointsButton;
    private javax.swing.JButton fpAddButton;
    private javax.swing.JToggleButton fpEditButton;
    private javax.swing.JCheckBox fpInfoCheck;
    private javax.swing.JButton fpRemoveButton;
    private javax.swing.JButton fpValidateButton;
    private javax.swing.JComboBox<Gender> genderSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton loadModelButton;
    private javax.swing.JButton loadPointsButton;
    private javax.swing.JSpinner originAgeSpinner;
    private javax.swing.JScrollPane scroller;
    private javax.swing.JSpinner targetAgeSpinner;
    // End of variables declaration//GEN-END:variables
}
