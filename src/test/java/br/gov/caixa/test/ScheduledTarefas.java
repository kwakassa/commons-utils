package br.gov.caixa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* Exemplo em Executa uma Tarefa periodicamente (Nesse caso, nao tem fim)*/
class Tarefa implements Runnable{
	Random aleatorio = new Random();
	public void run() {
		List<Integer> listaNumeros = new ArrayList<Integer>();
		for(int i=1;i<=6;i++){
			listaNumeros.add(aleatorio.nextInt(100));
		}
		System.out.println("Palpite Mega-Sena: " + listaNumeros);
	}	
}

public class ScheduledTarefas {
	public static void main(String[] args){
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);
		pool.scheduleAtFixedRate(new Tarefa(), 5, 10, TimeUnit.SECONDS);
	}

}
