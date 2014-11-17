package br.com.senac.oac.bean;

/**
 * Instru��es da arquitetura MIPS
 */
public interface MemoriaDeInstrucoes {

	//Instru��es, formato R
	/**
	 * rd = rs + rt
	 * @param $RD
	 * @param $RS
	 * @param $RT
	 */
	public void add(int $RD, int $RS, int $RT);
	
	/**
	 * rd = rs - rt
	 * @param $RD
	 * @param $RS
	 * @param $RT
	 */
	public void sub(int $RD, int $RS, int $RT);
	
	/**
	 * se rs < rt, rd = 1, sen�o rd = 0
	 * @param $RS
	 * @param $RD
	 */
	public void slt(int $RD, int $RS, int $RT);
	
	/**
	 * PC = rs
	 * @param $RS
	 */
	public void jr(int $RS);
	
	/**
	 * Encerra a execu��o do programa
	 * @param $HTL
	 */
	public void hlt(boolean $HTL);
	
	//instru��es, formato I
	
	/**
	 * rd = rs + constante
	 * @param $RD
	 * @param $RS
	 * @param $CONSTANTE
	 */
	public void addi(int $RD, int $RS, int $CONSTANTE);
	
	/**
	 * se rs < constante, rt = 1, sen�o rt = 0
	 * @param $RS
	 * @param $RT
	 * @param $CONSTANTE
	 */
	public void slti(int $RS, int $RT, int $CONSTANTE);
	
	/**
	 * rt = MEM[rs + imediato]
	 * @param $RT
	 * @param $RS
	 * @param $IMEDIATO
	 */
	public void lw(int $RT, int $RS, int $IMEDIATO);
	
	/**
	 * MEN[rs + imediato] = rt
	 * @param $RS
	 * @param $IMEDIATO
	 * @param $RT
	 */
	public void sw(int $RS, int $IMEDIATO, int $RT);
	
	/**
	 * se rs == rt ent�o PC = PC + 4 + (imediato x 4)
	 * @param $RS
	 * @param $RT
	 */
	public void beq(int $RS, int $RT);
	
	/**
	 * se rs != rt ent�o PC = PC + 4 + (imediato x 4)
	 * @param $RS
	 * @param $RT
	 */
	public void bne(int $RS, int $RT);
	
	//instru��es, formato J
	
	/**
	 * PC = (PC + 4)31-28|(endereco x 4)
	 * @param $PC
	 */
	public void j(int $PC);
	
	/**
	 * ra = PC + 4; PC = (PC + 4)31-28|(endereco x 4)
	 * @param $RA
	 * @param $PC
	 */
	public void jal(int $RA, int $PC);
}
