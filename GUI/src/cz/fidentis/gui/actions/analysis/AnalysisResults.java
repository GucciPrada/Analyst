/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.gui.actions.analysis;

import cz.fidentis.featurepoints.FacialPoint;
import cz.fidentis.featurepoints.FpModel;
import cz.fidentis.featurepoints.landmarks.FPAnalysisMethods;
import cz.fidentis.featurepoints.TableData;
import cz.fidentis.utils.LandmarkUtils;
import cz.fidentis.utils.MathUtils;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.openide.windows.TopComponent;

/**
 *
 * @author rastoStefanko
 */
public final class AnalysisResults extends TopComponent {

    private List<FpModel> selectedFiles;
    private List<FpModel> selectedFilesSecond;
    private Map<String, List<Double>> computeResults = new HashMap<>();
    private static final int DISSMIS_WAIT_TIME = 99999999;

    public AnalysisResults(List<FpModel> inSelFiles, List<FpModel> inSelFilesOthers, FPAnalysisMethods method) {
        this.selectedFiles = inSelFiles;
        this.selectedFilesSecond = inSelFilesOthers;
        initComponents();
        notMatchTextArea.setEditable(false);
        computeResults = LandmarkUtils.computeFp(method, selectedFiles, selectedFilesSecond);
        notMatchTextArea.setText(LandmarkUtils.getNotIn());
        fillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notMatchTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        boxPlotButton = new javax.swing.JButton();
        unpairedLabel = new java.awt.Label();

        notMatchTextArea.setColumns(20);
        notMatchTextArea.setRows(5);
        jScrollPane1.setViewportView(notMatchTextArea);

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(resultTable);

        org.openide.awt.Mnemonics.setLocalizedText(boxPlotButton, org.openide.util.NbBundle.getMessage(AnalysisResults.class, "AnalysisResults.boxPlotButton.text")); // NOI18N
        boxPlotButton.setActionCommand(org.openide.util.NbBundle.getMessage(AnalysisResults.class, "AnalysisResults.boxPlotButton.actionCommand")); // NOI18N
        boxPlotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPlotButtonActionPerformed(evt);
            }
        });

        unpairedLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        unpairedLabel.setText(org.openide.util.NbBundle.getMessage(AnalysisResults.class, "AnalysisResults.unpairedLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(unpairedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boxPlotButton)
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(boxPlotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(unpairedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxPlotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPlotButtonActionPerformed
        // TODO add your handling code here:

        final BoxAndWhiskerCategoryDataset dataset = createSampleDataset();
        
        final JFreeChart chart = ChartFactory.createBoxAndWhiskerChart("Box and Whisker Chart ", " Type", " Value", dataset, true);
        
        ChartPanel panel = new ChartPanel(chart);
        panel.setDisplayToolTips(true);
        panel.setDismissDelay(DISSMIS_WAIT_TIME);
        
        JPanel jPanel4 = new JPanel(new BorderLayout());
        
        jPanel4.add(panel);
        JFrame frame = new JFrame();
        frame.add(jPanel4);
        frame.pack();
        frame.setVisible(true);

    }//GEN-LAST:event_boxPlotButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boxPlotButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea notMatchTextArea;
    private javax.swing.JTable resultTable;
    private java.awt.Label unpairedLabel;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    /**
     * Set data to window table
     */
    protected void fillTable() {
        String[] columnNames = new String[computeResults.size() + 1];

        String[][] data = new String[selectedFiles.get(0).getFacialPoints().size()][computeResults.size() + 1];

        int tmp = 1;
        columnNames[0] = "Landmark";

        for (int i = 0; i < selectedFiles.get(0).getFacialPoints().size(); i++) {
            data[i][0] = "" + i;
        }

        for (String key : computeResults.keySet()) {
            columnNames[tmp] = key;

            for (int j = 0; j < computeResults.get(key).size(); j++) {
                data[j][tmp] = computeResults.get(key).get(j).toString();
            }

            tmp++;
        }

        TableData values = new TableData(columnNames, data);
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
                values.getTableData(),
                values.getHeader()
        ));
    }
    
    public void resultsAdd(String str, List<Double> listDo){
        computeResults.put(str, listDo);
    }

    private BoxAndWhiskerCategoryDataset createSampleDataset() {

        final DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();

        double[][] data = new double[selectedFiles.get(0).getFacialPoints().size()][computeResults.size()];

        int tmp = 0;

        for (String key : computeResults.keySet()) {

            for (int j = 0; j < computeResults.get(key).size(); j++) {
                data[j][tmp] = computeResults.get(key).get(j);
            }

            tmp++;
        }
        for (int j = 0; j < data.length; j++) {
            final List list = new ArrayList();
            // add some values...
            for (int k = 0; k < data[j].length; k++) {
                final double value1 = data[j][k];
                list.add(value1);
            }
            dataset.add(list, "Landmark", j);
        }

        return dataset;
    }
}
