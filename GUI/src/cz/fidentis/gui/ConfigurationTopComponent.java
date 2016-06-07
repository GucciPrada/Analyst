/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.gui;


import cz.fidentis.gui.ageing.AgeingConfiguration;
import cz.fidentis.gui.comparison_batch.BatchComparisonConfiguration;
import cz.fidentis.gui.comparison_batch.BatchComparisonResults;
import cz.fidentis.gui.comparison_batch.BatchRegistrationConfiguration;
import cz.fidentis.gui.comparison_one_to_many.OneToManyComparisonConfiguration;
import cz.fidentis.gui.comparison_one_to_many.OneToManyComparisonResults;
import cz.fidentis.gui.comparison_one_to_many.OneToManyRegistrationConfiguration;
import cz.fidentis.gui.comparison_two_faces.PairComparisonConfiguration;
import cz.fidentis.gui.comparison_two_faces.PairComparisonResults;
import cz.fidentis.gui.comparison_two_faces.PairRegistrationConfiguration;
import cz.fidentis.gui.composite.CompositeConfiguration;
import cz.fidentis.gui.featurepoints.FeaturePointsConfiguration;
import cz.fidentis.gui.viewer.ViewerConfiguration;
import javax.swing.JPanel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.StatusDisplayer;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//cz.fidentis.gui//Configuration//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "ConfigurationTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_NEVER)
@TopComponent.Registration(mode = "properties", openAtStartup = true)
@ActionID(category = "Window", id = "cz.fidentis.gui.ConfigurationTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ConfigurationAction",
        preferredID = "ConfigurationTopComponent")
@Messages({
    "CTL_ConfigurationAction=Configuration",
    "CTL_ConfigurationTopComponent=Configuration",
    "HINT_ConfigurationTopComponent=This is a Configuration window"
})
public final class ConfigurationTopComponent extends TopComponent {

    private AgeingConfiguration ageingConfig;
    private CompositeConfiguration compositeConfiguration;
    private PairComparisonConfiguration comparisonConfiguration;
    private FeaturePointsConfiguration featurePointsConfiguration;
    private ViewerConfiguration viewerConfiguration;
    private PairRegistrationConfiguration registrationConfiguration;
    private PairComparisonResults pairComparisonResults;
    private BatchRegistrationConfiguration batchRegistrationConfiguration;
    private BatchComparisonConfiguration batchComparisonConfiguration;
    private BatchComparisonResults batchComparisonResults;
    private OneToManyRegistrationConfiguration oneToManyRegistrationConfiguration;
    private OneToManyComparisonConfiguration oneToManyComparisonConfiguration;
    private OneToManyComparisonResults oneToManyComparisonResults;

    public ConfigurationTopComponent() {
        initComponents();
        
        /*ageingConfig = new AgeingConfiguration();
        registrationConfiguration = new PairRegistrationConfiguration();
        compositeConfiguration = new CompositeConfiguration();
        comparisonConfiguration = new PairComparisonConfiguration();
        featurePointsConfiguration = new FeaturePointsConfiguration();
        viewerConfiguration = new ViewerConfiguration();
        batchComparisonConfiguration = new BatchComparisonConfiguration();
        batchRegistrationConfiguration = new BatchRegistrationConfiguration();
        oneToManyRegistrationConfiguration = new OneToManyRegistrationConfiguration();
        oneToManyComparisonConfiguration = new OneToManyComparisonConfiguration();
        pairComparisonResults = new PairComparisonResults();
        oneToManyComparisonResults = new OneToManyComparisonResults();
        batchComparisonResults = new BatchComparisonResults();*/
//        FoldingPanel panel = new FoldingPanel();
//        panel.addPanel("Registration Configuration", registrationConfiguration);
//        panel.addPanel("Comparison", oneToManyComparisonConfiguration);
//        this.add(panel);
//        this.repaint();
//        this.revalidate();
        
        setName(Bundle.CTL_ConfigurationTopComponent());
        setToolTipText(Bundle.HINT_ConfigurationTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_SLIDING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_KEEP_PREFERRED_SIZE_WHEN_SLIDED_IN, Boolean.TRUE);
        
       // GUIController.openStartingScreen();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(1, 1));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
    
    public void addAgeingComponent() {
        this.removeAll();
        
        if(ageingConfig == null)
            ageingConfig = new AgeingConfiguration();
        
        this.add(ageingConfig);
        ageingConfig.setConfiguration();
        this.revalidate();
        this.repaint();
    }

    public void addBatchComparisonResults() {
        this.removeAll();
        
        if(batchComparisonResults == null)
            batchComparisonResults = new BatchComparisonResults();
        
        this.add(batchComparisonResults);
        batchComparisonResults.setConfiguration();
        this.revalidate();
        this.repaint();
      
    }

    public void addPairComparisonResults() {
        this.removeAll();
        
        if(pairComparisonResults == null)
            pairComparisonResults = new PairComparisonResults();
        
        this.add(pairComparisonResults);
        pairComparisonResults.setConfiguration();
        this.revalidate();
        this.repaint();
        
    }

    public void addOneToManyComparisonResults() {
        this.removeAll();
        
        if(oneToManyComparisonResults == null)
            oneToManyComparisonResults = new OneToManyComparisonResults();
       
        this.add(oneToManyComparisonResults);
        oneToManyComparisonResults.setConfiguration();
         this.revalidate();
        this.repaint();
       
    }


    public void addComparisonComponent() {
        this.removeAll();
        
        if(comparisonConfiguration == null)
            comparisonConfiguration = new PairComparisonConfiguration();
        
        this.add(comparisonConfiguration);
        comparisonConfiguration.setConfiguration();
        this.repaint();
        this.revalidate();
    }

    public void addBatchComparisonComponent() {
        this.removeAll();
        
        if(batchComparisonConfiguration == null)
            batchComparisonConfiguration = new BatchComparisonConfiguration();
        
        this.add(batchComparisonConfiguration);
        batchComparisonConfiguration.setConfiguration();
        this.revalidate();
        this.repaint();
      
    }

    public void addOneToManyComparisonComponent() {
        this.removeAll();
        
        if(oneToManyComparisonConfiguration == null)
            oneToManyComparisonConfiguration = new OneToManyComparisonConfiguration();
        
        this.add(oneToManyComparisonConfiguration);
        oneToManyComparisonConfiguration.setConfiguration();
        this.repaint();
        this.revalidate();
    }

    public void addCompositeComponent() {
        this.removeAll();
        
        if(compositeConfiguration == null)
            compositeConfiguration = new CompositeConfiguration();
        
        this.add(compositeConfiguration);
        this.repaint();
        this.revalidate();
    }

    public void addFeaturePointsComponent() {
        this.removeAll();
        
        if(featurePointsConfiguration == null)
            featurePointsConfiguration = new FeaturePointsConfiguration();
        
        this.add(featurePointsConfiguration);
        this.repaint();
        this.revalidate();

    }

    public void addViewerComponent() {
        this.removeAll();
        
        if(viewerConfiguration == null)
            viewerConfiguration = new ViewerConfiguration();
        
        this.add(viewerConfiguration);
        this.repaint();
        this.revalidate();

    }

    public void addRegistrationComponent() {
        this.removeAll();
        
        if(registrationConfiguration == null)
            registrationConfiguration = new PairRegistrationConfiguration();
        
        this.add(registrationConfiguration);
        registrationConfiguration.setConfiguration();
        this.repaint();
        this.revalidate();

    }

    public void addBatchRegistrationComponent() {
        this.removeAll();
        
        if(batchRegistrationConfiguration == null)
            batchRegistrationConfiguration = new BatchRegistrationConfiguration();
        
        this.add(batchRegistrationConfiguration);
        batchRegistrationConfiguration.setConfiguration();
        this.repaint();
        this.revalidate();

    }

    public void addOneToManyRegistrationComponent() {
        this.removeAll();
        
        if(oneToManyRegistrationConfiguration == null)
            oneToManyRegistrationConfiguration = new OneToManyRegistrationConfiguration();
        
        this.add(oneToManyRegistrationConfiguration);
        oneToManyRegistrationConfiguration.setConfiguration();
        this.repaint();
        this.revalidate();

    }
    
    public AgeingConfiguration getAgeingConfiguration() {
        return ageingConfig;
    }
    
    public PairRegistrationConfiguration getRegistrationConfiguration() {
        return registrationConfiguration;
    }

    public BatchRegistrationConfiguration getBatchRegistrationConfiguration() {
        return batchRegistrationConfiguration;
    }

    public BatchComparisonResults getBatchComparisonResults() {
        return batchComparisonResults;
    }

    public PairComparisonResults getPairComparisonResults() {
        return pairComparisonResults;
    }

    public OneToManyComparisonResults getOneToManyComparisonResults() {
        return oneToManyComparisonResults;
    }

    public CompositeConfiguration getCompositConfigurationPanel() {
        return compositeConfiguration;
    }

    public PairComparisonConfiguration getPairComparisonConfiguration() {
        return comparisonConfiguration;
    }

    public BatchComparisonConfiguration getBatchComparisonConfiguration() {
        return batchComparisonConfiguration;
    }

    public OneToManyComparisonConfiguration getOneToManyComparisonConfiguration() {
        return oneToManyComparisonConfiguration;
    }

    public OneToManyRegistrationConfiguration getOneToManyRegistrationConfiguration() {
        return oneToManyRegistrationConfiguration;
    }

    public void clear() {
        this.removeAll();
        this.repaint();
        this.revalidate();

    }
}
