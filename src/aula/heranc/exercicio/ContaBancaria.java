package aula.heranc.exercicio;

import java.math.BigDecimal;
import java.util.Random;

public abstract class ContaBancaria{

	private int numeroConta;
	private BigDecimal saldo = new BigDecimal("0");
	
	public ContaBancaria() {
		numeroConta = new Random().nextInt(90000) + 10000;
		ListaContaBanc.getContaBancarias().add(this);
	}
	
	protected BigDecimal depositar(BigDecimal valorDepositar) {
		if(valorDepositar.compareTo(BigDecimal.valueOf(0))>0) {
			saldo = saldo.add(valorDepositar);
		} 
			return saldo;
	}
	
	protected BigDecimal sacar(BigDecimal valorSacar) {
		if(valorSacar.compareTo(BigDecimal.valueOf(-0))>0) {
			if(this.saldo.compareTo(valorSacar)>=0) { 
				saldo = saldo.subtract(valorSacar);
			} else if (getClass().equals(ContaCorrente.class) 
					&& saldo.compareTo(valorSacar)<0 
					&& ContaCorrente.usarChequeEspecial(valorSacar.subtract(saldo))){
				saldo = saldo.subtract(valorSacar);
			}
		}
		return saldo;
	}
	
	public BigDecimal exibirSaldo() {
		return saldo;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
		
}
