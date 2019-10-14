package br.gov.caixa.test;

import br.com.utils.helper.CalculaDigitoCNPJ;

public class TestaDigitoCnpj {

	public static void main(String[] args) {
		String[] numeros = { "111111111111", "000000000000", "309733740001", "316231410001" };
		CalculaDigitoCNPJ calculaDigitoCnpj = new CalculaDigitoCNPJ();
		for (String numero : numeros) {
			System.out.println(numero + "-" + calculaDigitoCnpj.calculaDigitoCnpj(numero));
		}
	}

}
