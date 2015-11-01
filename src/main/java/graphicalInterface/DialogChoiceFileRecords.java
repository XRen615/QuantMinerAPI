/*                                             
 *Copyright 2007, 2011 CCLS Columbia University (USA), LIFO University of Orl��ans (France), BRGM (France)
 *
 *Authors: Cyril Nortet, Xiangrong Kong, Ansaf Salleb-Aouissi, Christel Vrain, Daniel Cassard
 *
 *This file is part of QuantMiner.
 *
 *QuantMiner is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.
 *
 *QuantMiner is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License along with QuantMiner.  If not, see <http://www.gnu.org/licenses/>.
 */
package  graphicalInterface;

import java.awt.event.ActionEvent;

import  solver.*;
import  tools.*;




public class DialogChoiceFileRecords extends javax.swing.JDialog { //save result in a file
    
    public static final int TYPE_ENREGISTREMENT_ANNULER = -1;           //cancel
    public static final int TYPE_ENREGISTREMENT_BINAIRE = 0;            //save in quant miner file
    public static final int TYPE_ENREGISTREMENT_HTML_TEXTE = 1;         //save in html text
    public static final int TYPE_ENREGISTREMENT_HTML_GRAPHIQUE = 2;     //save in html graphic
    public static final int TYPE_ENREGISTREMENT_CSV = 3;                //save in csv file

    private ResolutionContext m_contexteResolution = null;
    
   
    
    public class DialogChoixEnregistrementFichier_Donnees {
        public int m_iTypeEnregistrement = 0;
        public String m_sNomUtilisateur = null;
        public String m_sDescriptionRegles = null;
        
        public DialogChoixEnregistrementFichier_Donnees() {
            m_iTypeEnregistrement = TYPE_ENREGISTREMENT_ANNULER;
            m_sNomUtilisateur = "";
            m_sDescriptionRegles = "";
        }
    }
    
    public DialogChoixEnregistrementFichier_Donnees m_donnees = null;
    
    
    
    /** Creates new form DialogChoixEnregistrementFichier */
    public DialogChoiceFileRecords(ResolutionContext contexteResolution, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        m_contexteResolution = contexteResolution;
        
        m_donnees = new DialogChoixEnregistrementFichier_Donnees();
        m_donnees.m_sNomUtilisateur = m_contexteResolution.m_sNomUtilisateur;
        m_donnees.m_sDescriptionRegles = m_contexteResolution.m_sDescriptionRegles;
            
        getContentPane().setSize(431, 203);
        
        validate();   
        
        jTextFieldAuteur.setText(m_donnees.m_sNomUtilisateur);
        jTextAreaDescription.setText(m_donnees.m_sDescriptionRegles);
        
        setLocationRelativeTo(null);
    }
    
    
    
    public DialogChoixEnregistrementFichier_Donnees LierStructureDonnees() {
        return m_donnees;
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanelGeneral = new javax.swing.JPanel();
        jButtonAnnuler = new javax.swing.JButton();                 //cancel
        
        jPanelInfos = new javax.swing.JPanel();                     //info panel
        jScrollPaneDescription = new javax.swing.JScrollPane();     //
        jTextAreaDescription = new javax.swing.JTextArea();        //rules description
        jTextFieldAuteur = new javax.swing.JTextField();           //Author 
        jLabelAuteur = new javax.swing.JLabel();                   //"Report author"
        jLabelDescriptif = new javax.swing.JLabel();               //"rules description"
        
        jPanelEnregistrement = new javax.swing.JPanel();
        jButtonHTMLTexte = new javax.swing.JButton();              //save as html text --button
        jButtonHTMLGraphique = new javax.swing.JButton();          //save as html graphic--button
        jButtonFormatQuantMiner = new javax.swing.JButton();       //save as qmr --button
        jButtonCsv = new javax.swing.JButton();                    //save as csv --button 
        jButtonAide = new javax.swing.JButton();                   //help button

        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Save a list of rules");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanelGeneral.setLayout(null);

        //the basic dialog size
        jPanelGeneral.setPreferredSize(new java.awt.Dimension(500, 570));
        jButtonAnnuler.setText("Cancel");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        //add cancel button
        jPanelGeneral.add(jButtonAnnuler);
        jButtonAnnuler.setBounds(190, 520, 130, 23);

        jPanelInfos.setLayout(null);

        jPanelInfos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information about the context of extraction of rules:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 12)));
        jScrollPaneDescription.setViewportView(jTextAreaDescription);

        jPanelInfos.add(jScrollPaneDescription);
        jScrollPaneDescription.setBounds(10, 100, 460, 140);

        jPanelInfos.add(jTextFieldAuteur);
        jTextFieldAuteur.setBounds(130, 40, 340, 19);

        jLabelAuteur.setText("Report author:");
        jPanelInfos.add(jLabelAuteur);
        jLabelAuteur.setBounds(10, 40, 120, 14);

        jLabelDescriptif.setText("Rules Description:");
        jPanelInfos.add(jLabelDescriptif);
        jLabelDescriptif.setBounds(10, 80, 250, 14);

        jPanelGeneral.add(jPanelInfos);
        jPanelInfos.setBounds(10, 40, 480, 250);
        jPanelInfos.getAccessibleContext().setAccessibleName("Information on the report:");

        jPanelEnregistrement.setLayout(null);

        jPanelEnregistrement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choice of the format for saving the rules:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 12)));
        
        //html button
        jButtonHTMLTexte.setText("HTML (text)");
        jButtonHTMLTexte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHTMLTexteActionPerformed(evt);
            }
        });

        jPanelEnregistrement.add(jButtonHTMLTexte);
        jButtonHTMLTexte.setBounds(50, 40, 390, 23);

        //html graphic button
        jButtonHTMLGraphique.setText("HTML (graphic)");
        jButtonHTMLGraphique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHTMLGraphiqueActionPerformed(evt);
            }
        });

        jPanelEnregistrement.add(jButtonHTMLGraphique);
        jButtonHTMLGraphique.setBounds(50, 70, 390, 23);

        //qmr button
        jButtonFormatQuantMiner.setText("QuantMiner File (to manipulate later in QuantMiner )");
        jButtonFormatQuantMiner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFormatQuantMinerActionPerformed(evt);
            }
        });

        jPanelEnregistrement.add(jButtonFormatQuantMiner);
        jButtonFormatQuantMiner.setBounds(50, 100, 390, 23);

        //csv button
        jButtonCsv.setText("CSV File");
        jButtonCsv.addActionListener(new java.awt.event.ActionListener(){
        	 public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButtonCsvActionPerformed(evt);
             }
         });
        
        jPanelEnregistrement.add(jButtonCsv);
        jButtonCsv.setBounds(50, 130, 390, 23);
        
        //add jPanelEnregistrement panel 
        jPanelGeneral.add(jPanelEnregistrement);
        jPanelEnregistrement.setBounds(10, 310, 480, 180);
        jPanelEnregistrement.getAccessibleContext().setAccessibleName("Saving format:");

        jButtonAide.setText("?");
        jButtonAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAideActionPerformed(evt);
            }
        });

        jPanelGeneral.add(jButtonAide);
        jButtonAide.setBounds(438, 12, 50, 23);

        getContentPane().add(jPanelGeneral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void jButtonCsvActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO Auto-generated method stub
    	m_donnees.m_iTypeEnregistrement = TYPE_ENREGISTREMENT_CSV;
    	m_donnees.m_sNomUtilisateur = jTextFieldAuteur.getText();
        m_donnees.m_sDescriptionRegles = jTextAreaDescription.getText();
        
        setVisible(false);
        dispose();
	}



	private void jButtonAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAideActionPerformed
        DialogHelp dialogAide = new DialogHelp(ENV.REPERTOIRE_AIDE+"format_regles.htm", null, true);
        dialogAide.show();
    }//GEN-LAST:event_jButtonAideActionPerformed

    
    
    
    private void jButtonHTMLGraphiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHTMLGraphiqueActionPerformed
        m_donnees.m_iTypeEnregistrement = TYPE_ENREGISTREMENT_HTML_GRAPHIQUE;
        m_donnees.m_sNomUtilisateur = jTextFieldAuteur.getText();
        m_donnees.m_sDescriptionRegles = jTextAreaDescription.getText();
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonHTMLGraphiqueActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        m_donnees.m_iTypeEnregistrement = TYPE_ENREGISTREMENT_ANNULER;
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonFormatQuantMinerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFormatQuantMinerActionPerformed
        m_donnees.m_iTypeEnregistrement = TYPE_ENREGISTREMENT_BINAIRE;
        m_donnees.m_sNomUtilisateur = jTextFieldAuteur.getText();
        m_donnees.m_sDescriptionRegles = jTextAreaDescription.getText();
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonFormatQuantMinerActionPerformed

    private void jButtonHTMLTexteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHTMLTexteActionPerformed
        m_donnees.m_iTypeEnregistrement = TYPE_ENREGISTREMENT_HTML_TEXTE;
        m_donnees.m_sNomUtilisateur = jTextFieldAuteur.getText();
        m_donnees.m_sDescriptionRegles = jTextAreaDescription.getText();
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonHTMLTexteActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        m_donnees.m_iTypeEnregistrement = TYPE_ENREGISTREMENT_ANNULER;
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("deprecation")
	public static void main(String args[]) {
        new DialogChoiceFileRecords(null, new javax.swing.JFrame(), true).show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAide;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonFormatQuantMiner;
    private javax.swing.JButton jButtonHTMLGraphique;
    private javax.swing.JButton jButtonHTMLTexte;
    private javax.swing.JButton jButtonCsv;
    
    private javax.swing.JLabel jLabelAuteur;
    private javax.swing.JLabel jLabelDescriptif;
    private javax.swing.JPanel jPanelEnregistrement;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JPanel jPanelInfos;
    private javax.swing.JScrollPane jScrollPaneDescription;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldAuteur;
    // End of variables declaration//GEN-END:variables
    
}
