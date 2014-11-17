package br.com.senac.oac.business;

public class Convert {
	
	
	public static String toBinary(String line){
		long decimal = 0;
		
		//convert decimal
		decimal = Long.parseLong(line, 16);
		//convert binary
		return Long.toString(decimal, 2);
	}
	
	
	public static String toDecimal(String line){
		long decimal = Long.parseLong(line, 16);
		return Long.toString(decimal);
	}

	

}
