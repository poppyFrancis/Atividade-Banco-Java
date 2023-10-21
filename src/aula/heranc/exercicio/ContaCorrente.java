package aula.heranc.exercicio;

import java.math.BigDecimal;

public class ContaCorrente extends ContaBancaria {

	private static ContaCorrente contaCorrente;
	
	private ContaCorrente() { }
	
	public static ContaCorrente getInstanceContaCorrente() {
		if(contaCorrente == null) {
			contaCorrente = new ContaCorrente();
		}
		return contaCorrente;
	}
	
	private static BigDecimal chequeEspecial = new BigDecimal("0");
	
	public static boolean usarChequeEspecial(BigDecimal valor) {
		if(chequeEspecial.compareTo(valor)>=0) {
			chequeEspecial = chequeEspecial.subtract(valor);
			return true;
		} 
		return false;
	}
	
	public BigDecimal verChequeEspecial() {
		return chequeEspecial;
	}
	
	public void aumentarChequeEspecial(BigDecimal valor) {
		chequeEspecial = chequeEspecial.add(valor);
	}
	
}
