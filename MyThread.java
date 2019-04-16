package cn.tju.edu.ex03;

public class MyThread implements Runnable{
	
	private int delta;
	private double[][] result;
	private MatrixGenerator m1;
	private MatrixGenerator m2;
	
	public MyThread() {
		
	}
	
	public MyThread(MatrixGenerator m1, MatrixGenerator m2, double[][] result, int delta) {
		this.m1 = m1;
		this.m2 = m2;
		this.result = result;
		this.delta = delta;
	}
	
	@Override
	public void run() {
		for (int i = delta ; i < m1.getRow() ; i+=2) {
			for (int j = 0 ; j < m2.getColumn() ; j++) {
				double temp = 0;
				for (int k = 0 ; k < m1.getColumn() ; k++) {
					temp += m1.getMatrix()[i][k] * m2.getMatrix()[k][j];
				}
				result[i][j] = temp;
			}
		}
	}
	
}
