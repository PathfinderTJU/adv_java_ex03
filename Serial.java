package cn.tju.edu.ex03;

public class Serial extends Strategy{
	
	public Serial() {
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
		
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < column ; j++) {
				double temp = 0;
				for (int k = 0 ; k < column1 ; k++) {
					temp += m1.getMatrix()[i][k] * m2.getMatrix()[k][j];
				}
				result[i][j] = temp;
			}
		}
		
		return result;
	}
	
}
