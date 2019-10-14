package br.com.utils.teste;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

public class TestaListaCharSet {
	public static void main(String[] args) {
		SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
		
		Set<String> keySet = availableCharsets.keySet();
		
		for (String key : keySet) {
			System.out.println("Key CharSet: " + key);
			System.out.println("CharSet: " + availableCharsets.get(key).toString());
		}
	}
}
