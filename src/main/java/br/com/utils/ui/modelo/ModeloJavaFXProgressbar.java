package br.com.utils.ui.modelo;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/* Exemplo Retirado de: "https://pt.stackoverflow.com/questions/49101/preencher-progressbar-em-javafx" */
public class ModeloJavaFXProgressbar extends Application{
	

	    @Override
	    public void start(Stage primaryStage) {
	        ProgressBar barra = new ProgressBar();
	        Button btn = new Button("Carregar");
	        Label status = new Label("Novo");

	        btn.setOnAction((ActionEvent acao) -> {
	            //criando um classe anônima Service que cria uma Task que também é anônima
	            //a classe Service serve para gerenciar threads em JavaFX 
	            Service<Void> servico = new Service<Void>() {
	                @Override
	                protected Task<Void> createTask() {
	                    return new Task<Void>() {
	                        @Override
	                        protected Void call() throws Exception {
	                            //Task tem duas property interessantes para usar junto a um ProgressBar
	                            //a messageProperty, que pode ser ligada a outra StringProperty
	                            //para transmitir uma mensagem,
	                            //e a progressProperty, que serve para mandar valores númericos a uma
	                            //ProgressBar ou ProgressIndicator
	                            updateMessage("Carregando...");
	                            Thread.sleep(300);
	                            updateProgress(1, 10);
	                            for (int i = 0; i < 10; i++) {
	                                updateProgress(i + 1, 10);
	                                updateMessage("Carregando " + (i + 1) + " de 10");
	                                Thread.sleep(300);
	                            }
	                            updateMessage("Terminou");
	                            return null;
	                        }
	                    };
	                }
	            };
	            //fazendo o bind (ligando) nas proprety
	            status.textProperty().bind(servico.messageProperty());
	            barra.progressProperty().bind(servico.progressProperty());
	            //precisa inicializar o Service
	            servico.restart();
	        });

	        //criando um ui para exemplificar o uso do ProgressBar
	        VBox root = new VBox();
	        root.setAlignment(Pos.CENTER);
	        root.getChildren().addAll(status, btn, barra);

	        Scene scene = new Scene(root, 150, 150);

	        primaryStage.setTitle("Progress Bar!");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	
}
