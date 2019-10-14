package br.gov.caixa.test;

import java.util.Random;

public class RandomTest {
	
	private static Random random = new Random();
	
	public static void testeRandom1(){
		System.out.println("Random Int: " + random.nextInt(2));
	}
	
	public static void main(String[] args) {
		testeRandom1();
	}

}
