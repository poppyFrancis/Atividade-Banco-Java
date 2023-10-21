package aula.heranc.exercicio;

import java.util.ArrayList;
import java.util.List;

public class ListaContaBanc {

	private static List<ContaBancaria> contaBancarias = new ArrayList<ContaBancaria>();

	protected static List<ContaBancaria> getContaBancarias() {
		return contaBancarias;
	}
	
	public static ContaBancaria getContaBancaria(int numConta) {
		for (ContaBancaria contaBancaria : contaBancarias) {
			if(contaBancaria.getNumeroConta() == numConta)
				return contaBancaria;
		}
		return null;
	}
	
}
