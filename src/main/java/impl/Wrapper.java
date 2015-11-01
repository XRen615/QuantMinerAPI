package impl;

import java.util.*;

import database.DataColumn;
import database.DatabaseAdmin;
import graphicalInterface.PanelGenetic;
import solver.ResolutionContext;
import graphicalInterface.PanelTechnConfig;

public class Wrapper {

	String DataAddress;
	ResolutionContext m_contexteResolution = new ResolutionContext(null);// manager
	PanelTechnConfig tech = new PanelTechnConfig(m_contexteResolution);//Algorithm Selector

	PanelGenetic assistant = new PanelGenetic(m_contexteResolution);
	
	//Load the address of data file
	public void setDataAddress(String dataaddress) {
		this.DataAddress = dataaddress;
		System.out.println("***********************************************");
		System.out.println("File Address load suscessful: " + this.DataAddress);
	}
	
	
	public String getDataaddress() {
		return this.DataAddress;
	}


	//Load the .csv file according to the address.
	public void loadfile() {

		DatabaseAdmin loaderofcsv = new DatabaseAdmin(this.DataAddress, "csv");

		this.m_contexteResolution.m_gestionnaireBD = loaderofcsv; // load the csv file
																

		//this.m_contexteResolution.m_gestionnaireBD.PrendreEnCompteToutesLesColonnes();

		// print database statistics
		System.out.println("***********************************************");
		String sInfosBase = "Database Information: " + loaderofcsv.ObtenirNomBaseDeDonnees();
		sInfosBase += ",   " + String.valueOf(loaderofcsv.ObtenirNombreLignes()) + " records.";
		System.out.println(sInfosBase);
		System.out.println("***********************************************");
	}
	
	//overload for scenario methodology use
	public void loadfile(String DataAddress) {

		DatabaseAdmin loaderofcsv = new DatabaseAdmin(DataAddress, "csv");

		this.m_contexteResolution.m_gestionnaireBD = loaderofcsv; // load the csv file
																

		//this.m_contexteResolution.m_gestionnaireBD.PrendreEnCompteToutesLesColonnes();

		// print database statistics
		System.out.println("***********************************************");
		String sInfosBase = "Database Information: " + loaderofcsv.ObtenirNomBaseDeDonnees();
		sInfosBase += ",   " + String.valueOf(loaderofcsv.ObtenirNombreLignes()) + " records.";
		System.out.println(sInfosBase);
		System.out.println("***********************************************");
	};
	

	// Type of the attributes **** Panel 1 *****
	//Default to be numerical (2), but set the index contained in the array to be categorical
	public void setCategorical (int[] cat){
		
		//***convert array to arraylist in order to use .contains method ***
		
		ArrayList<Integer> cate = new ArrayList<Integer>();
		
		for (int i = 0; i < cat.length; i++){
			cate.add(cat[i]);
		}
		
		//*** Loop Start ***

		int iNombreColonnes = m_contexteResolution.m_gestionnaireBD.ObtenirNombreColonnesBDInitiale(); 
		
		for (int iIndiceColonne = 0; iIndiceColonne < iNombreColonnes; iIndiceColonne++) {

			String sNomColonne = this.m_contexteResolution.m_gestionnaireBD.ObtenirNomColonneBDInitiale(iIndiceColonne);

			// setter of data type (1 for categorical, 2 for numerical) and consider or not
			
			if (cate.contains(iIndiceColonne )){
				
				this.m_contexteResolution.m_gestionnaireBD.DefinirPriseEnCompteColonne(sNomColonne, 1, true);
				
			}else{
				
				this.m_contexteResolution.m_gestionnaireBD.DefinirPriseEnCompteColonne(sNomColonne, 2, true);
			}
			
			// print the name and type
			String nameOfAttributesDispaly = sNomColonne + " Type: " + this.m_contexteResolution.m_gestionnaireBD.ObtenirTypeColonne(sNomColonne);

			System.out.println(nameOfAttributesDispaly);
		}
		System.out.println("***********************************************");
		System.out.println("Attributes Listed. In total: " + iNombreColonnes);
		System.out.println("***********************************************");
		this.m_contexteResolution.m_gestionnaireBD.ChargerDonneesPrisesEnCompte();
		this.m_contexteResolution.GenererStructuresDonneesSelonBDPriseEnCompte();
	}
	
	// set position - left or right **** Panel 2 ****
	// Default to be 4 (OK for both sides), but the causality could be specified by user also
	public void setCausality(int[] condition, int[] conclusion) {

		//***convert array to array list in order to use .contains method ***
		ArrayList<Integer> conditions = new ArrayList<Integer>();
		ArrayList<Integer> conclusions = new ArrayList<Integer>();
		
		for (int i = 0; i < condition.length; i++){
			conditions.add(condition[i]);
		}
		
		for (int i = 0; i < conclusion.length; i++){
			conclusions.add(condition[i]);
		}
		
		//*** Loop Start ***
		int iNombreColonnes = m_contexteResolution.m_gestionnaireBD.ObtenirNombreColonnesBDInitiale(); 
		
		for (int iIndiceAttribut = 0; iIndiceAttribut < iNombreColonnes; iIndiceAttribut++) {

			String sNomRow = m_contexteResolution.m_gestionnaireBD.ObtenirNomColonneBDInitiale(iIndiceAttribut);

			if (m_contexteResolution.m_gestionnaireBD.ObtenirTypeColonne(sNomRow) == 1) {

				//reading qualitative attribute
				DataColumn colonneDonnees = m_contexteResolution.m_gestionnaireBD.ObtenirColonneBDPriseEnCompte(iIndiceAttribut);
				String[] tItems = null;
				if (colonneDonnees != null) {
					String sNomAttribut = new String(colonneDonnees.m_sNomColonne);
					// Write in the profile if the column type is categorical
					if (m_contexteResolution.m_gestionnaireBD.ObtenirTypeColonne(sNomAttribut) == DatabaseAdmin.TYPE_VALEURS_COLONNE_ITEM) {
						tItems = colonneDonnees.ConstituerTableauValeurs();
					}

					int iNombreItems = tItems.length;
					for (int iIndiceItem = 0; iIndiceItem < iNombreItems; iIndiceItem++) {
						String sNomItem = tItems[iIndiceItem];
						if (conditions.contains(iIndiceAttribut)){
							m_contexteResolution.DefinirTypePrisEnCompteItem(sNomAttribut, sNomItem, 2);
							m_contexteResolution.DefinirPresenceObligatoireItem(sNomAttribut, sNomItem, false);
						}
						else if (conclusions.contains(iIndiceAttribut)){
							m_contexteResolution.DefinirTypePrisEnCompteItem(sNomAttribut, sNomItem, 3);
							m_contexteResolution.DefinirPresenceObligatoireItem(sNomAttribut, sNomItem, false);
						}
						else{
							m_contexteResolution.DefinirTypePrisEnCompteItem(sNomAttribut, sNomItem,4);
							m_contexteResolution.DefinirPresenceObligatoireItem(sNomAttribut, sNomItem, false);
						}
					}
				}
			}
			
			// reading quantitative attribute
			else {
				
				if (conditions.contains(iIndiceAttribut)){
					m_contexteResolution.DefinirTypePrisEnCompteAttribut(sNomRow, 2);
					m_contexteResolution.DefinirPresenceObligatoireAttribut(sNomRow, false);
				}
				else if (conclusions.contains(iIndiceAttribut)){
					m_contexteResolution.DefinirTypePrisEnCompteAttribut(sNomRow, 3);
					m_contexteResolution.DefinirPresenceObligatoireAttribut(sNomRow, false);
				}
				else{
					m_contexteResolution.DefinirTypePrisEnCompteAttribut(sNomRow, 4);
					m_contexteResolution.DefinirPresenceObligatoireAttribut(sNomRow, false);
				}
			}

		}
		System.out.println("Causality Setting Success");
		System.out.println("***********************************************");
		m_contexteResolution.MettreAJourDonneesInternesFiltre();
	}
	
	// Setter of rule parameters and algorithm parameters **** Panel 3 ****
	// double[] should be filled as algorithm index, minConf, minSupp
	public void setAlgorithm(double[] config) {
		
		// 0-undefined; 1-apriori; 2-Genetic; 3-SA; 4-user load rule file

		tech.ActiverPanneauAssistant((int)config[0]);

		this.m_contexteResolution.m_parametresReglesQuantitatives.m_fMinConf = (float) (config[1]);
		this.m_contexteResolution.m_parametresReglesQuantitatives.m_fMinSupp = (float) (config[2]);
		System.out.println("Tech Panel Setting Success ");
		System.out.println("***********************************************");

	}

	// start to calculate it **** Panel 4 ****
	public void startMining() {
		// generate assistant, which contains a start button (panel 4)
		
		System.out.println("Mining Started...");
		System.out.println("***********************************************");
		assistant.startCalculation();
		

	}
	
	//analyze encapsulated scenario
	public void startScenario(Scenario S){
		setDataAddress(S.getDataaddress());
		loadfile(S.getDataaddress());
		setCategorical (S.getCategoricalAttributeIndex());
		setCausality(S.getConditionsIndex(), S.getConclusionsIndex());
		setAlgorithm(S.getAlgorithmParameters());
		startMining();
		//save the results into the scenario
		S.listOfRules = assistant.getRules();
		
	}
}
	