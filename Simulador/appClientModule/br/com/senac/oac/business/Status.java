package br.com.senac.oac.business;

import br.com.senac.oac.bean.Registrador;

/**
 * Print status all system ALU
 */
public class Status {
	
	private static int nIntrucoesExe = 0;
	
	private static void addNIntrucaoExe(){
		nIntrucoesExe++;
	}
	private static int getNIntrucoesExe(){
		return nIntrucoesExe;
	}
	
	private static double porcentagemNIntrucoes(){
		double r = (double) (getNIntrucoesExe()*100.00)/13.00; 
		return r;
	}
	
	public static void printStatusInit(ALU alu){
		
		System.out.print("/*====================================STATUS====================================*/\n\n");
		
		
		System.out.println("Conteúdo da memória...");
		for(String s : alu.getMemPrincipal().getMemPrincipal())
			System.out.printf("%s\n", s);
		
		System.out.println("Registradores...");
		for(Registrador r : alu.getMemRegister().getListRegistrador())
			System.out.printf("%s\t%s\t%s\n", 
					(r.getRepresentacao() == null) ? " " : r.getRepresentacao(), 
					r.getRegistrador(),
					r.getValor());
		
	}
	
	
	public static void printStatus(ALU alu){
		printStatusInit(alu);
		addNIntrucaoExe();
	}
	
	public static void printStatusFinal(ALU alu){
		printStatusInit(alu);
		System.out.printf("\nO total de instruções executadas é %d.", getNIntrucoesExe());
		System.out.printf("\n%.2f%% de instruções foram executadas!\n", porcentagemNIntrucoes());
	}
	

}
