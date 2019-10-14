package br.com.utils.helper;

import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

public class StringUtil {
	
	public static String byteToHexa(byte[] bytes,boolean formated){
		StringBuilder stringBuilder = new StringBuilder();
		String space = (formated ? " " : "");
		for (byte b : bytes) {
			stringBuilder.append(String.format("%02X" + space, b));
		}
		return stringBuilder.toString();
	}
	
	public static String byteToHexa(byte[] bytes){
		return byteToHexa(bytes, false);
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public static String toHexString(byte[] bytes) {
	    return DatatypeConverter.printHexBinary(bytes);
	}

	public static byte[] toByteArray(String hexa) {
	    return DatatypeConverter.parseHexBinary(hexa);
	}
		
	public byte[] encodeStringToBase64Byte(String string){
		return Base64.getEncoder().encode(string.getBytes());
	}
	
	public byte[] dencodeStringToBase64Byte(String string){
		return Base64.getDecoder().decode(string.getBytes());
	}
	
	public static void main(String[] args) {
		String string = "1234";
		byte[] stringBytes = string.getBytes();
		String byteToHexa = byteToHexa(stringBytes);
		System.out.println("Dado de Entrada: " + string);
		System.out.println("byteToHexa: " + byteToHexa(stringBytes));
		System.out.println("hexStringToByteArray: " + hexStringToByteArray(byteToHexa));
		System.out.println("toHexString: " + toHexString(stringBytes));
		System.out.println("toByteArray: " + toByteArray(byteToHexa));
		System.out.println("toString: " + new String(stringBytes));
	}
}
