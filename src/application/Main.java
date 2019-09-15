package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import core.NetworkTester;
import core.NetworkTrainer;

public class Main {	
	/**
	 * 	
	 * @autor Jonathan Neves
	 * @instrucao Para realizar o treinamento � necess�rio criar arquivos txt na pasta Letters com os s�mbolos de entrada conforme deseja.
	 * OBS.: Todos txt deve ter mesmo n�mero de simbolos
	 * A �ltima linha do txt � reservada para a sa�da desejada
	 * Para teste mude o arquivo Teste.txt colocando os simbolos desejados para ser identiicado
	 */
	public static void main(String[] args) throws IOException {
		
		
		boolean alreadyTraining = false;
		int choice = 0;

		while(true) {
			choice = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma op��o: \n 1 - Treinar a Rede Neural \n 2 - Testar arquivo na Rede Neural \n 3 - Encerrar o programa"));
			switch(choice) {
				case 1:
					NetworkTrainer networkTrainer = new NetworkTrainer();
					networkTrainer.startTraining();
					alreadyTraining = true;
					break;
				case 2:
					if(alreadyTraining) {
						NetworkTester networkTester = new NetworkTester();
						networkTester.startTest();	
						break;
					}else {
						JOptionPane.showMessageDialog(null, "� necess�rio treinar primeiro antes de realizar o teste!");
					}
				case 3: 
					System.exit(0);
			}
		}
	}
}
