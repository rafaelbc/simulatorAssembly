/**
 * 
 */
package br.com.senac.oac.bean;

/**
 * Contêm todos os registradores da arquitetura MIPS 
 */
public interface MemoriaDeRegistradores {
	/**
	 * default -1
	 * representação {0}
	 * Uso {constante zero}
	 */
	public int $zero = -1;
	
	/**
	 * default -1
	 * representação {2 e 3}
	 * uso {valores de resultado da função}
	 */
	public int $v0 = -1;
	/**
	 * default -1
	 * representação {2 e 3}
	 * uso {valores de resultado da função}
	 */
	public int $v1 = -1;
	
	/**
	 * default -1
	 * representação {4 e 7}
	 * uso {Argumentos da função}
	 */
	public int $a0 = -1;
	/**
	 * default -1
	 * representação {4 e 7}
	 * uso {Argumentos da função}
	 */
	public int $a1 = -1;
	/**
	 * default -1
	 * representação {4 e 7}
	 * uso {Argumentos da função}
	 */
	public int $a2 = -1;
	/**
	 * default -1
	 * representação {4 e 7}
	 * uso {Argumentos da função}
	 */
	public int $a3 = -1;
	
	/**
	 * default -1
	 * representação {8 e 15}
	 * uso {Dados temporários}
	 */
	public int $t0 = -1;
	/**
	 * default -1
	 * representação {8 e 15}
	 * uso {Dados temporários}
	 */
	public int $t1 = -1;
	/**
	 * default -1
	 * representação {8 e 15}
	 * uso {Dados temporários}
	 */
	public int $t2 = -1;
	/**
	 * default -1
	 * representação {8 e 15}
	 * uso {Dados temporários}
	 */
	public int $t3 = -1;
	/**
	 * default -1
	 * representação {8 e 15}
	 * uso {Dados temporários}
	 */
	public int $t4 = -1;
	/**
	 * default -1
	 * representação {8 e 15}
	 * uso {Dados temporários}
	 */
	public int $t5 = -1;
	/**
	 * default -1
	 * representação {8 e 15}
	 * uso {Dados temporários}
	 */
	public int $t6 = -1;
	/**
	 * default -1
	 * representação {8 e 15}
	 * uso {Dados temporários}
	 */
	public int $t7 = -1;
	
	/**
	 * default -1
	 * representação {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s0 = -1;
	/**
	 * default -1
	 * representação {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s1 = -1;
	/**
	 * default -1
	 * representação {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s2 = -1;
	/**
	 * default -1
	 * representação {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s3 = -1;
	/**
	 * default -1
	 * representação {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s4 = -1;
	/**
	 * default -1
	 * representação {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s5 = -1;
	/**
	 * default -1
	 * representação {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s6 = -1;
	/**
	 * default -1
	 * representação {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s7 = -1;
	
	/**
	 * default -1
	 * representação {24 e 25}
	 * uso {Dados temporários}
	 */
	public int $t8 = -1;
	/**
	 * default -1
	 * representação {24 e 25}
	 * uso {Dados temporários}
	 */
	public int $t9 = -1;
	
	/**
	 * default -1
	 * representação {28}
	 * uso {Global pointer}
	 */
	public int $gp = -1;
	
	/**
	 * default -1
	 * representação {29}
	 * uso {Stack pointer}
	 */
	public int $sp = -1;
	
	/**
	 * default -1
	 * representação {30}
	 * uso {Frame pointer}
	 */
	public int $fp = -1;
	
	/**
	 * default -1
	 * representação {31}
	 * uso {Endereço de retorno}
	 */
	public int $ra = -1;
}
