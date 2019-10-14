package br.gov.caixa.test;

import br.com.utils.helper.CalculaDigitoCPF;

public class TestaDigitoCpf {

	public static void main(String[] args) {
		String[] numeros = { "111111111", "000000000", "305253388", "123456789" ,"449365468"};
		CalculaDigitoCPF calculaDigitoCPF = new CalculaDigitoCPF();
		for (String numero : numeros) {
			System.out.println(numero + "-" + calculaDigitoCPF.calculaDigitoCpf(numero));
		}
	}

}
