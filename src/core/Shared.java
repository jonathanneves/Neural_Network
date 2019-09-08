package core;

import constants.Constants;

public class Shared implements Constants {
	
	public int inputs[] = new int[LAYER_i];
	
	public double Z_inJ[] = new double[LAYER_j];
	public double Y_inK[] = new double[LAYER_k];
	
	public double weightsV[][] = new double[LAYER_i][LAYER_j];
	public double weightsW[][] = new double[LAYER_j][LAYER_k];
	
	public double Z[] = new double[LAYER_j]; // SIGMOIDE CALCULADO
	public double Y[] = new double[LAYER_k]; // SIGMOIDE CALCULADO

	public void calculateInput() {
		double sum = 0;
		for(int j = 0; j < LAYER_j; j++) {
			for(int i = 0; i < LAYER_i; i++) {
				sum += inputs[i] * weightsV[i][j];
			}
			Z_inJ[j] = sum;
			Z[j] = sigmoid(sum);
			sum = 0;
		}
		
		for(int k = 0; k < LAYER_k; k++) {
			for(int j = 0; j < LAYER_j; j++) {
				sum += sigmoid(Z_inJ[j]) * weightsW[j][k];
			}
			Y_inK[k] = sum;
			Y[k] = sigmoid(sum);
			sum = 0;
		}
	}
	
	private double sigmoid(double x) {
		return  1 / (1 + (Math.pow(Math.E, 0 - x)));
	}
	
	public void fillInputs(char[] letters) {
		int index = 0;
		for(char c : letters) {
			if(c == HASHTAG) {
				inputs[index] = ONE_POSITIVE;
			} else if (c == DOT) {
				inputs[index] = ONE_NEGATIVE;
			} else {
				inputs[index] = ZERO;
			}
			index++;
		}
	}
	
}