/**
 * 
 */
package br.com.senac.oac.bean;

/**
 * Cont�m todos os registradores da arquitetura MIPS 
 */
public interface MemoriaDeRegistradores {
	/**
	 * default -1
	 * representa��o {0}
	 * Uso {constante zero}
	 */
	public int $zero = -1;
	
	/**
	 * default -1
	 * representa��o {2 e 3}
	 * uso {valores de resultado da fun��o}
	 */
	public int $v0 = -1;
	/**
	 * default -1
	 * representa��o {2 e 3}
	 * uso {valores de resultado da fun��o}
	 */
	public int $v1 = -1;
	
	/**
	 * default -1
	 * representa��o {4 e 7}
	 * uso {Argumentos da fun��o}
	 */
	public int $a0 = -1;
	/**
	 * default -1
	 * representa��o {4 e 7}
	 * uso {Argumentos da fun��o}
	 */
	public int $a1 = -1;
	/**
	 * default -1
	 * representa��o {4 e 7}
	 * uso {Argumentos da fun��o}
	 */
	public int $a2 = -1;
	/**
	 * default -1
	 * representa��o {4 e 7}
	 * uso {Argumentos da fun��o}
	 */
	public int $a3 = -1;
	
	/**
	 * default -1
	 * representa��o {8 e 15}
	 * uso {Dados tempor�rios}
	 */
	public int $t0 = -1;
	/**
	 * default -1
	 * representa��o {8 e 15}
	 * uso {Dados tempor�rios}
	 */
	public int $t1 = -1;
	/**
	 * default -1
	 * representa��o {8 e 15}
	 * uso {Dados tempor�rios}
	 */
	public int $t2 = -1;
	/**
	 * default -1
	 * representa��o {8 e 15}
	 * uso {Dados tempor�rios}
	 */
	public int $t3 = -1;
	/**
	 * default -1
	 * representa��o {8 e 15}
	 * uso {Dados tempor�rios}
	 */
	public int $t4 = -1;
	/**
	 * default -1
	 * representa��o {8 e 15}
	 * uso {Dados tempor�rios}
	 */
	public int $t5 = -1;
	/**
	 * default -1
	 * representa��o {8 e 15}
	 * uso {Dados tempor�rios}
	 */
	public int $t6 = -1;
	/**
	 * default -1
	 * representa��o {8 e 15}
	 * uso {Dados tempor�rios}
	 */
	public int $t7 = -1;
	
	/**
	 * default -1
	 * representa��o {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s0 = -1;
	/**
	 * default -1
	 * representa��o {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s1 = -1;
	/**
	 * default -1
	 * representa��o {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s2 = -1;
	/**
	 * default -1
	 * representa��o {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s3 = -1;
	/**
	 * default -1
	 * representa��o {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s4 = -1;
	/**
	 * default -1
	 * representa��o {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s5 = -1;
	/**
	 * default -1
	 * representa��o {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s6 = -1;
	/**
	 * default -1
	 * representa��o {16 e 23}
	 * uso {Dados salvos}
	 */
	public int $s7 = -1;
	
	/**
	 * default -1
	 * representa��o {24 e 25}
	 * uso {Dados tempor�rios}
	 */
	public int $t8 = -1;
	/**
	 * default -1
	 * representa��o {24 e 25}
	 * uso {Dados tempor�rios}
	 */
	public int $t9 = -1;
	
	/**
	 * default -1
	 * representa��o {28}
	 * uso {Global pointer}
	 */
	public int $gp = -1;
	
	/**
	 * default -1
	 * representa��o {29}
	 * uso {Stack pointer}
	 */
	public int $sp = -1;
	
	/**
	 * default -1
	 * representa��o {30}
	 * uso {Frame pointer}
	 */
	public int $fp = -1;
	
	/**
	 * default -1
	 * representa��o {31}
	 * uso {Endere�o de retorno}
	 */
	public int $ra = -1;
}
