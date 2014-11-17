package br.com.senac.oac.business;
/**
 * Print status all system ALU
 */
public class Status {
	
	/**
	 * @code public static void printStatus(ALU alu){}
	 * @param alu
	 * Imprimir status geral do sistema
	 */
	public static void printStatus(ALU alu){
		
		System.out.println("/*====================================STATUS====================================*/ ");
		System.out.println();
		for(int i = 0; i < alu.getMemPrincipal().getPilha().length; i++){
			System.out.printf("Tamanho da pilha (Bytes) %d \n", alu.getMemPrincipal().getPilha().length);
//			for(int d : alu.getMemPrincipal().getPilha())
//				System.out.printf("%d \t", d);
		}
		System.out.printf(" $A0 -> %d", alu.get$a0());
		System.out.printf(" $A1 -> %d",alu.get$a1());
		System.out.printf(" $A2 -> %d",alu.get$a2());
		System.out.printf(" $A3 -> %d",alu.get$a3());
		System.out.printf(" $FP -> %d",alu.get$fp());
		System.out.printf(" $GP -> %d",alu.get$gp());
		System.out.printf(" $RA -> %d",alu.get$ra());
		
		
		
		
		System.out.println("/*==================================FIM STATUS==================================*/ ");
	}
	
	

}
