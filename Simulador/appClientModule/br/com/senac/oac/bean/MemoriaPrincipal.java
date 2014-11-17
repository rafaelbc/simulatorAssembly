package br.com.senac.oac.bean;

/**
 * Mem�ria principal.
 * 
 * Pilha de mem�ria
 *
 */
public class MemoriaPrincipal {
	
	private int[] pilha;

	public MemoriaPrincipal(){
		setPilha(new int[100]);
	}
	public MemoriaPrincipal(int sizePilha){
		setPilha(new int[sizePilha]);
	}
	
	public int[] getPilha() {
		return pilha;
	}

	public void setPilha(int[] pilha) {
		this.pilha = pilha;
	}

}
