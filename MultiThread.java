package cn.tju.edu.ex03;

public class MultiThread extends Strategy{
	
	public MultiThread() {
		super();
	}
	
	@Override
	public double[][] matrixMul(MatrixGenerator m1, MatrixGenerator m2) throws RuntimeException{
		int row1 = m1.getRow();
		int column1 = m1.getColumn();
		int row2 = m2.getRow();
		int column2 = m2.getColumn();
		
		if (column1 != row2) {
			throw new RuntimeException("Multiplication has no meaning.");
		}
		
		int row = row1;
		int column = column2;
		double[][] result = new double[row][column];
		
		MyThread thread1 = new MyThread(m1, m2, result, 0);
		MyThread thread2 = new MyThread(m1, m2, result, 1);
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		
		try {
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
