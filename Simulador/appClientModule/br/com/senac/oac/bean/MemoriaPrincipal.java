package br.com.senac.oac.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Mem�ria principal.
 * 
 * Pilha de mem�ria
 *
 */
public class MemoriaPrincipal {
	
	List<String> memPrincipal;

	public MemoriaPrincipal(){
		setMemPrincipal(new ArrayList<String>());
	}
	
	public List<String> getMemPrincipal() {
		return memPrincipal;
	}
	private void setMemPrincipal(List<String> memPrincipal) {
		this.memPrincipal = memPrincipal;
	}
	
	public void addMemPrincipal(String s){
		this.memPrincipal.add(s);
	}
	
	public void addMemPrincipal(int indice, String s){
		this.memPrincipal.add(indice, s);
	}

}
