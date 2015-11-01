package impl;

import database.DatabaseAdmin;
import graphicalInterface.PanelGenetic;
import solver.ResolutionContext;

public class ProfileLoaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Load data from csv File to ResolutionContext class
		String Dataaddress = "/Users/xinyuyangren/Desktop/Week41/KatineTemp.csv";
		String profileAddress = "/Users/xinyuyangren/Desktop/Week41/Katine.prf";
		
		DatabaseAdmin loaderofcsv = new DatabaseAdmin(Dataaddress, "csv");
		
		ResolutionContext m_contexteResolution = new ResolutionContext(null);//manager
		
		m_contexteResolution.m_gestionnaireBD = loaderofcsv;//load the csv file
		m_contexteResolution.ChargerProfil(profileAddress);//load the config file
		
		//generate assistant, which contains a start button (panel 4)
		PanelGenetic assistant = new PanelGenetic(m_contexteResolution);

		// ***************** Display Database File Info **********************************

		// Name and Capacity of the file
		String sInfosBase = "Database " + loaderofcsv.ObtenirNomBaseDeDonnees();
		sInfosBase += ",   " + String.valueOf(loaderofcsv.ObtenirNombreLignes()) + " records.";
		System.out.println(sInfosBase);

		//// get the number of columns
		int iNombreColonnes = m_contexteResolution.m_gestionnaireBD.ObtenirNombreColonnesBDInitiale();

		// name of every attributes
		for (int iIndiceColonne = 0; iIndiceColonne < iNombreColonnes; iIndiceColonne++) {

			String sNomColonne = m_contexteResolution.m_gestionnaireBD.ObtenirNomColonneBDInitiale(iIndiceColonne);
			String sNomColonneDispaly = sNomColonne+ " Type: " + m_contexteResolution.m_gestionnaireBD.ObtenirTypeColonne(sNomColonne);

			System.out.println(sNomColonneDispaly);
		}

		// ******************** Start Mining Rules, print parameter info and results*******************************
		
		
		
		
		m_contexteResolution.m_parametresReglesQuantitatives.m_fMinConf =(float) (0.7);
		assistant.startCalculation();
		
	}
}
