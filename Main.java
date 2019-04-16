package cn.tju.edu.ex03;

public class Main {
	
	public static void main(String args[]) {
		MatrixGenerator m1 = new MatrixGenerator();
		MatrixGenerator m2 = new MatrixGenerator();
		MatrixGenerator result1 = new MatrixGenerator();
		MatrixGenerator result2 = new MatrixGenerator();
		
		m1.generateRow();
		m1.generateColumn();
		m2.setRow(m1.getColumn());
		m2.generateColumn();
		m1.generateMatrix();
		m2.generateMatrix();
		
		result1.setRow(m1.getRow());
		result1.setColumn(m2.getColumn());
		result2.setRow(m1.getRow());
		result2.setColumn(m2.getColumn());
	
		Strategy s1 = new Serial();
		Strategy s2 = new MultiThread();
		
		double now = System.currentTimeMillis();
		result1.setMatrix(s1.matrixMul(m1, m2));
		double time1 = System.currentTimeMillis() - now;

		now = System.currentTimeMillis();
		result2.setMatrix(s2.matrixMul(m1, m2));
		double time2 = System.currentTimeMillis() - now;
		
		assert isEqual(result1, result2);
		
		System.out.println("Test Successfully.");
		System.out.println("time1(Serial): " + time1 + "ms");
		System.out.println("time2(MultiThread): " + time2 + "ms");
	}

	private static boolean isEqual(MatrixGenerator result1, MatrixGenerator result2) {
		for (int i = 0 ; i < result1.getRow() ; i++) {
			for (int j = 0 ; j < result1.getColumn() ; j++) {
				if (!(Math.abs(result1.getMatrix()[i][j] - result2.getMatrix()[i][j]) < 1e-7)) {
					return false;
				}
			}
		}
		return true;
	}

}
