package aula.heranc.exercicio;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public class App {

	private static boolean isNumero(String valor) {
		return valor != null && valor.matches("[0.0-9.0]*");
	}

	public static void main(String[] args) {

		int controleWhile = 0;
		String[] opcoes = { "Conta Corrente", "Conta Poupança", "Sair" };
		String[] opcaoEscolhas = { "Retornar", "Sair" };

		int escolhaOpcoes = JOptionPane.showOptionDialog(null, "Escolha qual você quer cadastrar", "Banco Ital",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

		if (!(escolhaOpcoes == JOptionPane.CLOSED_OPTION) && !(escolhaOpcoes == JOptionPane.CANCEL_OPTION)) {
			String cadastrar = opcoes[escolhaOpcoes];
			if (cadastrar.equals(opcoes[0])) {
				while (controleWhile == 0) {
					String[] opcao = { "Saldo", "Cheque Especial", "Sair" };
					escolhaOpcoes = JOptionPane.showOptionDialog(null, "Escolha uma ação para prosseguir",
							"Banco Ital - Conta Corrente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
							null, opcao, opcao[0]);

					if (escolhaOpcoes == 0)
						while (true) {
							String[] opcoeSaldo = { "Meu Saldo", "Depositar", "Sacar", "Retornar", "Sair" };
							int escolhaOpcoesSaldo = JOptionPane.showOptionDialog(null, "Utilize o item desejado",
									"Conta Corrente - Saldo", JOptionPane.DEFAULT_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null, opcoeSaldo, opcoeSaldo[0]);
							int escolhas;
							if (escolhaOpcoesSaldo == 0) {
								escolhas = JOptionPane.showOptionDialog(null, "Voce possui um saldo de: R$"
										+ ContaCorrente.getInstanceContaCorrente().exibirSaldo() + " na sua conta",
										"Saldo - Meu Saldo", JOptionPane.DEFAULT_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null, opcaoEscolhas, opcaoEscolhas[0]);
								if (escolhas == 0) {
									continue;
								} else {
									controleWhile++;
									break;
								}
							} else if (escolhaOpcoesSaldo == 1) {
								String valorDeposito = JOptionPane.showInputDialog(null, "Digite o valor do deposito",
										"Saldo - Depositar", JOptionPane.INFORMATION_MESSAGE);
								if (isNumero(valorDeposito)) {
									ContaCorrente.getInstanceContaCorrente().depositar(new BigDecimal(valorDeposito));
									continue;
								} else {
									int escolhaOpcaoContemLetra = JOptionPane.showOptionDialog(null,
											"Valor digitado inválido, tente novamente", "Deposito - Erro",
											JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
											opcaoEscolhas, opcaoEscolhas[0]);
									if (escolhaOpcaoContemLetra == 0) {
										continue;
									} else {
										controleWhile++;
										break;
									}
								}
							} else if (escolhaOpcoesSaldo == 2) {
								String valorSacar = JOptionPane.showInputDialog(null, "Digite o valor do saque",
										"Saldo - Sacar", JOptionPane.INFORMATION_MESSAGE);
								if (isNumero(valorSacar) 
										&& ContaCorrente.getInstanceContaCorrente().exibirSaldo().compareTo(new BigDecimal(valorSacar))>=0 
										|| ContaCorrente.getInstanceContaCorrente().verChequeEspecial().compareTo(new BigDecimal(valorSacar))>=0) {
									ContaCorrente.getInstanceContaCorrente().sacar(new BigDecimal(valorSacar));
									continue;
								} else {
									int escolhaOpcaoContemLetra = JOptionPane.showOptionDialog(null,
											"Valor digitado inválido ou saldo insuficiente. Tente novamente", "Sacar - Erro",
											JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
											opcaoEscolhas, opcaoEscolhas[0]);
									if (escolhaOpcaoContemLetra == 0) {
										continue;
									} else {
										controleWhile++;
										break;
									}
								}
							} else if (escolhaOpcoesSaldo == 3) {
								break;
							} else {
								controleWhile++;
								break;
							}
						}

					else if (escolhaOpcoes == 1)
						while (true) {
							String[] opcoesChequeEspecial = { "Saldo Cheque Especial", "Aumentar Saldo Cheque Especial",
									"Retornar", "Sair" };
							int escolhaOpcoesChequeEspecial = JOptionPane.showOptionDialog(null,
									"Utilize o item desejado", "Conta Correte - Cheque Especial",
									JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
									opcoesChequeEspecial, opcoesChequeEspecial[0]);
							int escolhas;
							if (escolhaOpcoesChequeEspecial == 0) {
								escolhas = JOptionPane.showOptionDialog(null,
										"Voce possui um saldo de: R$"
												+ ContaCorrente.getInstanceContaCorrente().verChequeEspecial()
												+ " no Cheque Especial",
										"Cheque Especial - Saldo",
										JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
										opcaoEscolhas, opcaoEscolhas[0]);
								if (escolhas == 0) {
									continue;
								} else {
									controleWhile++;
									break;
								}
							} else if (escolhaOpcoesChequeEspecial == 1) {
								String escolhaOpcaoSaldoChequeEspecial = JOptionPane.showInputDialog(null,
										"Digite o valor do Cheque Especial",
										"Cheque Especial - Aumentar Saldo",
										JOptionPane.INFORMATION_MESSAGE);
								if (isNumero(escolhaOpcaoSaldoChequeEspecial)) {
									ContaCorrente.getInstanceContaCorrente()
											.aumentarChequeEspecial(new BigDecimal(escolhaOpcaoSaldoChequeEspecial));
									continue;
								} else {
									int escolhaOpcaoContemLetra = JOptionPane.showOptionDialog(null,
											"Valor digitado inválido, tente novamente",
											"Aumentar Saldo - Erro",
											JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
											opcaoEscolhas, opcaoEscolhas[0]);
									if (escolhaOpcaoContemLetra == 0) {
										continue;
									} else {
										controleWhile++;
										break;
									}
								}
							} else if (escolhaOpcoesChequeEspecial == 2) {
								break;
							} else {
								controleWhile++;
								break;
							}
						}
					else {
						controleWhile++;
						break;
					}

				}
			} else if (cadastrar.equals(opcoes[1])) {
				while (controleWhile == 0) {
					String[] opcao = { "Meu Saldo", "Simular Rendimento", "Sair"};
					escolhaOpcoes = JOptionPane.showOptionDialog(null, "Escolha uma ação para prosseguir",
							"Banco Ital - Conta Poupança", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
							null, opcao, opcao[0]);
					if (escolhaOpcoes == 0) {
						while (true) {
							String[] opcoeSaldo = { "Meu Saldo", "Depositar", "Sacar", "Retornar", "Sair" };
							int escolhaOpcoesSaldo = JOptionPane.showOptionDialog(null, "Utilize o item desejado",
									"Conta Corrente - Saldo", JOptionPane.DEFAULT_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null, opcoeSaldo, opcoeSaldo[0]);
							int escolhas;
							if (escolhaOpcoesSaldo == 0) {
								escolhas = JOptionPane.showOptionDialog(null, "Voce possui um saldo de: R$" +
										ContaPoupanca.getInstanceContaPoupanca().exibirSaldo() + " na sua conta",
										"Saldo - Meu Saldo", JOptionPane.DEFAULT_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null, opcaoEscolhas, opcaoEscolhas[0]);
								if (escolhas == 0) {
									continue;
								} else {
									controleWhile++;
									break;
								}
							} else if (escolhaOpcoesSaldo == 1) {
								String valorDeposito = JOptionPane.showInputDialog(null, "Digite o valor do deposito",
										"Saldo - Depositar", JOptionPane.INFORMATION_MESSAGE);
								if (isNumero(valorDeposito)) {
									ContaPoupanca.getInstanceContaPoupanca().depositar(new BigDecimal(valorDeposito));
									continue;
								} else {
									int escolhaOpcaoContemLetra = JOptionPane.showOptionDialog(null,
											"Valor digitado inválido, tente novamente", "Deposito - Erro",
											JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
											opcaoEscolhas, opcaoEscolhas[0]);
									if (escolhaOpcaoContemLetra == 0) {
										continue;
									} else {
										controleWhile++;
										break;
									}
								}
							} else if (escolhaOpcoesSaldo == 2) {
								String valorSacar = JOptionPane.showInputDialog(null, "Digite o valor do saque",
										"Saldo - Sacar", JOptionPane.INFORMATION_MESSAGE);
								if (isNumero(valorSacar) 
										&& ContaPoupanca.getInstanceContaPoupanca().exibirSaldo().compareTo(new BigDecimal(valorSacar))>=0) {
									ContaPoupanca.getInstanceContaPoupanca().sacar(new BigDecimal(valorSacar));
									continue;
								} else {
									int escolhaOpcaoContemLetra = JOptionPane.showOptionDialog(null,
											"Valor digitado inválido ou saldo insuficiente. Tente novamente", "Sacar - Erro",
											JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
											opcaoEscolhas, opcaoEscolhas[0]);
									if (escolhaOpcaoContemLetra == 0) {
										continue;
									} else {
										controleWhile++;
										break;
									}
								}
							} else if (escolhaOpcoesSaldo == 3) {
								break;
							} else {
								controleWhile++;
								break;
							}
							
						}
					} else if (escolhaOpcoes == 1) {
						while(true) {
						String[] opcaoRendimento = { "Taxa de Rendimento", "Simular", "Retornar", "Sair" };
						int escolhaOpcaoRendimento = JOptionPane.showOptionDialog(null, "Escolha a opção desejada",
								"Conta Poupança - Simular Rendimento", JOptionPane.INFORMATION_MESSAGE,
								JOptionPane.DEFAULT_OPTION, null, opcaoRendimento, opcaoRendimento[0]);
						if (escolhaOpcaoRendimento == 0) {
							int escolha = JOptionPane.showOptionDialog(null,
									"A taxa de rendimento atualmente está em: "
											+ ContaPoupanca.getInstanceContaPoupanca().verTaxaRendimento(),
									"Simular Rendimento - Taxa de Rendimento", JOptionPane.INFORMATION_MESSAGE,
									JOptionPane.DEFAULT_OPTION, null, opcaoEscolhas, opcaoEscolhas[0]);
							if (escolha == 0) {
								continue;
							} else {
								controleWhile++;
								break;
							}
						} else if(escolhaOpcaoRendimento==1){
							 String mesesRendido = JOptionPane.showInputDialog(null, "Digite a quantidade de meses que você quer simular. Saldo atual: " + ContaPoupanca.getInstanceContaPoupanca().exibirSaldo(),
										"Simular Rendimento - Simular", JOptionPane.QUESTION_MESSAGE);
							 if (isNumero(mesesRendido) && ContaPoupanca.getInstanceContaPoupanca().exibirSaldo().compareTo(BigDecimal.valueOf(0))>0) { // 0 - 0 = 0
								 		JOptionPane.showOptionDialog(null,
											"Valor rendido: " + ContaPoupanca.getInstanceContaPoupanca().calcularRendimento(Integer.valueOf(mesesRendido)), 
											"Simular", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
											opcaoEscolhas, opcaoEscolhas[0]);
									continue;
								} else {
									int escolhaOpcaoContemLetra = JOptionPane.showOptionDialog(null,
											"Valor digitado inválido, tente novamente", "Simular - Erro",
											JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
											opcaoEscolhas, opcaoEscolhas[0]);
									if (escolhaOpcaoContemLetra == 0) {
										continue;
									} else {
										controleWhile++;
										break;
									}
								}

						} else if (escolhaOpcaoRendimento == 2) {
							break;
						} else {
							controleWhile++;
							break;
						}

					}
					}
				}

			}
		}
	}
}
