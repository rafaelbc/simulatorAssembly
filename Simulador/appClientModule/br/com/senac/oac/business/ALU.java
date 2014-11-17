package br.com.senac.oac.business;

import br.com.senac.oac.bean.MemoriaDeInstrucoes;
import br.com.senac.oac.bean.MemoriaDeRegistradores;
import br.com.senac.oac.bean.MemoriaPrincipal;

public final class ALU implements MemoriaDeInstrucoes, MemoriaDeRegistradores {

	//injection pilha
	private static MemoriaPrincipal memPrincipal;
	
	/**
	 * Implements interface MemoriaDeRegistradores
	 */
	//assinaturas interface
	private static final int $zero = 0;
	private static int $v0;
	private static int $v1;
	private static int $a0;
	private static int $a1;
	private static int $a2;
	private static int $a3; 
	private static int $t0;
	private static int $t1;
	private static int $t2;
	private static int $t3;
	private static int $t4;
	private static int $t5;
	private static int $t6;
	private static int $t7;
	private static int $s0;
	private static int $s1;
	private static int $s2;
	private static int $s3;
	private static int $s4;
	private static int $s5;
	private static int $s6;
	private static int $s7;
	private static int $t8;
	private static int $t9;
	private static int $gp;
	private static int $sp;
	private static int $fp;
	private static int $ra;	
	
	
	//getters and setters
	public static MemoriaPrincipal getMemPrincipal() {
		return memPrincipal;
	}
	
	public static void setMemPrincipal(MemoriaPrincipal memPrincipal) {
		ALU.memPrincipal = memPrincipal;
	}

	public static int get$v0() {
		return $v0;
	}
	public static void set$v0(int $v0) {
		ALU.$v0 = $v0;
	}
	public static int get$v1() {
		return $v1;
	}
	public static void set$v1(int $v1) {
		ALU.$v1 = $v1;
	}
	public static int get$a0() {
		return $a0;
	}
	public static void set$a0(int $a0) {
		ALU.$a0 = $a0;
	}
	public static int get$a1() {
		return $a1;
	}
	public static void set$a1(int $a1) {
		ALU.$a1 = $a1;
	}
	public static int get$a2() {
		return $a2;
	}
	public static void set$a2(int $a2) {
		ALU.$a2 = $a2;
	}
	public static int get$a3() {
		return $a3;
	}
	public static void set$a3(int $a3) {
		ALU.$a3 = $a3;
	}
	public static int get$t0() {
		return $t0;
	}
	public static void set$t0(int $t0) {
		ALU.$t0 = $t0;
	}
	public static int get$t1() {
		return $t1;
	}
	public static void set$t1(int $t1) {
		ALU.$t1 = $t1;
	}
	public static int get$t2() {
		return $t2;
	}
	public static void set$t2(int $t2) {
		ALU.$t2 = $t2;
	}
	public static int get$t3() {
		return $t3;
	}
	public static void set$t3(int $t3) {
		ALU.$t3 = $t3;
	}
	public static int get$t4() {
		return $t4;
	}
	public static void set$t4(int $t4) {
		ALU.$t4 = $t4;
	}
	public static int get$t5() {
		return $t5;
	}
	public static void set$t5(int $t5) {
		ALU.$t5 = $t5;
	}
	public static int get$t6() {
		return $t6;
	}
	public static void set$t6(int $t6) {
		ALU.$t6 = $t6;
	}
	public static int get$t7() {
		return $t7;
	}
	public static void set$t7(int $t7) {
		ALU.$t7 = $t7;
	}
	public static int get$s0() {
		return $s0;
	}
	public static void set$s0(int $s0) {
		ALU.$s0 = $s0;
	}
	public static int get$s1() {
		return $s1;
	}
	public static void set$s1(int $s1) {
		ALU.$s1 = $s1;
	}
	public static int get$s2() {
		return $s2;
	}
	public static void set$s2(int $s2) {
		ALU.$s2 = $s2;
	}
	public static int get$s3() {
		return $s3;
	}
	public static void set$s3(int $s3) {
		ALU.$s3 = $s3;
	}
	public static int get$s4() {
		return $s4;
	}
	public static void set$s4(int $s4) {
		ALU.$s4 = $s4;
	}
	public static int get$s5() {
		return $s5;
	}
	public static void set$s5(int $s5) {
		ALU.$s5 = $s5;
	}
	public static int get$s6() {
		return $s6;
	}
	public static void set$s6(int $s6) {
		ALU.$s6 = $s6;
	}
	public static int get$s7() {
		return $s7;
	}
	public static void set$s7(int $s7) {
		ALU.$s7 = $s7;
	}
	public static int get$t8() {
		return $t8;
	}
	public static void set$t8(int $t8) {
		ALU.$t8 = $t8;
	}
	public static int get$t9() {
		return $t9;
	}
	public static void set$t9(int $t9) {
		ALU.$t9 = $t9;
	}
	public static int get$gp() {
		return $gp;
	}
	public static void set$gp(int $gp) {
		ALU.$gp = $gp;
	}
	public static int get$sp() {
		return $sp;
	}
	public static void set$sp(int $sp) {
		ALU.$sp = $sp;
	}
	public static int get$fp() {
		return $fp;
	}
	public static void set$fp(int $fp) {
		ALU.$fp = $fp;
	}
	public static int get$ra() {
		return $ra;
	}
	public static void set$ra(int $ra) {
		ALU.$ra = $ra;
	}
	public static int get$zero() {
		return $zero;
	}
	
	
	/**
	 * Implements interface MemoriaDeInstrucoes
	 */
	//assinaturas interfaces
	public void add(int $RD, int $RS, int $RT){

	}
	public void sub(int $RD, int $RS, int $RT){
		
	}
	public void slt(int $RD, int $RS, int $RT){
		
	}
	public void jr(int $RS){
		
	}
	public void hlt(boolean $HTL){
		
	}
	public void addi(int $RD, int $RS, int $CONSTANTE){
		
	}
	public void slti(int $RS, int $RT, int $CONSTANTE){
		
	}
	public void lw(int $RT, int $RS, int $IMEDIATO){
		
	}
	public void sw(int $RS, int $IMEDIATO, int $RT){
		
	}
	public void beq(int $RS, int $RT){
		
	}
	public void bne(int $RS, int $RT){
		
	}
	public void j(int $PC){
		
	}
	public void jal(int $RA, int $PC){
		
	}
}
