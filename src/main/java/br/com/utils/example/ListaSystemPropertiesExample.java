package br.com.utils.example;

import java.util.Enumeration;
import java.util.Properties;

public class ListaSystemPropertiesExample {

    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        Properties properties = System.getProperties();
        Enumeration<Object> enumeration = properties.keys();
        for (int i = 0; i < properties.size(); i++) {
            Object obj = enumeration.nextElement();
            System.out.println("Key: " + obj + "\tOutPut= " + System.getProperty(obj.toString()));
        }
    }

}
