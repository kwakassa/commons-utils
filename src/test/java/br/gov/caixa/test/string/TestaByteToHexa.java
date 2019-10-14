package br.gov.caixa.test.string;

public class TestaByteToHexa {

	public static void main(String[] args) {
		byte[] bytes = {-1, 0, 1, 2, 3 };
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(String.format("%02X ", b));
		}
		System.out.println(stringBuilder.toString());

	}

}
