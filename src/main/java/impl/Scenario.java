package impl;

import java.util.ArrayList;

public class Scenario {

	protected String Dataaddress;
	protected int[] categoricalAttributeIndex;
	protected int[] conditionsIndex;
	protected int[] conclusionsIndex;
	// double[] should be filled as algorithm index, minConf, minSupp
	protected double[] algorithmParameters;
	protected ArrayList listOfRules;

	public Scenario(String Dataaddress, int[] categoricalAttributeIndex, int[] conditionsIndex, int[] conclusionsIndex, double[] algorithmParameters) {
		this.Dataaddress = Dataaddress;
		this.categoricalAttributeIndex = categoricalAttributeIndex;
		this.conditionsIndex = conditionsIndex;
		this.conclusionsIndex = conclusionsIndex;
		this.algorithmParameters = algorithmParameters;

	}

	public String getDataaddress() {
		return Dataaddress;
	}

	public void setDataaddress(String dataaddress) {
		Dataaddress = dataaddress;
	}

	public int[] getCategoricalAttributeIndex() {
		return categoricalAttributeIndex;
	}

	public void setCategoricalAttributeIndex(int[] categoricalAttributeIndex) {
		this.categoricalAttributeIndex = categoricalAttributeIndex;
	}

	public int[] getConditionsIndex() {
		return conditionsIndex;
	}

	public void setConditionsIndex(int[] conditionsIndex) {
		this.conditionsIndex = conditionsIndex;
	}

	public int[] getConclusionsIndex() {
		return conclusionsIndex;
	}

	public void setConclusionsIndex(int[] conclusionsIndex) {
		this.conclusionsIndex = conclusionsIndex;
	}

	public double[] getAlgorithmParameters() {
		return algorithmParameters;
	}

	public void setAlgorithmParameters(double[] algorithmParameters) {
		this.algorithmParameters = algorithmParameters;
	}

}
