package br.com.senac.oac.business;

public class Convert {
	
	
	public static String toHexBinary(String line){
		long decimal = 0;
		
		//convert decimal
		decimal = Long.parseLong(line, 16);
		
		String v = Long.toBinaryString(decimal);
		String aux = "";
		for(int i = 0; i < 32; i++){
			if( (aux.length() + v.length()) < 32 )
				aux += "0";
		}
		
		return (aux += v);
	}
	
	
	public static String toHexDecimal(String line){
		long decimal = Long.parseLong(line, 16);
		return Long.toString(decimal);
	}
	
	public static int toBinaryDecimal(String s){
		long decimal = Long.parseLong(s, 2);
		return Integer.valueOf(Long.toString(decimal));
	}
	
	public static String toDecimalBinary(int i){
		String v = Long.toString(i, 2);
		String aux = "";
		for(int j = 0; j < 5; j++){
			if( (aux.length() + v.length()) < 5 )
				aux += "0";
		}
		return (aux += v);
	}

	

}
