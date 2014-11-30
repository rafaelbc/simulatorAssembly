package br.com.senac.oac.business;

import br.com.senac.oac.bean.MemoriaDeInstrucoes;
import br.com.senac.oac.bean.MemoriaDeRegistradores;
import br.com.senac.oac.bean.MemoriaPrincipal;
import br.com.senac.oac.bean.Registrador;

public final class ALU implements MemoriaDeInstrucoes{

	//injection pilha
	private static MemoriaPrincipal memPrincipal;
	
	//injection register
	private static MemoriaDeRegistradores memRegister;
	
	//construct
	//inicia modeulos do sistema
	public ALU(){
		setMemRegister(new MemoriaDeRegistradores());
		setMemPrincipal(new MemoriaPrincipal());
	}
	public ALU(MemoriaPrincipal mem){
		setMemRegister(new MemoriaDeRegistradores());
		setMemPrincipal(mem);
	}
	
	//getters and setters
	public static MemoriaPrincipal getMemPrincipal() {
		return memPrincipal;
	}
	
	private void setMemPrincipal(MemoriaPrincipal memPrincipal) {
		ALU.memPrincipal = memPrincipal;
	}

	public static MemoriaDeRegistradores getMemRegister() {
		return memRegister;
	}

	private void setMemRegister(MemoriaDeRegistradores memRegister) {
		ALU.memRegister = memRegister;
	}

	/**
	 * Implements Registradorerface MemoriaDeInstrucoes
	 */
	//assinaturas Registradorers
	public void add(Registrador $RD, Registrador $RS, Registrador $RT){		
		for(Registrador r : getMemRegister().getListRegistrador()){
			if(r.getRepresentacao().equals($RD.getRepresentacao())){
				r.setValor(Convert.toDecimalBinary(
						Convert.toBinaryDecimal($RS.getValor()) 
						+ Convert.toBinaryDecimal($RT.getValor()) ));
				break;
			}
		}
	}
	public void sub(Registrador $RD, Registrador $RS, Registrador $RT){
		for(Registrador r : getMemRegister().getListRegistrador()){
			if(r.getRepresentacao().equals( $RD.getRepresentacao() ) ){
				r.setValor(Convert.toDecimalBinary(
						Convert.toBinaryDecimal($RS.getValor()) 
						- Convert.toBinaryDecimal($RT.getValor())));
				break;
			}
		}
	}
	public void slt(Registrador $RD, Registrador $RS, Registrador $RT){
		for(Registrador r : getMemRegister().getListRegistrador()){
			if(r.getRepresentacao().equals( $RD.getRepresentacao() )){
				r.setValor( 
						( Convert.toBinaryDecimal($RS.getValor()) < Convert.toBinaryDecimal($RT.getValor()) ) 
						? Convert.toDecimalBinary(1) : Convert.toDecimalBinary(0) );
				break;
			}
		}
	}
	public void jr(Registrador $RS){
		getMemRegister().getListRegistrador().get(35).setValor($RS.getValor());
	}
	public boolean hlt(boolean $HTL){
		return $HTL;
	}
	public void addi(Registrador $RD, Registrador $RS, int $CONSTANTE){
		for(Registrador r : getMemRegister().getListRegistrador()){
			if(r.getRepresentacao().equals($RD.getRepresentacao())){
				r.setValor(Convert.toDecimalBinary(
						Convert.toBinaryDecimal($RS.getValor()) + $CONSTANTE ));
				break;
			}
		}
	}
	public void slti(Registrador $RD, Registrador $RT, int $CONSTANTE){
		for(Registrador r : getMemRegister().getListRegistrador()){
			if(r.getRepresentacao().equals($RD.getRepresentacao())){
				r.setValor( 
						( Convert.toBinaryDecimal($RT.getValor()) < $CONSTANTE ) 
						? Convert.toDecimalBinary(1) : Convert.toDecimalBinary(0) );
				break;
			}
		}
	}
	public void lw(Registrador $RT, Registrador $RS, int $IMEDIATO){
		for(Registrador r : getMemRegister().getListRegistrador()){
			if(r.getRepresentacao().equals($RT.getRepresentacao())){
				r.setValor(
						getMemPrincipal().getMemPrincipal().get( 
								 (Convert.toBinaryDecimal($RS.getValor()) + $IMEDIATO) / 4 )); 
				break;
			}
		}
	}
	public void sw(Registrador $RS, int $IMEDIATO, Registrador $RT){
		for(Registrador r : getMemRegister().getListRegistrador()){
			if(r.getRepresentacao().equals($RS.getRepresentacao())){
				getMemPrincipal().addMemPrincipal( 
						( Convert.toBinaryDecimal($RS.getValor()) + $IMEDIATO) / 4,
						$RT.getValor());
				break;
			}
		}
	}
	public void beq(Registrador $RS, Registrador $RT, int $IMEDIATO){
		for(Registrador r : getMemRegister().getListRegistrador()){
			if(r.getRepresentacao().equals($RS.getRepresentacao())){
				for(Registrador r2 : getMemRegister().getListRegistrador()){
					if(r2.getRepresentacao().equals($RT.getRepresentacao())){
						
						if( Convert.toBinaryDecimal($RS.getValor()) ==  Convert.toBinaryDecimal($RT.getValor())){
						
							getMemRegister().getListRegistrador().get(32).setValor(
									Convert.toDecimalBinary(
											(( (Convert.toBinaryDecimal(getMemRegister().getListRegistrador().get(32).getValor())+1)
											* 4 + ($IMEDIATO * 4)))/4)	);
						}
						break;
					}
				}
				
				break;
			}
		}
	}
	public void bne(Registrador $RS, Registrador $RT, int $IMEDIATO){
		for(Registrador r : getMemRegister().getListRegistrador()){
			if(r.getRepresentacao().equals($RS.getRepresentacao())){
				for(Registrador r2 : getMemRegister().getListRegistrador()){
					if(r2.getRepresentacao().equals($RT.getRepresentacao())){
						
						if( Convert.toBinaryDecimal($RS.getValor()) !=  Convert.toBinaryDecimal($RT.getValor())){
							getMemRegister().getListRegistrador().get(32).setValor(
									Convert.toDecimalBinary(
											(( (Convert.toBinaryDecimal(getMemRegister().getListRegistrador().get(32).getValor())+1)
											* 4 + ($IMEDIATO * 4)))/4)	);
						}
						break;
					}
				}
				
				break;
			}
		}
	}							
	public void j(int $ENDERECO){
		getMemRegister().getListRegistrador().get(32).setValor( 
				Convert.toDecimalBinary( ($ENDERECO * 4)/4 ));
	}
	public void jal(){
		getMemRegister().getListRegistrador().get(31).setValor(
				Convert.toDecimalBinary( 
						Convert.toBinaryDecimal(getMemRegister().getListRegistrador().get(32).getValor()) + 1));
	}
}
