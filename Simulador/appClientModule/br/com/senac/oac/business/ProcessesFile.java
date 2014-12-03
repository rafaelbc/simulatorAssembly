package br.com.senac.oac.business;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import br.com.senac.oac.bean.MemoriaPrincipal;
import br.com.senac.oac.bean.Registrador;
import br.com.senac.oac.dao.GenericDAO;
import br.com.senac.oac.dao.OpenFile;

/**
 * @deprecated Processa informação do arquivo
 */
public class ProcessesFile {
	//inject GenericDAO
	private GenericDAO genericDAO = new GenericDAO();
	
	/**
	 * @Code public void processaFile(){} 
	 * @return void
	 * @category Business
	 * @deprecated Processa informações do arquivo. 
	 */
	@SuppressWarnings("static-access")
	public void processaFile(File file){

		 List<String> list = genericDAO.readFile(file);
		 List<String> lineBinary = new ArrayList<String>();			 
		 
		 
		for(String line : list)
			lineBinary.add(Convert.toHexBinary(line));
		
		//Object ALU;
		//construct new pilha
		 ALU alu = new ALU();
		 //adiciona programmer na memória principal
		 for(int i = 3; i < lineBinary.size(); i++)
			 alu.getMemPrincipal().addMemPrincipal(lineBinary.get(i));
		 
		//finaly (lixo) 
		lineBinary = null;
		list = null;
		
		boolean next = true;
		while(next){
			int PC =  Convert.toBinaryDecimal(alu.getMemRegister().getListRegistrador().get(32).getValor());//get PC
			String line = alu.getMemPrincipal().getMemPrincipal().get(PC);//get instrução
			
			//print status
			Status.printStatusInit(alu);
			
			char tipo = tipoOp(line);
			switch (tipo) {
			case 'r':
				int funct = functionR(line);
				
				switch (funct) {
				case 1://add
					alu.add(identificaReg(get$RD(line)), 
							identificaReg(get$RS(line)), 
							identificaReg(get$RT(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(0);
					break;
				case 2://sub
					alu.sub(identificaReg(get$RD(line)), 
							identificaReg(get$RS(line)),
							identificaReg(get$RT(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(1);
					break;
				case 3://slt
					alu.slt(identificaReg(get$RD(line)),
							identificaReg(get$RS(line)),
							identificaReg(get$RT(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(2);
					break;
				case 4://jr
					alu.jr(identificaReg(get$RS(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(3);
					break;
				case 5://hlt
					next = !alu.hlt(true);
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(12);
					break;
				default:
					System.err.println("Tipo de função inválida.");
				}
			
				
				break;
			case 'i':
				int op = tipoOpI(line);
				
				switch (op) {
				case 1://addi
					alu.addi(identificaReg(get$RT(line)),
							identificaReg(get$RS(line)),
							Convert.toBinaryDecimal(getCONSTANTE(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(4);
					break;
				case 2://slti
					alu.slti(identificaReg(get$RT(line)),
							identificaReg(get$RT(line)),
							Convert.toBinaryDecimal(getCONSTANTE(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(5);
					break;
				case 3://lw
					alu.lw(identificaReg(get$RT(line)),
							identificaReg(get$RS(line)),
							Convert.toBinaryDecimal(getCONSTANTE(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(6);
					break;
				case 4://sw
					alu.sw(identificaReg(get$RS(line)),
							Convert.toBinaryDecimal(getCONSTANTE(line)),
							identificaReg(get$RT(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(7);
					break;
				case 5://beq
					alu.beq(identificaReg(get$RS(line)),
							identificaReg(get$RT(line)),
							Convert.toBinaryDecimal(getCONSTANTE(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(8);
					break;
				case 6://bne
					alu.bne(identificaReg(get$RS(line)),
							identificaReg(get$RT(line)),
							Convert.toBinaryDecimal(getCONSTANTE(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(9);
					break;
				default:
					System.err.println("Tipo de operação inválida.");
				}
				
				break;
			case 'j':
				int opJ = tipoOpJ(line);
				
				switch (opJ) {
				case 1://j
					alu.j(Convert.toBinaryDecimal(endereco(line)));
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(10);
					break;
				case 2://jal
					alu.jal();
					
					Status.printStatus(alu);
					Status.setpInstrucaoExe(11);
					break;
				default:
					System.err.println("Tipo de operação inválida.");
				}
				
				break;
			default:
				System.err.println("Tipo de operação inválida.");
				break;
			}
			
			if(PC ==  Convert.toBinaryDecimal(alu.getMemRegister().getListRegistrador().get(32).getValor())){
				alu.getMemRegister().getListRegistrador().get(32).setValor(Convert.toDecimalBinary(PC+1));
			}
			
		}
//		for(Registrador r : alu.getMemRegister().getListRegistrador()){
//			if(!r.getValor().isEmpty()){
//				System.out.println(r.getRegistrador());
//				System.out.println(r.getRepresentacao());
//				System.out.println( r.getValor());
//			}
//		}
//		
//		for(int i=0; i < alu.getMemPrincipal().getMemPrincipal().size(); i++){
//			System.out.println(alu.getMemPrincipal().getMemPrincipal().get(i));
//		}
		
		Status.printStatusFinal(alu);
	}
	/**
	 * Calcula endereço
	 * @Code private String endereco(String s){}
	 * @param s
	 * @return binaray value endereco
	 */
	private String endereco(String s){
		return s.substring(7, 32);
	}
	
	/**
	 * Identifica o registrador
	 * @Code private Registrador identificaReg(String repre){}
	 * @param repre
	 * @return Registrador
	 */
	private Registrador identificaReg(String repre){
		for(Registrador r : ALU.getMemRegister().getListRegistrador())
			if(r.getRepresentacao().equals(repre))
				return r;
		
		return null;
	}
	
	/**
	 * Identifica o registrador $RS
	 * @Code private String get$RS(String s){}
	 * @param s
	 * @return $RS
	 */
	private String get$RS(String s){
		return s.substring(6, 11);//get $RS
	}
	
	/**
	 * Identifica o registrador $RT
	 * @Code private String get$RT(String s){}
	 * @param s
	 * @return $RT
	 */
	private String get$RT(String s){
		return s.substring(11, 16);
	}
	
	/**
	 * Identifica o registrador $RD
	 * @Code private String get$RD(String s){}
	 * @param s
	 * @return $RD
	 */
	private String get$RD(String s){
		return s.substring(16, 21);
	}
	/**
	 * Identifica a constante
	 * @Code private String getCONSTANTE(String s){}
	 * @param s
	 * @return string de represatação binária
	 */
	private String getCONSTANTE(String s){
		return s.substring(16, 32);
	}
	/**
	 * Identifica o tipo de operação. (R, I ou J)
	 * @Code private char tipoOp(String s){} 
	 * @param s
	 * @return char com o tipo (r==R, i==I, j==J)
	 */
	private char tipoOp(String s){
		String t = s.substring(0, 6);
		if(t.equals("000000"))
			return 'r';
		
		if(t.equals("100011") 
				|| t.equals("001000") 
				|| t.equals("000100") 
				|| t.equals("000101")
				|| t.equals("001010")
				|| t.equals("101011"))
			return 'i';
		
		if(t.equals("000010") || t.equals("000011"))
			return 'j';
		
		return 'z';
	}
	/**
	 * Identifica o tipo de função no formato I
	 * @Code private int tipoOpI(String s){}
	 * @param s
	 * @return int com o índice da função
	 */
	private int tipoOpI(String s){
		String t = s.substring(0, 6);
		
		if(t.equals("001000"))//addi
			return 1;
		
		if(t.equals("001010"))//slti
			return 2;
		
		if(t.equals("100011"))//lw
			return 3;
		
		if(t.equals("101011"))//sw
			return 4;
		
		if(t.equals("000100"))//beq
			return 5; 

		if(t.equals("000101"))//bne
			return 6;
			
		return -1;
	}
	
	/**
	 * Identifica o tipo de função no formato J
	 * @Code private int tipoOpJ(String s){}
	 * @param s
	 * @return int com o índice da função
	 */
	private int tipoOpJ(String s){
		String t = s.substring(0, 6);
		
		if(t.equals("000010"))//j
			return 1;
		
		if(t.equals("000011"))//jal
			return 2;
		
		return -1;
	}
	
	/**
	 * Identifica o tipo da função do formato R 
	 * @Code private int functionR(String s){}
	 * @param s
	 * @return int com o índice da função
	 */
	private int functionR(String s){
		String t = s.substring(s.length()-11, s.length());
		
		if(t.equals("00000100000"))//add
			return 1;
		
		if(t.equals("00000100010"))//sub
			return 2;
		
		if(t.equals("00000101010"))//slt
			return 3;
		
		if(t.equals("00000001000"))//jr
			return 4;
		
		if(t.equals("00000000001"))//hlt
			return 5;
		
		return -1;
	}
	
	/**
	 * Busca o índice, fim arquivo
	 * @Code private int identificaHTL(List<String> list){}
	 * @param list
	 * @return Retorna um inteiro contendo o índice fim arquivo
	 */
	private int identificaHTL(List<String> list){
		for(int i=0; i < list.size(); i++){
			if(list.get(i).equals("00000000000000000000000000000001"))
				return i;
		}
		return -1;
	}
	
	
	
}
