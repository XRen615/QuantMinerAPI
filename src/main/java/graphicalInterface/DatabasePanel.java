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
import java.awt.*;


public class DatabasePanel extends javax.swing.JPanel {
    
    /** Creates new form PanneauBase */
    public DatabasePanel() {
    }

    // Initialise le panneau de base � partir d'un autre panneau (le panneau fils) :
    public void initBaseComponents() {
        
        // Initialisation standard des composants :
        initComponents();
          
    }    
    
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        setLayout(null);

    }//GEN-END:initComponents
    
    
    
    // Redispose certains champs en fonction de la taille du panneau :
    void ArrangerDisposition() {
    }

    
    // M�thode � outrepasser dans la classe fille pour fermer proprement le panneau en cas d'annulation d'un processus :
    // Renvoie vrai si on peut effectivement fermer le panneau, faux sinon.
    public boolean AnnulerPanneau() {
        return true;
    }
    
   
   
    // M�thode � outrepasser dans la classe fille pour provoquer la validation (m�morisation, analyse, ...)
    // des informations entr�es dans les champs du panneau (sym�trique de la m�thode pr�c�dente) :
    public boolean SychroniserDonneesInternesSelonAffichage() {
        return true;
    }

        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
