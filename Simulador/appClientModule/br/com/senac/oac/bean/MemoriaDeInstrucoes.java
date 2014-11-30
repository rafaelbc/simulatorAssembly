package br.com.senac.oac.bean;

/**
 * Instruções da arquitetura MIPS
 */
public interface MemoriaDeInstrucoes {

	//Instruções, formato R
	/**
	 * rd = rs + rt
	 * @param $RD
	 * @param $RS
	 * @param $RT
	 */
	public void add(Registrador $RD, Registrador $RS, Registrador $RT);
	
	/**
	 * rd = rs - rt
	 * @param $RD
	 * @param $RS
	 * @param $RT
	 */
	public void sub(Registrador $RD, Registrador $RS, Registrador $RT);
	
	/**
	 * se rs < rt, rd = 1, senão rd = 0
	 * @param $RS
	 * @param $RD
	 */
	public void slt(Registrador $RD, Registrador $RS, Registrador $RT);
	
	/**
	 * PC = rs
	 * @param $RS
	 */
	public void jr(Registrador $RS);
	
	/**
	 * Encerra a execução do programa
	 * @param $HTL
	 */
	public boolean hlt(boolean $HTL);
	
	//instruções, formato I
	
	/**
	 * rd = rs + constante
	 * @param $RD
	 * @param $RS
	 * @param $CONSTANTE
	 */
	public void addi(Registrador $RD, Registrador $RS, int $CONSTANTE);
	
	/**
	 * se rs < constante, rt = 1, senão rt = 0
	 * @param $RS
	 * @param $RT
	 * @param $CONSTANTE
	 */
	public void slti(Registrador $RS, Registrador $RT, int $CONSTANTE);
	
	/**
	 * rt = MEM[rs + imediato]
	 * @param $RT
	 * @param $RS
	 * @param $IMEDIATO
	 */
	public void lw(Registrador $RT, Registrador $RS, int $IMEDIATO);
	
	/**
	 * MEN[rs + imediato] = rt
	 * @param $RS
	 * @param $IMEDIATO
	 * @param $RT
	 */
	public void sw(Registrador $RS, int $IMEDIATO, Registrador $RT);
	
	/**
	 * se rs == rt então PC = PC + 4 + (imediato x 4)
	 * @param $RS
	 * @param $RT
	 */
	public void beq(Registrador $RS, Registrador $RT, int $IMEDIATO);
	
	/**
	 * se rs != rt então PC = PC + 4 + (imediato x 4)
	 * @param $RS
	 * @param $RT
	 */
	public void bne(Registrador $RS, Registrador $RT, int $IMEDIATO);
	
	//instruções, formato J
	
	/**
	 * PC = (PC + 4)31-28|(endereco x 4)
	 * @param $ENDERECO
	 */
	public void j(int $ENDERECO);
	
	/**
	 * ra = PC + 4; PC = (PC + 4)31-28|(endereco x 4)
	 */
	public void jal();
}
