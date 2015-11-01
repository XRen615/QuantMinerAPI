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

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import java.awt.*;
import javax.swing.event.*;

import  tools.*;

import java.net.URL;



public class DialogHelp extends javax.swing.JDialog implements HyperlinkListener { //helper
    
    private String m_sPageCourante = null;
    
    
    /** Creates new form DialogFenetreAide */
    public DialogHelp(String sFichierAide, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setResizable(false);
        setLocationRelativeTo(null);
        
        jEditorPaneHTML.addHyperlinkListener(this);
        
        m_sPageCourante = "file:///" + sFichierAide;
        ChargerPageActive();
    }
    
    
    
    private void ChargerPageActive() {
        if (m_sPageCourante == null)
            return;
        
        try {
            jEditorPaneHTML.setPage( new URL(m_sPageCourante) );
        }
        catch (Exception e) {
            System.out.println(e);
        } 
    }
    
    
    
    public void hyperlinkUpdate(HyperlinkEvent event) {
        HTMLDocument documentHTML  = null;
        
        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
        {
            m_sPageCourante = event.getURL().toString();
            
            if (event instanceof HTMLFrameHyperlinkEvent) {
                documentHTML = (HTMLDocument)jEditorPaneHTML.getDocument();
                documentHTML.processHTMLFrameHyperlinkEvent( (HTMLFrameHyperlinkEvent)event );
            }
            else 
                ChargerPageActive();
        }
    }
    
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneHTML = new javax.swing.JScrollPane();
        jEditorPaneHTML = new javax.swing.JEditorPane();
        jButtonFermer = new javax.swing.JButton();
        jButtonHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QuantMiner Help Contents");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

  
        jPanel1.setLayout(null);
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 600));
        jScrollPaneHTML.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jEditorPaneHTML.setEditable(false);
        jEditorPaneHTML.setContentType("text/html");
        jScrollPaneHTML.setViewportView(jEditorPaneHTML);

        jPanel1.add(jScrollPaneHTML);
        jScrollPaneHTML.setBounds(10, 30, 1280, 520);

        jButtonFermer.setText("Close");
        jButtonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFermerActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonFermer);
        jButtonFermer.setBounds(600, 560, 70, 30);

        jButtonHome.setText("Back to the main page");
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonHome);
        jButtonHome.setBounds(11, 6, 200, 20);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        m_sPageCourante = "file:///" + ENV.REPERTOIRE_AIDE + "index.htm";
        ChargerPageActive();
    }//GEN-LAST:event_jButtonHomeActionPerformed

    
    
    private void jButtonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFermerActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonFermerActionPerformed
    
    
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("deprecation")
	public static void main(String args[]) {
        new DialogHelp(null, new javax.swing.JFrame(), true).show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFermer;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JEditorPane jEditorPaneHTML;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneHTML;
    // End of variables declaration//GEN-END:variables
    
}
