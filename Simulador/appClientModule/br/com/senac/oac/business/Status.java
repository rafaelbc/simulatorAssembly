package br.com.senac.oac.business;


import br.com.senac.oac.bean.Registrador;

/**
 * Print status all system ALU
 */
public class Status {
	
	private static int nIntrucoesExe = 0;
	private static int[] pInstrucaoExe = {0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	private static void addNIntrucaoExe(){
		nIntrucoesExe++;
	}
	private static int getNIntrucoesExe(){
		return nIntrucoesExe;
	}
	
	private static double porcentagemNIntrucoes(int pos){
		double r = (double) ( ( getpInstrucaoExe(pos) * 100.00) / getNIntrucoesExe() );
		return r;
	}
	
	public static int getpInstrucaoExe(int pos) {
		return pInstrucaoExe[pos];
	}
	public static void setpInstrucaoExe(int pos) {
		pInstrucaoExe[pos]++;
	}
	
	@SuppressWarnings("static-access")
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
		
		System.out.printf("\nInstrução | Procentagem de execução\n");
		System.out.printf("\nadd\t->\t%.2f%%\n", porcentagemNIntrucoes(0));
		System.out.printf("sub\t->\t%.2f%%\n", porcentagemNIntrucoes(1));
		System.out.printf("slt\t->\t%.2f%%\n", porcentagemNIntrucoes(2));
		System.out.printf("jr\t->\t%.2f%%\n", porcentagemNIntrucoes(3));
		System.out.printf("addi\t->\t%.2f%%\n", porcentagemNIntrucoes(4));
		System.out.printf("slti\t->\t%.2f%%\n", porcentagemNIntrucoes(5));
		System.out.printf("lw\t->\t%.2f%%\n", porcentagemNIntrucoes(6));
		System.out.printf("sw\t->\t%.2f%%\n", porcentagemNIntrucoes(7));
		System.out.printf("beq\t->\t%.2f%%\n", porcentagemNIntrucoes(8));
		System.out.printf("bne\t->\t%.2f%%\n", porcentagemNIntrucoes(9));
		System.out.printf("j\t->\t%.2f%%\n", porcentagemNIntrucoes(10));
		System.out.printf("jal\t->\t%.2f%%\n", porcentagemNIntrucoes(11));
		System.out.printf("hlt\t->\t%.2f%%\n", porcentagemNIntrucoes(12));
		
			
	}
	

}
