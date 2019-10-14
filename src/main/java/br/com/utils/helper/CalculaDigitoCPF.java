package br.com.utils.helper;

public class CalculaDigitoCPF {
	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	private int getDigito(String numSemDigito) {
		int soma = 0;
		for (int indice = numSemDigito.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(numSemDigito.substring(indice, indice + 1));
			soma += digito * pesoCPF[pesoCPF.length - numSemDigito.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}
	
	public String calculaDigitoCpf(String numSemDigito){
		if ((numSemDigito==null) || (numSemDigito.length()!=9)){
			throw new NumberFormatException("A string do numero deve conter 9 digitos.");
		}else{
			Integer digito1 = getDigito(numSemDigito);
			Integer digito2 = getDigito(numSemDigito+digito1);
			return ""+digito1+digito2;
		}
	}
}
