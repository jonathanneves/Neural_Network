package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import core.NetworkTester;
import core.NetworkTrainer;

public class Main {	
	/**
	 * 	
	 * @autor Jonathan Neves, Vilmar Mendes Jr, Adriano Karas
	 * @instrucao
	 * Como realizar o treinamento:
	 * 1� Crie arquivos txt na pasta Letters com todos os inputs e na �ltima linha do txt defina a sa�da desejada.
	 * Os inputs devem seguir o padr�o: '.' = -1 '#' = 1  'etc' = 0;
	 * Os outputs devem seguir o padr�o: '.' = -1 'etc' = 1;
	 * OBS.: Todos os arquivos deve ter o mesmo n�mero de inputs e de output.
	 * 
	 * Como realizar o teste:
	 * 2� Crie um arquivo chamado TESTE.txt, coloque apenas os inputs para Rede Neural classificar no teste
	 * OBS.: Deve ter o mesmo n�mero de inputs que os outros arquivos.
	 * 
	 * Como configurar o algoritmo:
	 * -Na classe Variables voc� pode definir o n�mero de LAYER j desejado. Recomendado ser igual ao n�mero de inputs.
	 * -Na Classse Constants voc� pode definir o n�mero de ep�cas em EPOCHS. � o n�mero de vezes que o algoritmo vai realizar o treinamento antes de parar.
	 * 
	 * Execute o algoritmo, primeiro realize o treinamento (1) e depois realize o teste (2)
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
