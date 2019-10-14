package br.com.utils.ui.modelo;

import org.apache.log4j.Logger;

import br.com.utils.helper.MemoriaJVMHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ModeloJavaFxUI extends Application{
	
	private static final Logger logger = Logger.getLogger(ModeloJavaFxUI.class);
	private Stage stage;
	private int windowWidth = 600;
	private int windowHeight = 320;
	private int paddingLeft = 20;
	private int paddingTop = 10;
	private int paddingSpace = 5;
	private String titulo = "";
	
	@Override
	public void start(Stage stage) throws Exception {
		/* --- Inicializa Sysouts iniciais --- */
		iniStatusDaAplicacao();
		/* --- Inicializa Componentes --- */
		iniComponentes(stage);
		/* --- Inicializa Helpers --- */
		iniHelpers();
		/* --- Mostra a Interface UI --- */
		this.stage.show();
		/* --- Posicao dos Components --- */
		iniPosicaoComponentes();
		/* --- Inicializacao dos Evento dos Componentes --- */
		initEvents();		
	}
	
	private void iniStatusDaAplicacao() {
		logger.info("Versao do Java: " + System.getProperty("java.version"));
		logger.debug(MemoriaJVMHelper.imprimeStatusMemoria(MemoriaJVMHelper.PRINT_TYPE_CUSTOM));		
	}

	private void iniComponentes(Stage stage) {
		/* --- Configuracao Inicial --- */
		this.stage = stage;
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(windowWidth, windowHeight);
		/* --- Definicao de Componentes: Caixas de texto, Botoes e etc --- */
		
		/* Adicionar no metodo addAll(), abaixo, os componentes separados com "," */
		pane.getChildren().addAll();
		/* --- Atribuicao Final e Titulo --- */
		Scene scene = new Scene(pane);
		this.stage.setScene(scene);
		this.stage.setTitle(titulo);
	}

	private void iniHelpers() {
		// TODO Auto-generated method stub		
	}

	private void iniPosicaoComponentes() {
		// TODO Auto-generated method stub		
	}

	private void initEvents() {
		// TODO Auto-generated method stub		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
