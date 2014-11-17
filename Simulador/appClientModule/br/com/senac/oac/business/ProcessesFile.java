package br.com.senac.oac.business;

import java.util.ArrayList;
import java.util.List;

import br.com.senac.oac.bean.MemoriaPrincipal;
import br.com.senac.oac.dao.GenericDAO;

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
	public void processaFile(){
		
		 List<String> list = genericDAO.readFile();
		 List<String> lineBinary = new ArrayList<String>();
		 //Object ALU
		 ALU alu = new ALU();
		 
		
			 
		 
		 
		for(String line : list)
			lineBinary.add(Convert.toBinary(line));
		
		//create new pilha
		alu.setMemPrincipal(new MemoriaPrincipal( Integer.parseInt(Convert.toDecimal(list.get(2))) ));
		
		//print
		for(String line : lineBinary){
			Status.printStatus(alu);
			System.out.println(line);
		}
		
	}
	
	
	
}
