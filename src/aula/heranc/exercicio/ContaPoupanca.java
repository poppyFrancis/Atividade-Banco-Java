package aula.heranc.exercicio;

import java.math.BigDecimal;

public class ContaPoupanca extends ContaBancaria{

	private final double taxaRendimento = 0.05;
	private static ContaPoupanca contaPoupanca;
	
	private ContaPoupanca() {
	}
	
	public static ContaPoupanca getInstanceContaPoupanca() {
		if(contaPoupanca == null) {
			contaPoupanca = new ContaPoupanca();
		}
		return contaPoupanca;
	}
	
	public BigDecimal calcularRendimento(int meses) {
		BigDecimal valorRendido = new BigDecimal(String.valueOf(exibirSaldo()));
		valorRendido = valorRendido.multiply(new BigDecimal("0").add(BigDecimal.valueOf(1)).add(BigDecimal.valueOf(taxaRendimento/12)).pow(meses));
	return valorRendido;
	}
	
	public String verTaxaRendimento() {
		double valorPorcentagem = taxaRendimento*100;
		return valorPorcentagem + "%";
	}
}