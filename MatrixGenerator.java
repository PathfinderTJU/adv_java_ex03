package cn.tju.edu.ex03;

public class MatrixGenerator {
	
	private int row;
	private int column;
	private double[][] matrix;
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public double[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
	}

	public MatrixGenerator() {
		this.row = 0;
		this.column = 0;
		this.matrix = null;
	}
	
	public void generateRow() {
		this.row = 1000;
	}
	
	public void generateColumn() {
		this.column = 1000;
	}
	
	public void generateMatrix() {
		this.matrix = new double[this.row][this.column];
		for (int i = 0 ; i < this.row ; i++) {
			for (int j = 0 ; j < this.column ; j++) {
				this.matrix[i][j] = Math.random()*10;
			}
		}
	}
	
}
