package br.gov.caixa.test;

public class TesteAsciiCharacters {
	
	public static void main(String[] args) {
		for (int c = 32; c <= 127; c++) {
			System.out.println(c + ": " + (char) c);
		}
		for (int c = 161; c <= 255; c++) {
			System.out.println(c + ": " + (char) c);
		}
	}
}
