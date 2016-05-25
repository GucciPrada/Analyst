/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.gui;

import cz.fidentis.controller.Controller;
import cz.fidentis.controller.Project;
import cz.fidentis.gui.actions.ButtonHelper;
import cz.fidentis.gui.observer.ProgressHandleMaster;
import cz.fidentis.gui.observer.ProgressHandleObserver;
import cz.fidentis.utils.FileUtils;
import cz.fidentis.utilsException.FileManipulationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;

/**
 *
 * @author Katka
 */
public class StartingPanel extends javax.swing.JPanel {

    /**
     * Creates new form StartingPanel
     */
    public StartingPanel() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        compositeCreationPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        compare2facesPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        oneToManyComparisonPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        batchComparisonPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(StartingPanel.class, "StartingPanel.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "<html><FONT SIZE = 3>Create composite by selecting various facial parts and adding them to face. </FONT></html>");
        jLabel2.setToolTipText(org.openide.util.NbBundle.getMessage(StartingPanel.class, "StartingPanel.jLabel2.toolTipText")); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        //jLabel1 = new javax.swing.JLabel("Hyderabad, India:<p> Tourist places:" + "<ul>" + "<li>Charminar</li>" + "<li>Salarujung Museum</li>" + "<li>Ramoji Film City</li>" + "</ul> </font> </html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        compositeCreationPanel.setBackground(new java.awt.Color(61, 61, 63));
        compositeCreationPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compositeCreationPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                compositeCreationPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                compositeCreationPanelMouseExited(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/composite.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(StartingPanel.class, "StartingPanel.jLabel1.text")); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        //jLabel1 = new javax.swing.JLabel("Hyderabad, India:<p> Tourist places:" + "<ul>" + "<li>Charminar</li>" + "<li>Salarujung Museum</li>" + "<li>Ramoji Film City</li>" + "</ul> </font> </html>");

        javax.swing.GroupLayout compositeCreationPanelLayout = new javax.swing.GroupLayout(compositeCreationPanel);
        compositeCreationPanel.setLayout(compositeCreationPanelLayout);
        compositeCreationPanelLayout.setHorizontalGroup(
            compositeCreationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compositeCreationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );
        compositeCreationPanelLayout.setVerticalGroup(
            compositeCreationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compositeCreationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(compositeCreationPanel);

        compare2facesPanel.setBackground(new java.awt.Color(61, 61, 63));
        compare2facesPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compare2facesPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                compare2facesPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                compare2facesPanelMouseExited(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/2faces.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(StartingPanel.class, "StartingPanel.jLabel6.text")); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        //jLabel1 = new javax.swing.JLabel("Hyderabad, India:<p> Tourist places:" + "<ul>" + "<li>Charminar</li>" + "<li>Salarujung Museum</li>" + "<li>Ramoji Film City</li>" + "</ul> </font> </html>");

        javax.swing.GroupLayout compare2facesPanelLayout = new javax.swing.GroupLayout(compare2facesPanel);
        compare2facesPanel.setLayout(compare2facesPanelLayout);
        compare2facesPanelLayout.setHorizontalGroup(
            compare2facesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, compare2facesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );
        compare2facesPanelLayout.setVerticalGroup(
            compare2facesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compare2facesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(compare2facesPanel);

        oneToManyComparisonPanel.setBackground(new java.awt.Color(61, 61, 63));
        oneToManyComparisonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneToManyComparisonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                oneToManyComparisonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                oneToManyComparisonPanelMouseExited(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/database.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(StartingPanel.class, "StartingPanel.jLabel11.text")); // NOI18N
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        //jLabel1 = new javax.swing.JLabel("Hyderabad, India:<p> Tourist places:" + "<ul>" + "<li>Charminar</li>" + "<li>Salarujung Museum</li>" + "<li>Ramoji Film City</li>" + "</ul> </font> </html>");

        javax.swing.GroupLayout oneToManyComparisonPanelLayout = new javax.swing.GroupLayout(oneToManyComparisonPanel);
        oneToManyComparisonPanel.setLayout(oneToManyComparisonPanelLayout);
        oneToManyComparisonPanelLayout.setHorizontalGroup(
            oneToManyComparisonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oneToManyComparisonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );
        oneToManyComparisonPanelLayout.setVerticalGroup(
            oneToManyComparisonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oneToManyComparisonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(oneToManyComparisonPanel);

        batchComparisonPanel.setBackground(new java.awt.Color(61, 61, 63));
        batchComparisonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batchComparisonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                batchComparisonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                batchComparisonPanelMouseExited(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/batch.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(StartingPanel.class, "StartingPanel.jLabel10.text")); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        //jLabel1 = new javax.swing.JLabel("Hyderabad, India:<p> Tourist places:" + "<ul>" + "<li>Charminar</li>" + "<li>Salarujung Museum</li>" + "<li>Ramoji Film City</li>" + "</ul> </font> </html>");

        javax.swing.GroupLayout batchComparisonPanelLayout = new javax.swing.GroupLayout(batchComparisonPanel);
        batchComparisonPanel.setLayout(batchComparisonPanelLayout);
        batchComparisonPanelLayout.setHorizontalGroup(
            batchComparisonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(batchComparisonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );
        batchComparisonPanelLayout.setVerticalGroup(
            batchComparisonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(batchComparisonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(batchComparisonPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void compositeCreationPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compositeCreationPanelMouseEntered
        jLabel4.setText("Create Composite");jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/composite-hover.png")));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "<html><FONT SIZE = 3>Create composite by selecting various facial parts and adding them to face. </FONT></html>");
    }//GEN-LAST:event_compositeCreationPanelMouseEntered

    private void compare2facesPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compare2facesPanelMouseEntered
        jLabel4.setText("Compare two faces");
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/2faces-hover.png")));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "<html><FONT SIZE = 3>Compare two faces. "
                + "<ul>\n"
                + "<li>Registration methods: Feature ponits alignment, ICP</li>\n"
                + "<li>Compariosn methods: Procrustes analysis, Hausdroff distance</li>\n"
                + "</ul></FONT></html>");
    }//GEN-LAST:event_compare2facesPanelMouseEntered

    private void oneToManyComparisonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneToManyComparisonPanelMouseEntered
        jLabel4.setText("Compare one model with database");
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/database-hover.png")));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "<html><FONT SIZE = 3>Compare one model with database or set of faces."
                + "<ul>\n"
                + "<li>Registration methods: Feature ponits alignment, ICP</li>\n"
                + "<li>Compariosn methods: Procrustes analysis, Hausdroff distance</li>\n"
                + "</ul></FONT></html>");
    }//GEN-LAST:event_oneToManyComparisonPanelMouseEntered

    private void batchComparisonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batchComparisonPanelMouseEntered
        jLabel4.setText("Batch processing");
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/batch-hover.png")));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "<html><FONT SIZE = 3>Compare a set of faces. \n"
                + "<ul>\n"
                + "<li>Registration methods: Feature ponits alignment, ICP</li>\n"
                + "<li>Compariosn methods: Procrustes analysis, Hausdroff distance</li>\n"
                + "</ul></FONT></html>");
    }//GEN-LAST:event_batchComparisonPanelMouseEntered

    public static void createNewProject() {
        ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        if (tc.getName().equals("New Project")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            Project project = new Project("Project " + dateFormat.format(date));
            project.setName("Project " + dateFormat.format(date));
            try {
                ProgressHandleMaster master = new ProgressHandleMaster();
                final ProgressHandleObserver obs = new ProgressHandleObserver("Deleting tmp files");
                master.addObserver(obs);
                
                Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        obs.startHandle();
                    }
                };
                
                Thread t = new Thread(run);
                t.start();                    
                
                project.setTempDirectory(FileUtils.instance()
                        .createTMPmoduleFolder(String.valueOf(System.currentTimeMillis())));
                
                master.updateObservers();
            } catch (FileManipulationException ex) {
                Exceptions.printStackTrace(ex);
            }

            tc.setProject(project);
            tc.setDisplayName(project.getName());
            tc.setToolTipText("This is a " + project.getName() + " window");
            tc.setName(String.valueOf(Controller.getProjects().size()));
            project.setIndex(Controller.getProjects().size());
            tc.setTextureRendering(ButtonHelper.getTexturesMenuItem().isSelected());
            Controller.addProjcet(project);

            GUIController.getBlankProject(); // adds another "New Project" panel

            GUIController.setSelectedProjectTopComponent(tc);
        }
    }

    private void compositeCreationPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compositeCreationPanelMouseClicked
        createNewProject();
        ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        ButtonHelper.setCompositeEnabled(true);
        ButtonHelper.setViewerEnabled(true);
        //    ButtonHelper.setFeaturePointsEnabled(true);
        //   ButtonHelper.setAgeingEnabled(true);
        //   ButtonHelper.setComparisonEnabled(true);
        ButtonHelper.setTexturesEnabled(true);
        ButtonHelper.getTexturesMenuItem().setSelected(true);
        tc.getProject().addComposite(NbBundle.getMessage(Controller.class, "tree.node.composite"));
        //TODO chcek for existing compoites and name acordingly
        tc.getCompositePanel().setCompositeData(GUIController.getSelectedProjectTopComponent().getProject().getSelectedComposite());
        tc.getCompositePanel().selectTemplates();
        tc.getProject().setSelectedPart(1);

        tc.setTextureRendering(ButtonHelper.getTexturesMenuItem().isSelected());
        GUIController.getNavigatorTopComponent().update();
        GUIController.selectComposite();
        tc.requestActive();
    }//GEN-LAST:event_compositeCreationPanelMouseClicked

    private void compare2facesPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compare2facesPanelMouseClicked
        createNewProject();
        ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        ButtonHelper.setTexturesEnabled(true);
        tc.getProject().add2FacesComparison(NbBundle.getMessage(Controller.class, "tree.node.twoFacesComparison"));
        tc.getProject().setSelectedPart(2);
        GUIController.select2FacesViewer();
        GUIController.getNavigatorTopComponent().update();
        tc.requestActive();
    }//GEN-LAST:event_compare2facesPanelMouseClicked

    private void batchComparisonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batchComparisonPanelMouseClicked
        createNewProject();
        ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        ButtonHelper.setTexturesEnabled(true);
        tc.getProject().addBatchComparison(NbBundle.getMessage(Controller.class, "tree.node.batchComparison"));
        tc.getProject().setSelectedPart(4);
        GUIController.selectBatchViewer();
        GUIController.getNavigatorTopComponent().update();
        tc.requestActive();
    }//GEN-LAST:event_batchComparisonPanelMouseClicked

    private void oneToManyComparisonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneToManyComparisonPanelMouseClicked
        createNewProject();
        ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        ButtonHelper.setTexturesEnabled(true);
        tc.getProject().addOneToManyComparison(NbBundle.getMessage(Controller.class, "tree.node.oneToMany"));
        tc.getProject().setSelectedPart(3);
        GUIController.selectOneToManyViewer();
        GUIController.getNavigatorTopComponent().update();
        tc.requestActive();
    }//GEN-LAST:event_oneToManyComparisonPanelMouseClicked

    private void compositeCreationPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compositeCreationPanelMouseExited
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/composite.png")));
    }//GEN-LAST:event_compositeCreationPanelMouseExited

    private void compare2facesPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compare2facesPanelMouseExited
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/2faces.png")));
    }//GEN-LAST:event_compare2facesPanelMouseExited

    private void oneToManyComparisonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneToManyComparisonPanelMouseExited
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/database.png")));
    }//GEN-LAST:event_oneToManyComparisonPanelMouseExited

    private void batchComparisonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batchComparisonPanelMouseExited
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/fidentis/gui/resources/batch.png")));
    }//GEN-LAST:event_batchComparisonPanelMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel batchComparisonPanel;
    private javax.swing.JPanel compare2facesPanel;
    private javax.swing.JPanel compositeCreationPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel oneToManyComparisonPanel;
    // End of variables declaration//GEN-END:variables
}
