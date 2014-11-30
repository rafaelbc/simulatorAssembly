package br.com.senac.oac.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.senac.oac.business.Convert;

public final class MemoriaDeRegistradores {

	private List<Registrador> listRegistrador;
	//names register
	private String nameReg[] = {
			"$zero"," ","$v0","$v1","$a0","$a1","$a2","$a3",
			"$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7",
			"$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7",
			"$t8","$t9"," "," ","$gp","$sp","$fp","$ra"}; 

	//construtor
	//inicializa todos os construtores
	public MemoriaDeRegistradores(){
		List<Registrador> listReg = new ArrayList<Registrador>();
		
		for(int i = 0; i < 32; i++){
			Registrador reg = new Registrador();
			
			reg.setRepresentacao(Convert.toDecimalBinary(i));
			reg.setRegistrador(nameReg[i]);
			reg.setValor("");
			listReg.add(reg);
		}
		listReg.get(0).setValor("0");//init $zero == 0
		
		//create registrador PC
		Registrador pc = new Registrador();
		pc.setRegistrador("PC");
		pc.setValor("0");
		listReg.add(32, pc);
		
		setListRegistrador(listReg);
		
	}
	
	//getters and setters
	public List<Registrador> getListRegistrador() {
		return listRegistrador;
	}
	public void setListRegistrador(List<Registrador> registrador) {
		this.listRegistrador = registrador;
	}
}
