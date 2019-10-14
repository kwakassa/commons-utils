package br.gov.caixa.test.string;

class SourceDaString{
	private String texto;
	public String getTexto() {return texto;}
	public void setTexto(String texto) {this.texto = texto;}
}

class MudaTextoString{
	private SourceDaString sourceDaString;
	public MudaTextoString(SourceDaString sourceDaString) {this.sourceDaString = sourceDaString;}
	public void setTexto(String texto){this.sourceDaString.setTexto(texto);}
	public String getTexto(){return this.sourceDaString.getTexto();}
	
}

public class TestaReferenciaDeString {
	public static void main(String[] args) {
		//Classe com atributo compartilhado
		SourceDaString source = new SourceDaString();
		
		source.setTexto("Texto Inicial");
		//Classes que vao alterar o atributo compartilhado 
		MudaTextoString m1 = new MudaTextoString(source);
		MudaTextoString m2 = new MudaTextoString(source);
		//Alterando o conteudo compartilhado(String)
		m1.setTexto("Texto 1");
		m2.setTexto("Texto 2");
		//Realizando teste de qual Mensagem vai conter o atributo compartihado
		System.out.println("Source: " + source.getTexto());
		System.out.println("M1: " + m1.getTexto());
		System.out.println("M2: " + m2.getTexto());
		
	}
}
