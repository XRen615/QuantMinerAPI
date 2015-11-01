package impl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Configurations of scenario
		String Dataaddress = "/Users/xinyuyangren/Desktop/Week41-44/KatineTemp.csv";
		int[] categoricalAttributeIndex={};
		int[] conditionsIndex={};
		int[] conclusionsIndex={};
		// double[] should be filled as algorithm index, minConf, minSupp
		double[] algorithmParameters = {2, 0.9,0.2};
		
		Scenario KatineTemp = new Scenario (Dataaddress,categoricalAttributeIndex,conditionsIndex,conclusionsIndex,algorithmParameters);
		
		//initialization miner
		Wrapper miner = new Wrapper();
		
		
		//scenario analysis start
		miner.startScenario(KatineTemp);
		
		//tester of the encapsulated rule
		System.out.println("Tester here");
		Object rule1 = KatineTemp.listOfRules.get(1);
		System.out.println(rule1);
		//end
	}
		
}
